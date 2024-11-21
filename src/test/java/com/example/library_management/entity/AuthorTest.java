package com.example.library_management.entity;



//import com.example.library_management.entity.Author;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class AuthorTest {
//
//    @Test
//    public void authorConstructorTest() {
//        Author author = new Author(1L, "John Doe", null);
//        assertEquals(1L, author.getId());
//        assertEquals("John Doe", author.getName());
//    }
//}





import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuthorTest {

    @Test
    public void authorConstructorTest() {
        // Arrange
        Set<Book> books = new HashSet<>();
        Author author = new Author(1L, "John Doe", books);
        
        // Act & Assert
        assertEquals(1L, author.getId());
        assertEquals("John Doe", author.getName());
        assertEquals(books, author.getBooks());
    }

    @Test
    public void authorDefaultConstructorTest() {
        // Act
        Author author = new Author();
        
        // Assert
        assertEquals(null, author.getId());
        assertEquals(null, author.getName());
        assertEquals(new HashSet<>(), author.getBooks());
    }

    @Test
    public void authorSettersTest() {
        // Arrange
        Author author = new Author();
        Set<Book> books = new HashSet<>();
        
        // Act
        author.setId(1L);
        author.setName("John Doe");
        author.setBooks(books);
        
        // Assert
        assertEquals(1L, author.getId());
        assertEquals("John Doe", author.getName());
        assertEquals(books, author.getBooks());
    }
}