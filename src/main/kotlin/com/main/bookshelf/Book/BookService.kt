package com.main.bookshelf.Book

import com.main.bookshelf.Book.BookModel
import org.springframework.data.domain.Page
import org.springframework.stereotype.Service

@Service
interface BookService {

    fun getAllBooks(): List<BookModel>?

    fun getBooks(size:Int, page:Int): Page<BookModel>?

    fun getBookDetail(isbn:String): BookModel?

    fun registBook(newBook: BookModel): BookModel?
}