package com.main.bookshelf.service

import com.main.bookshelf.model.BookModel
import com.main.bookshelf.repository.BookRepository
import org.hibernate.validator.constraints.ISBN
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.util.*

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