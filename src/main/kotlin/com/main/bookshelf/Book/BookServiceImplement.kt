package com.main.bookshelf.Book

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class BookServiceImplement constructor(@Autowired private val bookRepository: BookRepository): BookService {

    override fun getAllBooks(): List<BookModel>?= bookRepository.findBookModelsBy()

    override fun getBooks(size: Int, page: Int): Page<BookModel>? {
        return bookRepository.findBookModelsBy(PageRequest.of(page,size))
    }

    override fun getBookDetail(isbn: String): BookModel? {
        return bookRepository.findBookModelByIsbn(isbn)
    }

    override fun registBook(newBook: BookModel): BookModel?{
        return bookRepository.save(newBook)
    }
}