package examples.collections

data class Person(val name: String, val city: String, val phone: String)

val people = listOf(
    Person("John", "Boston", "+1-888-123456"),
    Person("Sarah", "Munich", "+49-777-789123"),
    Person("Svyatoslav", "Saint-Petersburg", "+7-999-456789"),
    Person("Vasilisa", "Saint-Petersburg", "+7-999-123456"),
    Person("John", "London", "+7-999-456789")
)

// The difference between associateBy and groupBy is how they process objects with the same key:
// - associateBy uses the last suitable element as the value.
// - groupBy builds a list of all suitable elements and puts it in the value.
//
// associateBy(phone, city): {+1-888-123456=Boston, +49-777-789123=Munich, +7-999-456789=London, +7-999-123456=Saint-Petersburg}
// groupBy(phone, city):     {+1-888-123456=[Boston], +49-777-789123=[Munich], +7-999-456789=[Saint-Petersburg, London], +7-999-123456=[Saint-Petersburg]}

val phoneBook = people.associateBy { it.phone }
val cityBook = people.associateBy(Person::phone, Person::city)
val cityBook2 = people.groupBy(Person::phone, Person::city)
val peopleCities = people.groupBy(Person::city, Person::name)
val cityPeople = people.groupBy(Person::name, Person::city)
val phonePeople = people.groupBy(Person::name, Person::phone)
val peoplePhone = people.groupBy(Person::phone, Person::name)

val list1 = listOf(0, 10, 20)
val map1 = mutableMapOf<String, Int?>()

fun main() {
    println(phoneBook)
    println(cityBook)
    println(cityBook2)
    println(peopleCities)
    println(cityPeople)
    println(phonePeople)
    println(peoplePhone)

    println(list1.getOrElse(1) { 42 })
    println(list1.getOrElse(10) { 42 })
    map1["x"] = 3
    println(map1.getOrElse("x") { 42 })
    map1["x"] = null
    println(map1.getOrElse("x") { 42 })
}