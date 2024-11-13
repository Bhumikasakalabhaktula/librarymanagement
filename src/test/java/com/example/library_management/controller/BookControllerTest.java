package com.example.library_management.controller;



import com.example.library_management.entity.Book;
import com.example.library_management.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class BookControllerTest {

    @Mock
    private BookService bookService;

    @InjectMocks
    private BookController bookController;

    private Book book1;
    private Book book2;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        
        book1 = new Book(1L, "Test Book One", LocalDate.of(2023, 1, 1), null, null);
        book2 = new Book(2L, "Test Book Two", LocalDate.of(2023, 2, 1), null, null);
    }

    @Test
    public void testCreateBook() {
        // Arrange
        when(bookService.createBook(any(Book.class))).thenReturn(book1);

        // Act
        ResponseEntity<String> response = bookController.createBook(book1);

        // Assert
        assertThat(response.getStatusCodeValue()).isEqualTo(201);
        assertThat(response.getBody()).isEqualTo("Book created successfully!");
        verify(bookService, times(1)).createBook(book1);
    }

    @Test
    public void testGetAllBooks() {
        // Arrange
        when(bookService.getAllBooks()).thenReturn(Arrays.asList(book1, book2));

        // Act
        ResponseEntity<List<Book>> response = bookController.getAllBooks();

        // Assert
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).hasSize(2);
        assertThat(response.getBody()).contains(book1, book2);
        verify(bookService, times(1)).getAllBooks();
    }

    @Test
    public void testGetBookById() {
        // Arrange
        when(bookService.getBookById(1L)).thenReturn(book1);

        // Act
        ResponseEntity<Book> response = bookController.getBookById(1L);

        // Assert
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).isEqualTo(book1);
        verify(bookService, times(1)).getBookById(1L);
    }

    @Test
    public void testUpdateBook() {
        // Arrange
        when(bookService.updateBook(1L, book1)).thenReturn(book1);

        // Act
        ResponseEntity<Book> response = bookController.updateBook(1L, book1);

        // Assert
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).isEqualTo(book1);
        verify(bookService, times(1)).updateBook(1L, book1);
    }

    @Test
    public void testDeleteBook() {
        // Arrange
        when(bookService.deleteBook(1L)).thenReturn("Book deleted successfully!");

        // Act
        ResponseEntity<String> response = bookController.deleteBook(1L);

        // Assert
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).isEqualTo("Book deleted successfully!");
        verify(bookService, times(1)).deleteBook(1L);
    }

    @Test
    public void testSearchBooks() {
        // Arrange
        when(bookService.searchBooks("Test")).thenReturn(Arrays.asList(book1, book2));

        // Act
        ResponseEntity<List<Book>> response = bookController.searchBooks("Test");

        // Assert
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).hasSize(2);
        assertThat(response.getBody()).contains(book1, book2);
        verify(bookService, times(1)).searchBooks("Test");
    }

    @Test
    public void testSortBooksByTitle() {
        // Arrange
        when(bookService.sortBooksByTitle()).thenReturn(Arrays.asList(book1, book2));

        // Act
        ResponseEntity<List<Book>> response = bookController.sortBooksByTitle();

        // Assert
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).hasSize (2);
        assertThat(response.getBody()).contains(book1, book2);
        verify(bookService, times(1)).sortBooksByTitle();
    }

    @Test
    public void testSortBooksByPublicationDate() {
        // Arrange
        when(bookService.sortBooksByPublicationDate()).thenReturn(Arrays.asList(book1, book2));

        // Act
        ResponseEntity<List<Book>> response = bookController.sortBooksByPublicationDate();

        // Assert
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).hasSize(2);
        assertThat(response.getBody()).contains(book1, book2);
        verify(bookService, times(1)).sortBooksByPublicationDate();
    }

    @Test
    public void testCountBooksByAuthor() {
        // Arrange
        Map<String, Long> authorCount = new HashMap<>();
        authorCount.put("John Doe", 2L);
        when(bookService.countBooksByAuthor()).thenReturn(authorCount);

        // Act
        ResponseEntity<Map<String, Long>> response = bookController.countBooksByAuthor();

        // Assert
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).isEqualTo(authorCount);
        verify(bookService, times(1)).countBooksByAuthor();
    }
}