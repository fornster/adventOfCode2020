import org.junit.jupiter.api.Test
import java.io.File

class DaySixTest {
    @Test
    internal fun name() {
        val split = File("src/main/resources/DaySix.txt").readText().split("\n\n")
        val unique = split.map { it.toSet().filter { it != '\n' } }
        val uniqueCounts = unique.map{it.count()}
        println(uniqueCounts.sum())
    }
}
