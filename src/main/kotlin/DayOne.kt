class DayOne {
    fun addsTo2020(int: List<Int>): Boolean = int.sum() == 2020
    fun findTwo(nums: List<Int>): Pair<Int, Int> {
        val sortedNums = nums.sortedDescending()
        val sortedFilteredNums = sortedNums.filter { it < 2021 }
        sortedFilteredNums
            .forEach { num1 ->
                val find = sortedFilteredNums.find { addsTo2020(listOf(num1, it)) }
                if (find != null) return Pair(num1, find)
            }
        return Pair(2020, 0)
    }

    fun findAndMultiplyTwo(listOfNums: List<Int>): Int {
        val pair = findTwo(listOfNums)
        return pair.first * pair.second
    }

    fun findAndMultiplyThree(listOfNums: List<Int>): Int {
        return findThree(listOfNums).reduce { first, second -> first * second }
    }

    private fun findThree(listOfNums: List<Int>): List<Int> {
        val filter = listOfNums.sorted().filter { it < 2021 }
        filter.forEach { first ->
            filter.reversed().forEach { second ->
                filter.drop(1); filter.forEach { third ->
                if (first + second + third == 2020) return listOf(
                    first,
                    second,
                    third
                )
            }
            }
        }
        return listOf()
    }

}
