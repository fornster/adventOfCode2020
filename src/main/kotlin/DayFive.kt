class DayFive {
    fun findNext(nextColumn: ColumnSelector, columnRange: IntRange): IntRange {
        val nextBound = (columnRange.last - columnRange.first + 1) / 2
        return when (nextColumn) {
            ColumnSelector.Forward -> {
                IntRange(nextBound, columnRange.last)
            }
            ColumnSelector.Backward ->  IntRange(columnRange.first, columnRange.first + nextBound)
        }
    }

}

enum class ColumnSelector(forwardOrBackward: Char) { Forward('F'), Backward('B') }
