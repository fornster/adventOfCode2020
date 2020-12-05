import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class DayFiveTest {
    @Test
    internal fun `given f and the current column can find next column`() {
        val nextColumn = ColumnSelector.Forward
        val columnRange = IntRange(0, 127)
        val expectedRange = IntRange(64, 127)
        val actualNextColumn = DayFive().findNext(nextColumn, columnRange)
        assertEquals(expectedRange, actualNextColumn)
    }
    @Test
    internal fun `given b and the current column can find next column`() {
        val nextColumn = ColumnSelector.Backward
        val columnRange = IntRange(64, 127)
        val expectedRange = IntRange(64, 96)
        val actualNextColumn = DayFive().findNext(nextColumn, columnRange)
        assertEquals(expectedRange, actualNextColumn)
    }

}
