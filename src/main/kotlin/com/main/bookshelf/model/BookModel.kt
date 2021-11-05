package com.main.bookshelf.model

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import org.hibernate.validator.cfg.defs.ISBNDef
import org.hibernate.validator.constraints.ISBN
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDate
import java.util.*
import javax.persistence.*

@Entity
@Table(name="book")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
class BookModel (
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column()
//    val id: Int? = null,
    @Id
    @ISBN()
    var isbn: String,

    @Column(nullable = false)
    var bookName: String,

    var category: String?= null,

    var imageUrl: String? = null,

    var onAir: Boolean? = false,  // 대출 여부

    @CreatedDate
    var createdDate: LocalDate = LocalDate.now(),

    var publishedDate: LocalDate? = null

)
// https://kapentaz.github.io/jpa/kotlin/Spring-Data-JPA-Audit-in-Kotlin/#