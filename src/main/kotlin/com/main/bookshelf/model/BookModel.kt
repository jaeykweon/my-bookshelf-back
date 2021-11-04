package com.main.bookshelf.model

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name="book")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
class BookModel (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    @Column(nullable = false)
    var bookName: String,

    var category: String?= null,

    var imageUrl: String? = null,

    var onAir: Boolean? = false,  // 대출 여부

    @CreatedDate
    var createdDate: LocalDate = LocalDate.MIN,

    var publishedDate: LocalDate? = null
)
// https://kapentaz.github.io/jpa/kotlin/Spring-Data-JPA-Audit-in-Kotlin/#