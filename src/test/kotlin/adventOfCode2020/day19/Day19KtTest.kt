package adventOfCode2020.day19

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class Day19KtTest {

    private val inputRules = readRulesToMap("src/main/kotlin/adventOfCode2020/day19/input_rules")
    private val inputMessages = readMessagesToList("src/main/kotlin/adventOfCode2020/day19/input_messages")
    private val input0Rules = readRulesToMap("src/main/kotlin/adventOfCode2020/day19/input0_rules")
    private val input0Messages = readMessagesToList("src/main/kotlin/adventOfCode2020/day19/input0_messages")

    @Test
    fun testReadInputFiles() {
        println(input0Rules)
        println(input0Messages)
        println(inputRules)
        println(inputMessages)
    }

    @Test
    fun testFindRegex() {
        assertEquals("a((aa|bb)(ab|ba)|(ab|ba)(aa|bb))b", findRegex(input0Rules))
        assertEquals("(a(b(((b(bba|a(ba|bb))|a(a(aa|bb)|b((b|a)a|ab)))b|(a(aba|(b(b|a)|ab)b)|b(b(b(b|a)|ab)|a((b|a)a|ab)))a)a|(b(a((ba|ab)a|(aa|bb)b)|b((ab|bb)b|(b(b|a)|ab)a))|a(a(b(a(b|a)|bb)|aab)|b(baa|a((b|a)a|ab))))b)|a(a((bbaa|a((ba|bb)b|(ba|aa)a))a|(baab|a(baa|a((b|a)a|ab)))b)|b((a(a(a(b|a)|bb)|b(ba|aa))|b((ba|aa)a|abb))a|((a(ab|aa)|b(ba|aa))b|(a(aa|bb)|b((b|a)a|ab))a)b)))|b(((b((aba|b(aa|bb))a|(((b|a)a|ab)b|(a(b|a)|bb)a)b)|a(a(baa|(ba|bb)b)|b(b(b|a)(b|a)|a(b(b|a)|ab))))a|((b(b(b|a)(b|a)|a(b(b|a)|ab))|a(b((b|a)a|ab)|aaa))b|(a((ba|aa)a|abb)|b((ab|aa)b|baa))a)b)a|((b((aba|abb)a|(b(ba|bb)|aaa)b)|a(b(b(b|a)(b|a)|a(b(b|a)|ab))|a(aab|b(ab|bb))))a|(a(b((ab|aa)a|(ba|ab)b)|a(b((b|a)a|ab)|aab))|b(b(b(ba|bb)|aaa)|a(b|a)(ba|ab)))b)b))(a(b(((b(bba|a(ba|bb))|a(a(aa|bb)|b((b|a)a|ab)))b|(a(aba|(b(b|a)|ab)b)|b(b(b(b|a)|ab)|a((b|a)a|ab)))a)a|(b(a((ba|ab)a|(aa|bb)b)|b((ab|bb)b|(b(b|a)|ab)a))|a(a(b(a(b|a)|bb)|aab)|b(baa|a((b|a)a|ab))))b)|a(a((bbaa|a((ba|bb)b|(ba|aa)a))a|(baab|a(baa|a((b|a)a|ab)))b)|b((a(a(a(b|a)|bb)|b(ba|aa))|b((ba|aa)a|abb))a|((a(ab|aa)|b(ba|aa))b|(a(aa|bb)|b((b|a)a|ab))a)b)))|b(((b((aba|b(aa|bb))a|(((b|a)a|ab)b|(a(b|a)|bb)a)b)|a(a(baa|(ba|bb)b)|b(b(b|a)(b|a)|a(b(b|a)|ab))))a|((b(b(b|a)(b|a)|a(b(b|a)|ab))|a(b((b|a)a|ab)|aaa))b|(a((ba|aa)a|abb)|b((ab|aa)b|baa))a)b)a|((b((aba|abb)a|(b(ba|bb)|aaa)b)|a(b(b(b|a)(b|a)|a(b(b|a)|ab))|a(aab|b(ab|bb))))a|(a(b((ab|aa)a|(ba|ab)b)|a(b((b|a)a|ab)|aab))|b(b(b(ba|bb)|aaa)|a(b|a)(ba|ab)))b)b))(b(a(((b((aa|bb)b|(ba|bb)a)|a((ab|bb)b|(ab|aa)a))b|((a(b|a)(b|a)|baa)a|aabb)a)b|((((a(b|a)|bb)b|aba)b|(b(b(b|a)|ab)|a(ba|ab))a)b|(((ba|aa)a|(ab|aa)b)a|(aab|aaa)b)a)a)|b(((a((ab|bb)b|(ba|aa)a)|b(a(b(b|a)|ab)|b(ab|aa)))b|(a((b(b|a)|ab)b|(ab|aa)a)|b((b|a)(b|a)a|(ab|aa)b))a)b|((b(aba|b(ba|aa))|a((ba|aa)a|aab))b|(b((ba|ab)a|(aa|bb)b)|a(bba|a(ba|aa)))a)a))|a(a(a((b(b(b(b|a)|ab)|a(b|a)(b|a))|a((ab|bb)a|(ab|aa)b))a|(((ba|bb)a|(b(b|a)|ab)b)a|((ab|bb)a|(b|a)(b|a)b)b)b)|b((((ab|bb)b|(b(b|a)|ab)a)b|(aab|b(ab|bb))a)a|((aba|(b(b|a)|ab)b)b|(aba|(aa|bb)b)a)b))|b(b(a(b(baa|(ba|ab)b)|a((aa|bb)b|(ab|bb)a))|b((bab|a(ab|aa))b|(aaa|(a(b|a)|bb)b)a))|a(((aba|(aa|bb)b)b|(a(ab|aa)|b(ba|aa))a)a|((aab|b(b(b|a)|ab))b|(aaa|(a(b|a)|bb)b)a)b))))", findRegex(inputRules))
    }

    @Test
    fun testCountValidMessages() {
        assertEquals(2, countValidMessages(input0Messages, findRegex(input0Rules)))
        assertEquals(132, countValidMessages(inputMessages, findRegex(inputRules)))
    }
}