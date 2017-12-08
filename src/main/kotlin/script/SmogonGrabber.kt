package script

import constant.StatusCodes.ok
import org.apache.http.HttpResponse
import org.apache.http.client.fluent.Request
import org.apache.http.util.EntityUtils
import java.util.*
import kotlin.collections.HashMap

// TODO: try to add some ease-of-life functions
class SmogonGrabber {

    companion object {
        private val separatorLine = "+----------------------------------------+"

        @JvmStatic
        fun grabCommonMoveNames(
                metagame: String,
                year: Int = Calendar.getInstance().get(Calendar.YEAR),
                month: Int = Calendar.getInstance().get(Calendar.MONTH) + 1,
                rank: Int = 0
        ): Map<String, List<String>> {
            var attempts = 0
            var monthVar = month
            var yearVar = year
            val pokemonNameToMoveMap = HashMap<String, List<String>>()

            var response: HttpResponse?
            do {
                val requestString= "http://www.smogon.com/stats/$yearVar-${String.format("%02d", monthVar)}/" +
                        "moveset/$metagame-$rank.txt"

                response = Request.Get(requestString).execute().returnResponse()

                if (month == 1) {
                    monthVar = 12
                    yearVar--
                } else {
                    monthVar--
                }
                attempts++
            } while (attempts <= 12 && (response != null && response.statusLine.statusCode != ok))

            if (response != null) {
                // Handle Response
                val responseString = EntityUtils.toString(response.entity)
                val scanner = Scanner(responseString)

                var currentPokemonName: String? = null
                var currentPokemonMoves: MutableList<String> = ArrayList()
                var numLineSeparators = 0
                var isNameLine = false
                var isMoveLine = false

                while (scanner.hasNextLine()) {
                    if (numLineSeparators == 1 && isNameLine) { // If line before name line - 9 per pokemon
                        // Skip the "|"
                        scanner.next()

                        val stringBuilder = StringBuilder()
                        var wordCount = 0
                        var nextString = scanner.next()

                        while (nextString != "|") {
                            if (wordCount > 0) {
                                stringBuilder.append(" ")
                            }

                            stringBuilder.append(nextString)
                            wordCount++
                            nextString = scanner.next()
                        }

                        currentPokemonName = stringBuilder.toString()
                        scanner.nextLine()
                        isNameLine = false

                    } else if (numLineSeparators == 6 && isMoveLine) {
                        // Skip "Moves" line
                        scanner.nextLine()

                        var moveWord = ""
                        while(moveWord != "Other") {

                            val stringBuilder = StringBuilder()
                            var wordCount = 0

                            // Skip "|"
                            scanner.next()
                            var nextString = scanner.next()

                            while (!nextString.contains("%")) {
                                if (wordCount > 0) {
                                    stringBuilder.append(" ")
                                }

                                stringBuilder.append(nextString)
                                wordCount++
                                nextString = scanner.next()
                            }

                            moveWord = stringBuilder.toString()

                            if (moveWord != "Other") {
                                currentPokemonMoves.add(moveWord)
                            }

                            scanner.nextLine()
                        }
                        isMoveLine = false

                    } else {
                        // Increment separator line if appropriate
                        val firstString = scanner.next()

                        if (firstString == separatorLine) {
                            numLineSeparators++

                            if (numLineSeparators == 1) {
                                isNameLine = true
                            } else if (numLineSeparators == 6) {
                                isMoveLine = true
                            } else if (numLineSeparators == 9) {
                                numLineSeparators = 0

                                if (currentPokemonName != null) {
                                    pokemonNameToMoveMap.put(currentPokemonName, currentPokemonMoves)
                                    currentPokemonName = null
                                    currentPokemonMoves = ArrayList()
                                }
                            }
                        }

                        scanner.nextLine()
                    }
                }
            }

            return pokemonNameToMoveMap
        }

        @JvmStatic
        fun grabPokemonNames(
                metagame: String,
                year: Int = Calendar.getInstance().get(Calendar.YEAR),
                month: Int = Calendar.getInstance().get(Calendar.MONTH) + 1,
                rank: Int = 0,
                count: Int = 10
        ): List<String> {
            var attempts = 0
            var monthVar = month
            var yearVar = year
            val pokemon: MutableList<String> = ArrayList()

            var response: HttpResponse?
            do {
                val requestString: String = "http://www.smogon.com/stats/$yearVar-${String.format("%02d", monthVar)}" +
                        "/$metagame-$rank.txt"

                response = Request.Get(requestString).execute().returnResponse()

                if (monthVar == 1) {
                    monthVar = 12
                    yearVar--
                } else {
                    monthVar--
                }
                attempts++
            } while (attempts <= 12 && (response != null && response.statusLine.statusCode != ok))

            if (response != null) {
                // Handle Response
                val responseString = EntityUtils.toString(response.entity)

                val scanner = Scanner(responseString)

                // Skip the first 5 lines
                for (i in 1..5) { scanner.nextLine() }

                while (pokemon.size < count && scanner.hasNextLine()) {
                    val firstString = scanner.next()

                    if (firstString == "|") {
                        // Skip number
                        scanner.next()
                        scanner.next()

                        val stringBuilder = StringBuilder()

                        var nextString = scanner.next()
                        var wordCount = 0
                        while (nextString != "|") {

                            if (wordCount > 0) {
                                stringBuilder.append(" ")
                            }

                            stringBuilder.append(nextString)
                            wordCount++
                            nextString = scanner.next()
                        }

                        pokemon.add(stringBuilder.toString())
                    }

                    // Move cursor to end
                    scanner.nextLine()
                }
            }
            return pokemon
        }
    }

}