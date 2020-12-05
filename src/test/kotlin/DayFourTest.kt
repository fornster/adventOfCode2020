import org.junit.jupiter.api.Test
import java.io.File

class DayFourTest {

    @Test
    internal fun name() {
        val passportStrings = mutableListOf("")
        var passportNum = 0
        File("src/main/resources/DayFour.txt").forEachLine {
            if (it.isNotEmpty()) {
                passportStrings[passportNum] += ("$it ")
            } else {
                passportNum++; passportStrings.add("")
            }
        }
        val passports = passportStrings.map { passportParser(it) }
        val filter = passports.filter { it.valid }
        val count = filter.count()
        val map = filter.filter { it.pid?.length != 9 }
        println(count)
    }
}

fun passportParser(string: String): Passport {
    val listOfKVPs = string.split(" ").map { it.split(":") }
    return Passport(eyeColor = findValue(listOfKVPs, "ecl"),
        pid = findValue(listOfKVPs, "pid"),
        expirationYear = findValue(listOfKVPs, "eyr")?.toInt(),
        hairColor = findValue(listOfKVPs, "hcl"), birthYear = findValue(listOfKVPs, "byr")?.toInt(),
        issueYear = findValue(listOfKVPs, "iyr")?.toInt(), cid = findValue(listOfKVPs, "cid"),
        height = findValue(listOfKVPs, "hgt") )
}

fun findValue(listOfKvps: List<List<String>>, find: String): String? {
    listOfKvps.forEach { if (it[0] == find) return it[1] }
    return null
}

data class Passport(
    val eyeColor: String?,
    val pid: String?,
    val expirationYear: Int?,
    val hairColor: String?,
    val birthYear: Int?,
    val issueYear: Int?,
    val cid: String?,
    val height: String?,
) {
    val valid: Boolean = eyeColorValid() && passportIdValid() && expirationYearValid() && heightValid() && birthYearValid() && issueYearValid() && hairColorValid()
    fun birthYearValid() : Boolean = birthYear != null && birthYear >= 1920 && birthYear <= 2002
//byr (Birth Year) - four digits; at least 1920 and at most 2002.
    fun issueYearValid() : Boolean = issueYear != null && issueYear >= 2010 && issueYear <= 2020
//iyr (Issue Year) - four digits; at least 2010 and at most 2020.
    fun expirationYearValid() : Boolean = expirationYear != null && expirationYear >= 2020 && expirationYear <= 2030
//eyr (Expiration Year) - four digits; at least 2020 and at most 2030.
    fun heightValid() : Boolean = height != null && (height.contains(Regex("((5(?=9)|6|7(?=[0-6]))[0-9]in|[1]([5-8]|9(?=[0-3]))[0-9]cm)")))
//hgt (Height) - a number followed by either cm or in:
//If cm, the number must be at least 150 and at most 193.
//If in, the number must be at least 59 and at most 76.
    fun hairColorValid() : Boolean = hairColor != null && (hairColor.contains(Regex("^(#([0-9]|[a-f]){6})$")))
//hcl (Hair Color) - a # followed by exactly six characters 0-9 or a-f.
    fun eyeColorValid() : Boolean = eyeColor != null && (eyeColor.contains(Regex("(amb|blu|brn|gry|grn|hzl|oth)")))
//ecl (Eye Color) - exactly one of: amb blu brn gry grn hzl oth.
    fun passportIdValid() : Boolean = pid != null && (pid.contains(Regex("^([0-9]{9})$")))
//pid (Passport ID) - a nine-digit number, including leading zeroes.
//cid (Country ID) - ignored, missing or not.
}

