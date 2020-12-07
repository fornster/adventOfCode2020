import org.junit.jupiter.api.Test
import java.io.File

class DaySixTest {
    @Test
    internal fun `part one`() {
        val split = File("src/main/resources/DaySix.txt").readText().split("\n\n")
        val unique = split.map { it.toSet().filter { it != '\n' } }
        val uniqueCounts = unique.map { it.count() }
        println(uniqueCounts.sum())
    }

    @Test
    internal fun `part two`() {
        val groups: List<String> = File("src/main/resources/DaySix.txt").readText().split("\n\n")
        val groupsWithIndividuals: List<List<String>> = groups.map { it.split('\n') }

        val unique: List<List<Set<Char>>> = groupsWithIndividuals.map { group -> group.map { it.toSet() } }
        val map: List<Set<Char>> = unique.map {
            when (it.count() > 1) {
                true -> it.reduce { first, second -> if(second.count() > 0) first.intersect(second) else first }
                false -> it.first()
            }
        }
        val uniqueCounts = map.map { it.count() }
        println(uniqueCounts.sum())
    }


}
