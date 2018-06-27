package com.rajendarreddyj.kotlin

/**
 * Created by rajendarreddy on 5/20/17.
 */
/**
 * We declare a package-level function com.rajendarreddyj.kotlin.main which returns Unit and takes
 * an Array of strings as a parameter. Note that semicolons are optional.
 */

fun getHelloString(): String {
    return "Hello, world!"
}

fun main(args: Array<String>) {
    println(getHelloString())
}