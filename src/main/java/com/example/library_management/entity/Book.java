package com.example.library_management.entity;



//import jakarta.persistence.*;
//import java.time.LocalDate;
// 
//@Entity
//@Table(name = "books")
//public class Book {
// 
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
// 
//    @Column(nullable = false)
//    private String title;
// 
//    @Column(name = "publication_date", nullable = false)
//    private LocalDate publicationDate;
// 
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "author_id", nullable = false)
//    private Author author;
// 
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "publisher_id", nullable = false)
//    private Publisher publisher;
// 
//    // Default Constructor
//    public Book() {}
// 
//    // Parameterized Constructor
//    public Book(String title, LocalDate publicationDate, Author author, Publisher publisher) {
//        this.title = title;
//        this.publicationDate = publicationDate;
//        this.author = author;
//        this.publisher = publisher;
//    }
// 
//    // Getters and Setters
//    public Long getId() {
//        return id;
//    }
// 
//    public void setId(Long id) {
//this.id = id;
//    }
// 
//    public String getTitle() {
//        return title;
//    }
// 
//    public void setTitle(String title) {
//        this.title = title;
//    }
// 
//    public LocalDate getPublicationDate() {
//        return publicationDate;
//    }
// 
//    public void setPublicationDate(LocalDate publicationDate) {
//        this.publicationDate = publicationDate;
//    }
// 
//    public Author getAuthor() {
//        return author;
//    }
// 
//    public void setAuthor(Author author) {
//        this.author = author;
//    }
// 
//    public Publisher getPublisher() {
//        return publisher;
//    }
// 
//    public void setPublisher(Publisher publisher) {
//        this.publisher = publisher;
//    }
//}





import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 
import java.time.LocalDate;
 
@Entity
@Table(name = "books")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private LocalDate publicationDate;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id", nullable = false)
    private Publisher publisher;
}