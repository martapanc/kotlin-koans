package collections

data class Person(val name: String, val city: String, val phone: String)

val people = listOf(
    Person("John", "Boston", "+1-888-123456"),
    Person("Sarah", "Munich", "+49-777-789123"),
    Person("Svyatoslav", "Saint-Petersburg", "+7-999-456789"),
    Person("Vasilisa", "Saint-Petersburg", "+7-999-123456"),
    Person("John", "London", "+7-999-456789"))

val phoneBook = people.associateBy { it.phone }
val cityBook = people.associateBy(Person::phone, Person::city)
val peopleCities = people.groupBy(Person::city, Person::name)
val cityPeople = people.groupBy(Person::name, Person::city)
val phonePeople = people.groupBy(Person::name, Person::phone)
val peoplePhone = people.groupBy(Person::phone, Person::name)

fun main() {
    println(phoneBook)
    println(cityBook)
    println(peopleCities)
    println(cityPeople)
    println(phonePeople)
    println(peoplePhone)
}