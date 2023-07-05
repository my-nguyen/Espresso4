package com.nguyen.espresso4

import com.nguyen.espresso4.models.Book

/**
 * This class holds constants with some data for testing.
 *
 * @author vgrec, created on 3/23/15.
 */
object Database {
    val NEW_BOOKS = listOf(
        Book(1, "Clean Code", "Robert C. Martin"),
        Book(2, "The Clean Coder", "Robert C. Martin"),
        Book(3, "Code Complete 2", "Steve McConnell"),
        Book(4, "Effective Java ", "Joshua Bloch"),
        Book(5, "Java Concurrency in Practice", "Brian Goetz")
    )
    val ALL_BOOKS = listOf(
        Book(1, "Clean Code", "Robert C. Martin"),
        Book(2, "The Clean Coder", "Robert C. Martin"),
        Book(3, "Code Complete 2", "Steve McConnell"),
        Book(4, "Effective Java ", "Joshua Bloch"),
        Book(9, "Refactoring: Improving the Design of Existing Code", "Martin Fowler"),
        Book(5, "Java Concurrency in Practice", "Brian Goetz"),
        Book(6, "Essential Algorithms", "Rod Stephens"),
        Book(7, "Algorithms", "Robert Sedgewick"),
        Book(8, "The Passionate Programmer", "Chad Fowler"),
        Book(10, "The Pragmatic Programmer", "Andrew Hunt"),
        Book(11, "Seven Languages in Seven Weeks", "Bruce A. Tate"),
        Book(12, "The Ruby Programming Language", "David Flanagan"),
        Book(13, "Agile Web Development with Rails 4 ", "Sam Ruby")
    )
    val CITIES = arrayOf(
        "Berlin",
        "Havana",
        "Helsinki",
        "Jakarta",
        "Paris",
        "Prague",
        "Sofia"
    )
}