package com.main.bookshelf.Book

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import org.hibernate.validator.constraints.ISBN
import org.springframework.data.annotation.CreatedDate
import java.io.Serializable
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name="book")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class BookModel (
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column()
//    val id: Int? = null,
    @Id
    @ISBN()
    val isbn: String,

    @Column(nullable = false)
    val bookName: String,

    var category: String?= null,

    var imageUrl: String? = null,

    @CreatedDate
    var createdDate: LocalDate = LocalDate.now(),

    val publishedDate: LocalDate? = null,

    @OneToOne(mappedBy = "isbn", cascade = [CascadeType.ALL])
    @PrimaryKeyJoinColumn
    var state: State
){

    fun createBookDTO() : createBookModelDTO {
        return createBookModelDTO(
            isbn = isbn,
            bookName = bookName,
            category = category,
            imageUrl = imageUrl,
            publishedDate = publishedDate,
            state = state
        )
    }
}

@Entity
@Table(name="book_state")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
@Embeddable
data class State (

    @Id
    @OneToOne
    @JoinColumn(name="isbn")
    val isbn: BookModel,
    var new : Boolean = true,
    var onAir: Boolean = false
) : Serializable


// https://kapentaz.github.io/jpa/kotlin/Spring-Data-JPA-Audit-in-Kotlin/#

//class State(
//    var new : Boolean = true,
//    var onAir: Boolean = false
//)
