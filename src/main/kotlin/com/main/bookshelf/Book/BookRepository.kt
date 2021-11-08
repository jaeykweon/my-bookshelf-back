package com.main.bookshelf.Book

import com.main.bookshelf.Book.BookModel
import org.hibernate.validator.constraints.ISBN
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


interface  BookRepository:CrudRepository<BookModel, ISBN>{

    fun findBookModelsBy(): List<BookModel>

    fun findBookModelsBy(pageable:Pageable) : Page<BookModel>?

    fun findBookModelByIsbn(isbn: String) : BookModel?

}



//@Component
//open class BookRepository {
//
//    @PersistenceContext
//    private lateinit var entityManager: EntityManager
//
//    fun getBooks(size:Int? = 20, page:Int? = 1, category: String?, isOnAir: Boolean?){
////        var query: String = "SELECT id, bookName, imageUrl, isOnAir FROM book"
////
////        var getBooksQuery = entityManager.createQuery("")
//
//    }
//}


// https://blog.jetbrains.com/idea/2018/10/kotlin-jpa-and-spring-data/