package com.rajendarreddyj.kotlin

import org.junit.Assert
import org.junit.Test

class HelloTest {
    @Test
    fun testOk() {
        Assert.assertEquals("OK", start())
    }

    @Test
    fun collection() {
        Assert.assertEquals("toJSON", "[1, 2, 3, 42, 555]", toJSON(listOf(1, 2, 3, 42, 555)))
    }

    @Test
    fun testJoinToString() {
        Assert.assertEquals("joinOptions", "[yes, no, may be]", joinOptions(listOf("yes", "no", "may be")))
    }

    @Test
    fun testDefaultAndNamedParams() {
        Assert.assertEquals(listOf("a42", "b1", "C42", "D2"), useFoo())
    }

    @Test
    fun contains() {
        Assert.assertTrue("The result should be true if the collection contains an even number", containsEven(listOf(1, 2, 3, 126, 555)))
    }

    @Test
    fun notContains() {
        Assert.assertFalse("The result should be false if the collection doesn't contain an even number", containsEven(listOf(43, 33)))
    }

    private fun testMatch(date: String) = Assert.assertTrue("The pattern should match $date", date.matches(getPattern().toRegex()))
    private fun testMismatch(date: String) = Assert.assertFalse("The pattern shouldn't match $date", date.matches(getPattern().toRegex()))

    @Test
    fun match() {
        testMatch("11 MAR 1952")
    }

    @Test
    fun match1() {
        testMatch("24 AUG 1957")
    }

    @Test
    fun doNotMatch() {
        testMismatch("24 RRR 1957")
    }

    @Test fun testListOfPeople() {
        Assert.assertEquals("[Person(name=Alice, age=29), Person(name=Bob, age=31)]", getPeople().toString())
    }

    private fun testSendMessageToClient(
            client: Client?,
            message: String?,
            expectedEmail: String? = null,
            shouldBeInvoked: Boolean = false
    ) {
        var invoked = false
        val expectedMessage = message
        sendMessageToClient(client, message, object : Mailer {
            override fun sendMessage(email: String, message: String) {
                invoked = true
                Assert.assertEquals("The message is not as expected:",
                        expectedMessage, message)
                Assert.assertEquals("The email is not as expected:",
                        expectedEmail, email)
            }
        })
        Assert.assertEquals("The function 'sendMessage' should${if (shouldBeInvoked) "" else "n't"} be invoked",
                shouldBeInvoked, invoked)
    }

    @Test fun everythingIsOk() {
        testSendMessageToClient(Client(PersonalInfo("bob@gmail.com")),
                "Hi Bob! We have an awesome proposition for you...",
                "bob@gmail.com",
                true)
    }

    @Test fun noMessage() {
        testSendMessageToClient(Client(PersonalInfo("bob@gmail.com")), null)
    }

    @Test fun noEmail() {
        testSendMessageToClient(Client(PersonalInfo(null)), "Hi Bob! We have an awesome proposition for you...")
    }

    @Test fun noPersonalInfo() {
        testSendMessageToClient(Client(null), "Hi Bob! We have an awesome proposition for you...")
    }

    @Test fun noClient() {
        testSendMessageToClient(null, "Hi Bob! We have an awesome proposition for you...")
    }
}
