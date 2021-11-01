package com.main.bookshelf

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BookshelfApplication

fun main(args: Array<String>) {
    runApplication<BookshelfApplication>(*args)
}
