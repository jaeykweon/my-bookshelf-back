package com.main.bookshelf.Book

import java.time.LocalDate

data class createBookModelDTO (
    val isbn: String,

    val bookName: String,

    var category: String?= null,

    var imageUrl: String? = null,

    var onAir: Boolean? = false,  // 대출 여부

    var createdDate: LocalDate = LocalDate.now(),

    val publishedDate: LocalDate? = null,

    var state: State
){
//    fun toEntity(): BookModel {
//        return BookModel(
//            isbn = isbn,
//            bookName = bookName,
//            category = category,
//            imageUrl = imageUrl,
//            publishedDate = publishedDate,
//            state = state
//        )
//    }
}