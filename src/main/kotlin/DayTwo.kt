class DayTwo {
    fun isValidPassword(rule: Rule, password: String): Boolean =
        rule.numberOfTimes.contains(password.filter { it == rule.letter }.count())

    fun isValidPasswordPtTwo(rule:Rule, password: String): Boolean {
        val indices = IntRange(rule.numberOfTimes.first - 1, rule.numberOfTimes.last - 1)
        val first = password[indices.first] == rule.letter
        val second = password[indices.last] == rule.letter
        return first.xor(second)
    }

    fun numberOfValidPasswords(rulePasswordList: MutableList<Pair<Rule, String>>): Int {
        val map = rulePasswordList.map { isValidPasswordPtTwo(it.first, it.second) }
        return map.count { it }
    }

}

data class Rule (val numberOfTimes : IntRange, val letter : Char)
