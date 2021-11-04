package com.main.bookshelf.service

import com.main.bookshelf.model.BookModel
import org.springframework.data.domain.Page
import org.springframework.stereotype.Service

@Service
interface BookService {

    fun getAllBooks(): List<BookModel>?

    fun getBooks(size:Int, page:Int): Page<BookModel>?

    fun getBookDetail(id:Int): BookModel?

}