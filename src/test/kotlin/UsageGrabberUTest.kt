import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import org.junit.Test
import script.UsageGrabber

class UsageGrabberUTest {

    @Test
    fun grabOU() {
        val expectedPokemon: List<String> = listOf("Landorus-Therian", "Tapu Koko", "Greninja-Ash", "Ferrothorn",
                "Heatran", "Magearna", "Greninja", "Tapu Lele", "Garchomp", "Kartana")
        val pokemon: List<String> = UsageGrabber.grabMetagamePokemon("gen7ou", month = 10, year = 2017,
                rank = 0, count = 10)
        assertEquals(expectedPokemon, pokemon)
    }

    @Test
    fun grabOULargeCount() {
        val pokemon = UsageGrabber.grabMetagamePokemon("gen7ou", month = 10, year = 2017,
                rank = 1825, count = 1000)
        assertEquals(882, pokemon.size)
    }

    @Test
    fun grabOUToday() {
        val pokemon: List<String> = UsageGrabber.grabMetagamePokemon("gen7ou")
        assertTrue(pokemon.isNotEmpty())
    }
}