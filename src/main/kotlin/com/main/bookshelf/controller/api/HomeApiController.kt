package com.main.bookshelf.controller.api

import com.main.bookshelf.service.BookService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class HomeApiController {

    @Autowired
    private lateinit var bookService: BookService

    @GetMapping(path=["/",])
    private fun index(
        @RequestParam size: Int?,
        @RequestParam page: Int?,
        @RequestParam category : String?,
        @RequestParam onair: Boolean?
    ): ResponseEntity<Any?>{
        val _size: Int = size ?: 10
        val _page: Int = page ?: 0
        return ResponseEntity.ok().body(bookService.getBooks(_size, _page))
    }
}