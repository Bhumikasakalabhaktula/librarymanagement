package com.example.library_management.entity;



 

 





 
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PublisherTest {

    @Test
    public void publisherConstructorTest() {
        // Arrange
        Set<Book> books = new HashSet<>();
        Publisher publisher = new Publisher(1L, "Test Publisher", books);
        
        // Act & Assert
        assertEquals(1L, publisher.getId());
        assertEquals("Test Publisher", publisher.getName());
        assertEquals(books, publisher.getBooks());
    }

    @Test
    public void publisherDefaultConstructorTest() {
        // Act
        Publisher publisher = new Publisher();
        
        // Assert
        assertEquals(null, publisher.getId());
        assertEquals(null, publisher.getName());
        assertEquals(new HashSet<>(), publisher.getBooks());
    }

    @Test
    public void publisherSettersTest() {
        // Arrange
        Publisher publisher = new Publisher();
        Set<Book> books = new HashSet<>();
        
        // Act
        publisher.setId(1L);
        publisher.setName("Test Publisher");
        publisher.setBooks(books);
        
        // Assert
        assertEquals(1L, publisher.getId());
        assertEquals("Test Publisher", publisher.getName());
        assertEquals(books, publisher.getBooks());
    }
}