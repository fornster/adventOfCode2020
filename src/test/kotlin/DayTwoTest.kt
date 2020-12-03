import org.junit.jupiter.api.Test
import java.io.File

internal class DayTwoTest {
    @Test
    internal fun `can tell if password is valid`() {
        val rule = Rule(IntRange(1, 2), 'a')
        assert(DayTwo().isValidPassword(rule, "aea"))
    }

    @Test
    internal fun `given list of rules and passwords can determine how many are valid`() {
        val rulePasswordList : MutableList<Pair<Rule, String>> = mutableListOf()
        File("./src/main/resources/dayTwoPartOne.txt").forEachLine {
            val splitString = it.split(" ")
            val boundsStrings = splitString[0].split('-')
            val start = boundsStrings[0].toInt()
            val endInclusive = boundsStrings[1].toInt()
            val letter = splitString[1][0]
            val rule = Rule(IntRange(start, endInclusive), letter)
            val password = splitString[2]
            rulePasswordList.add(Pair(rule, password))
        }
        println(DayTwo().numberOfValidPasswords(rulePasswordList))




    }
}
