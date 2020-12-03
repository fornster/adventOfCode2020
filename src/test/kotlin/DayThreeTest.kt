import org.junit.jupiter.api.Test
import java.io.File

class DayThreeTest {

    @Test
    internal fun `pull in test input`() {
        val countList = mutableListOf<Long>()
        val slopeList = listOf(Slope(1, 1), Slope(3, 1), Slope(5, 1), Slope(7, 1), Slope(1, 2))
        slopeList.forEach { slope ->
            var i = 0
            var count: Long = 0
            var rowNum = 0
            File("src/main/resources/DayThree.txt")
                .forEachLine { row ->
                    if (rowNum.rem(slope.y) == 0) {
                        if (row[i] == '#') count++
                        i += slope.x
                        i = i.rem(row.count())
                    }
                    rowNum++
                }
            countList.add(count)
        }
        println(countList)
        println(countList.reduce { first, second -> first * second })
    }
}

data class Slope(val x: Int, val y: Int)
