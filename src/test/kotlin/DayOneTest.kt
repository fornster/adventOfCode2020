import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertEquals

class DayOneTest {
    private val dayOne = DayOne()
    @Test
    internal fun `returns true if two numbers add to 2020`() {
        val addsTo2020pt1 = 2019
        val addsTo2020pt2 = 1
        val listOfNums = listOf(2019, 1)
        assertEquals(true, dayOne.addsTo2020(listOfNums))
    }

    @Test
    internal fun `returns false if number doesnt add to 2020`() {
        val listOfNums = listOf(2020, 1)
        assertEquals(false, dayOne.addsTo2020(listOfNums))
    }

    @Test
    internal fun `given list of numbers find ones that add to 2020`() {
        val listOfNums = listOf(1721, 979, 366, 299, 675, 1456)
        val actualPair = dayOne.findTwo(listOfNums)
        assertEquals(actualPair, Pair(1721, 299))
    }

    @Test
    internal fun `given list of numbers find two that add to 2020 and multiply them together`() {
        val listOfNums = listOf(1721, 979, 366, 299, 675, 1456)
        val value : Int = dayOne.findAndMultiplyTwo(listOfNums)
        assertEquals( 514579, value)
    }

    @Test
    internal fun `given list of numbers find three that add to 2020 and multiply them together`() {
        val listOfNums = listOf(1721, 979, 366, 299, 675, 1456)
        val value : Int = dayOne.findAndMultiplyThree(listOfNums)
        assertEquals( 241861950, value)
    }

    @Test
    internal fun actualPartOne() {
        val file = File("./src/main/resources/dayOnePartOne.txt")
        val listOfInts = mutableListOf<Int>()
        file.forEachLine { listOfInts.add(it.toInt()) }
        val findAndMultiply = dayOne.findAndMultiplyTwo(listOfInts)
        println(findAndMultiply)
    }

    @Test
    internal fun actualPartTwo() {
        val file = File("./src/main/resources/dayOnePartOne.txt")
        val listOfInts = mutableListOf<Int>()
        file.forEachLine { listOfInts.add(it.toInt()) }
        val findAndMultiply = dayOne.findAndMultiplyThree(listOfInts)
        println(findAndMultiply)
    }
}
