package examples.intro
class Customer

class Contact(val id: Int, var email: String)

fun main() {
    val customer = Customer()
    val contact = Contact(1, "test@gmail.com")

    println(customer)
    println(contact.id)
    println(contact.email)
}