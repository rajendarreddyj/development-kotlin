package com.rajendarreddyj.kotlin

fun main(args: Array<String>) {
    println("Hello, World")
}

fun start(): String {
    return "OK"
}

fun toJSON(collection: Collection<Int>): String {
    val sb = StringBuilder()
    sb.append("[")
    val iterator = collection.iterator()
    while (iterator.hasNext()) {
        val element = iterator.next()
        sb.append(element)
        if (iterator.hasNext()) {
            sb.append(", ")
        }
    }
    sb.append("]")
    return sb.toString()
}

fun joinOptions(options: Collection<String>) = options.joinToString(prefix = "[", postfix = "]")

fun foo(name: String, number: Int = 42, toUpperCase: Boolean = false) =
        (if (toUpperCase) name.toUpperCase() else name) + number

fun useFoo() = listOf(
        foo("a"),
        foo("b", number = 1),
        foo("c", toUpperCase = true),
        foo(name = "d", number = 2, toUpperCase = true)
)

fun containsEven(collection: Collection<Int>): Boolean = collection.any { it % 2 == 0 }

private val month = "(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)"

fun getPattern(): String = """\d{2} $month \d{4}"""

data class Person(val name: String, val age: Int)

fun getPeople(): List<Person> {
    return listOf(Person("Alice", 29), Person("Bob", 31))
}

fun sendMessageToClient(
        client: Client?, message: String?, mailer: Mailer
) {
    val email = client?.personalInfo?.email
    if (email != null && message != null) {
        mailer.sendMessage(email, message)
    }
}

class Client(val personalInfo: PersonalInfo?)
class PersonalInfo(val email: String?)
interface Mailer {
    fun sendMessage(email: String, message: String)
}