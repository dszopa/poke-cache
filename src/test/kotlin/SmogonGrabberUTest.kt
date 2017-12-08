
import junit.framework.TestCase
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import org.junit.Test
import script.SmogonGrabber

class SmogonGrabberUTest {

    @Test
    fun grabCommonMovesOctober2017() {
        val pokemonNameToMoveMap = SmogonGrabber.grabCommonMoveNames("gen7ou",
                year = 2017, month = 10, rank = 0)

        val landoMoves = listOf("Earthquake", "U-turn", "Stealth Rock", "Hidden Power Ice", "Knock Off",
                "Stone Edge", "Fly", "Swords Dance", "Explosion", "Smack Down", "Rock Slide", "Rock Polish",
                "Superpower")

        val enteiMoves = listOf("Sacred Fire", "Extreme Speed", "Stone Edge", "Bulldoze", "Iron Head",
                "Flare Blitz", "Flame Charge", "Will-O-Wisp", "Eruption", "Toxic", "Fire Blast", "Flamethrower",
                "Protect", "Calm Mind", "Roar", "Substitute", "Shadow Ball", "Howl", "Extrasensory", "Iron Tail",
                "Sunny Day", "Fire Fang", "Lava Plume", "Overheat")

        assertEquals(landoMoves, pokemonNameToMoveMap["Landorus-Therian"])
        assertEquals(enteiMoves, pokemonNameToMoveMap["Entei"])
    }

    @Test
    fun grabCommonMovesToday() {
        val pokemonNameToMoveMap = SmogonGrabber.grabCommonMoveNames("gen7ou")
        assertTrue(pokemonNameToMoveMap.isNotEmpty())
    }

    @Test
    fun grabOU() {
        val expectedPokemon: List<String> = listOf("Landorus-Therian", "Tapu Koko", "Greninja-Ash", "Ferrothorn",
                "Heatran", "Magearna", "Greninja", "Tapu Lele", "Garchomp", "Kartana")
        val pokemon: List<String> = SmogonGrabber.grabPokemonNames("gen7ou", month = 10, year = 2017,
                rank = 0, count = 10)
        assertEquals(expectedPokemon, pokemon)
    }

    @Test
    fun grabOULargeCount() {
        val pokemon = SmogonGrabber.grabPokemonNames("gen7ou", month = 10, year = 2017,
                rank = 1825, count = 1000)
        assertEquals(882, pokemon.size)
    }

    @Test
    fun grabOUToday() {
        val pokemon: List<String> = SmogonGrabber.grabPokemonNames("gen7ou")
        TestCase.assertTrue(pokemon.isNotEmpty())
    }
}