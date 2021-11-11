import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertEquals
import kotlinx.serialization.SerialName


class DaySevenTest {
    @Test
    fun `given the rules counting them returns nine`() {
        val actual = 0;
        val file = File("./src/test/kotlin/input.json");

        val bags = Json.decodeFromString<Something>(file.readText())
        assertEquals(9, bags.bags.size)
    }
}

@Serializable
data class Something(
    @SerialName("bags")
    val bags: List<Bag>
)

@Serializable
data class Bag(
    @SerialName("color")
    val color: String,
    @SerialName("contains")
    val contains: List<Contain>
)

@Serializable
data class Contain(
    @SerialName("color")
    val color: String,
    @SerialName("count")
    val count: Int
)
