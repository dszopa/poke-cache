package script

import constant.StatusCodes.ok
import org.apache.http.HttpResponse
import org.apache.http.client.fluent.Request
import org.apache.http.util.EntityUtils
import java.util.*

class UsageGrabber {

    companion object {
        @JvmStatic
        fun grabMetagamePokemon(
                metagame: String,
                year: Int = Calendar.getInstance().get(Calendar.YEAR),
                month: Int = Calendar.getInstance().get(Calendar.MONTH) + 1,
                rank: Int = 0,
                count: Int = 10
        ): List<String> {
            var attempts = 0
            val pokemon: MutableList<String> = ArrayList()

            var response: HttpResponse?
            do {
                val requestString: String = "http://www.smogon.com/stats/$year-${String.format("%02d", month)}" +
                        "/$metagame-$rank.txt"

                response = Request.Get(requestString).execute().returnResponse()

                if (month == 1) {
                    month.plus(11)
                    year.minus(1)
                } else {
                    month.minus(1)
                }
                attempts++
            } while (attempts <= 12 && (response != null && response.statusLine.statusCode != ok))

            if (response != null) {
                // Handle Response
                val responseString = EntityUtils.toString(response.entity)

                val scanner = Scanner(responseString)

                // Skip the first 5 lines
                for (i in 1..5) { scanner.nextLine() }

                var isEnd = false
                while (pokemon.size < count && !isEnd) {
                    if (scanner.hasNextLine()) {
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

                            // Move cursor to end
                            scanner.nextLine()

                        } else {
                            isEnd = true
                        }
                    }
                }
            }
            return pokemon
        }
    }
}