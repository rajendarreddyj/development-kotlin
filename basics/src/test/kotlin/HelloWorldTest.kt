package com.rajendarreddyj.kotlin

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Created by rajendarreddy on 5/20/17.
 */
class HelloWorldTest {
    @Test fun testAssert() : Unit {
        assertEquals("Hello, world!", getHelloString())
    }
}