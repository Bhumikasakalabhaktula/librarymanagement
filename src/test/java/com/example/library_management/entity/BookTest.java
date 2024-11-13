package com.example.library_management.entity;



import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookTest {

    @Test
    public void bookConstructorTest() {
        // Arrange
        Author author = new Author(1L, "John Doe", null);
        Publisher publisher = new Publisher(1L, "Test Publisher", null);
        LocalDate publicationDate = LocalDate.of(2023, 1, 1);
        
        // Act
        Book book = new Book(1L, "Test Book", publicationDate, author, publisher);
        
        // Assert
        assertEquals(1L, book.getId());
        assertEquals("Test Book", book.getTitle());
        assertEquals(publicationDate, book.getPublicationDate());
        assertEquals(author, book.getAuthor());
        assertEquals(publisher, book.getPublisher());
    }

    @Test
    public void bookDefaultConstructorTest() {
        // Act
        Book book = new Book();
        
        // Assert
        assertEquals(null, book.getId());
        assertEquals(null, book.getTitle());
        assertEquals(null, book.getPublicationDate());
        assertEquals(null, book.getAuthor());
        assertEquals(null, book.getPublisher());
    }

    @Test
    public void bookSettersTest() {
        // Arrange
        Book book = new Book();
        Author author = new Author(1L, "John Doe", null);
        Publisher publisher = new Publisher(1L, "Test Publisher", null);
        LocalDate publicationDate = LocalDate.of(2023, 1, 1);
        
        // Act
        book.setId(1L);
        book.setTitle("Test Book");
        book.setPublicationDate(publicationDate);
        book.setAuthor(author);
        book.setPublisher(publisher);
        
        // Assert
        assertEquals(1L, book.getId());
        assertEquals("Test Book", book.getTitle());
        assertEquals(publicationDate, book.getPublicationDate());
        assertEquals(author, book.getAuthor());
        assertEquals(publisher, book.getPublisher());
    }
}