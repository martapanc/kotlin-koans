package adventOfCode2020.day23

class CupClass(private val value: Int, private val left: Cup, private val right: Cup) {
    override fun toString(): String {
        return "{" + value +
                ", left=" + left.value +
                ", right=" + right.value +
                '}'
    }
}