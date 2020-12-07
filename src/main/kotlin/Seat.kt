class Seat(rowRangeList: List<RangeSelector>, columnRangeList: List<RangeSelector>) {
    val column: Int
    val row: Int
    val id: Int
    init {
        var startingColumnRange = IntRange(0, 7)
        var startingRowRange = IntRange(0,127)
        rowRangeList.forEach { startingRowRange = findNext(it, startingRowRange) }
        columnRangeList.forEach { startingColumnRange = findNext(it, startingColumnRange) }
        column = startingColumnRange.first
        row = startingRowRange.first
        id = row * 8 + column
    }

    fun findNext(nextRange: RangeSelector, columnRange: IntRange): IntRange {
        val nextBound = (columnRange.last - columnRange.first + 1) / 2
        return when (nextRange) {
            RangeSelector.Backward -> {
                IntRange(columnRange.last - nextBound + 1 , columnRange.last)
            }
            RangeSelector.Forward -> IntRange(columnRange.first, columnRange.first + nextBound - 1)
        }
    }

}

enum class RangeSelector(forwardOrBackward: Char) { Forward('F'), Backward('B') }
