package com.main.bookshelf.repository

import com.main.bookshelf.model.BookModel
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.CrudRepository


interface  BookRepository:CrudRepository<BookModel, Int>{

    fun findBookModelsBy(): List<BookModel>

    fun findBookModelsBy(pageable:Pageable) : Page<BookModel>?

    fun findBookModelById(id:Int) : BookModel?

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