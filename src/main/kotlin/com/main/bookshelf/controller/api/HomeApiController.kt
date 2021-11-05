package com.main.bookshelf.controller.api

import com.main.bookshelf.model.BookModel
import com.main.bookshelf.service.BookService
import org.hibernate.validator.constraints.ISBN
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class HomeApiController {

    @Autowired
    private lateinit var bookService: BookService

    @GetMapping(path=["/",])
    fun index(
        @RequestParam size: Int?,
        @RequestParam page: Int?,
        @RequestParam category : String?,
        @RequestParam onair: Boolean?
    ): ResponseEntity<Any?>{
        val _size: Int = size ?: 10
        val _page: Int = page ?: 0
        return ResponseEntity.ok().body(bookService.getBooks(_size, _page))
    }

    @PostMapping(path=["/"])
    fun registNewBook(@RequestBody newBook:BookModel): ResponseEntity<Any?> {
        if(bookService.getBookDetail(newBook.isbn) != null){
            return ResponseEntity.badRequest().body("{'message': 'already exists'}")
        }
        return ResponseEntity.ok().body(
            bookService.registBook(newBook))
    }

    @PutMapping(path=["/{isbn}"])
    fun updateBook(@PathVariable isbn:ISBN, @RequestBody book: BookModel): BookModel{
        return book
    }
}