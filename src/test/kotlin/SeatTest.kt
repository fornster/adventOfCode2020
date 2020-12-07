import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertEquals

class SeatTest {
    @Test
    internal fun `given f and the current column can find next column`() {
        val nextRow = RangeSelector.Forward
        val columnRange = IntRange(0, 127)
        val expectedRange = IntRange(0, 63)
        val actualNextRow = Seat(listOf(), listOf()).findNext(nextRow, columnRange)
        assertEquals(expectedRange, actualNextRow)
    }

    @Test
    internal fun `given b and the current row can find next row`() {
        val nextRow = RangeSelector.Backward
        val columnRange = IntRange(64, 127)
        val expectedRange = IntRange(96, 127)
        val actualNextRow = Seat(listOf(), listOf()).findNext(nextRow, columnRange)
        assertEquals(expectedRange, actualNextRow)
    }

    @Test
    internal fun `given series of inputs can determine row`() {
        val columnList = listOf(
            RangeSelector.Forward,
            RangeSelector.Backward,
            RangeSelector.Backward,
            RangeSelector.Backward,
            RangeSelector.Backward,
            RangeSelector.Backward,
            RangeSelector.Backward
        )
        val actualRow = Seat(columnList, listOf()).row
        assertEquals(63, actualRow)
    }

    @Test
    internal fun `same thing as above but with columns`() {
        val rowList = listOf(RangeSelector.Forward, RangeSelector.Forward, RangeSelector.Backward)
        val actualColumn = Seat(listOf(), rowList).column
        assertEquals(1, actualColumn)
    }

    @Test
    internal fun `give column and row can determine seat id which is row times 8 + column`() {
//BFFFBBFRRR
        val rowList = listOf(
            RangeSelector.Backward,
            RangeSelector.Forward,
            RangeSelector.Forward,
            RangeSelector.Forward,
            RangeSelector.Backward,
            RangeSelector.Backward,
            RangeSelector.Forward
        )
        val columnList = listOf(RangeSelector.Backward, RangeSelector.Backward, RangeSelector.Backward)
        val seat = Seat(rowList, columnList)
        assertEquals(70, seat.row)
        assertEquals(7, seat.column)
        assertEquals(567, seat.id)
    }

    @Test
    internal fun `now for the test input`() {
        val seats = findListOfSeats()
        println(seats.maxOf { it.id })

    }

    private fun findListOfSeats(): MutableList<Seat> {
        val seats = mutableListOf<Seat>()
        File("src/main/resources/DayFive.txt").forEachLine {
            val selectors = it.map { char ->
                when (char == 'F' || char == 'L') {
                    true -> RangeSelector.Forward
                    false -> RangeSelector.Backward
                }
            }
            seats.add(Seat(selectors.subList(0, 7), selectors.subList(7, 10)))
        }
        return seats
    }

    @Test
    internal fun `now for part two`() {
        val seats = findListOfSeats()
        val possibleSeatIds = IntRange(0,1016).toList()
        val missingSeatIDs = possibleSeatIds - seats.map{it.id}
        println("")
    }
}
