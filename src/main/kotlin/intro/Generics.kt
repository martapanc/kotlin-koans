package intro
// https://kotlinlang.org/docs/reference/generics.html
class MutableStack<E>(vararg items: E) {
    private val elements = items.toMutableList()

    fun push(element: E) = elements.add(element)

    fun peek(): E = elements.last()

    fun pop(): E = elements.removeAt(elements.size - 1)

    fun isEmpty() = elements.isEmpty()

    fun size() = elements.size

    override fun toString(): String {
        return "intro.MutableStack(${elements.joinToString()})"
    }
}

fun <E> mutableStackOf(vararg elements: E) = MutableStack(*elements)

fun main() {
    val mutableStack = MutableStack(1, 2, 15, 28)

    println(mutableStack.size())
    println(mutableStack.peek())
    println(mutableStack.push(57))
    println(mutableStack.size())
    println(mutableStack.pop())
    println(mutableStack.isEmpty())
    println(mutableStack)

    val stack = mutableStackOf(0.5, 12.69, 2)
    println(stack)
    println(stack.push(16.1))
    println(stack.size())
    println(stack)
}