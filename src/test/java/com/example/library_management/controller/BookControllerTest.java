package com.example.library_management.controller;



//import com.example.library_management.entity.Book;
//import com.example.library_management.service.BookService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.http.ResponseEntity;
//
//import java.time.LocalDate;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//
//public class BookControllerTest {
//
//    @Mock
//    private BookService bookService;
//
//    @InjectMocks
//    private BookController bookController;
//
//    private Book book1;
//    private Book book2;
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.openMocks(this);
//        
//        book1 = new Book(1L, "Test Book One", LocalDate.of(2023, 1, 1), null, null);
//        book2 = new Book(2L, "Test Book Two", LocalDate.of(2023, 2, 1), null, null);
//    }
//
//    @Test
//    public void testCreateBook() {
//        // Arrange
//        when(bookService.createBook(any(Book.class))).thenReturn(book1);
//
//        // Act
//        ResponseEntity<String> response = bookController.createBook(book1);
//
//        // Assert
//        assertThat(response.getStatusCodeValue()).isEqualTo(201);
//        assertThat(response.getBody()).isEqualTo("Book created successfully!");
//        verify(bookService, times(1)).createBook(book1);
//    }
//
//    @Test
//    public void testGetAllBooks() {
//        // Arrange
//        when(bookService.getAllBooks()).thenReturn(Arrays.asList(book1, book2));
//
//        // Act
//        ResponseEntity<List<Book>> response = bookController.getAllBooks();
//
//        // Assert
//        assertThat(response.getStatusCodeValue()).isEqualTo(200);
//        assertThat(response.getBody()).hasSize(2);
//        assertThat(response.getBody()).contains(book1, book2);
//        verify(bookService, times(1)).getAllBooks();
//    }
//
//    @Test
//    public void testGetBookById() {
//        // Arrange
//        when(bookService.getBookById(1L)).thenReturn(book1);
//
//        // Act
//        ResponseEntity<Book> response = bookController.getBookById(1L);
//
//        // Assert
//        assertThat(response.getStatusCodeValue()).isEqualTo(200);
//        assertThat(response.getBody()).isEqualTo(book1);
//        verify(bookService, times(1)).getBookById(1L);
//    }
//
//    @Test
//    public void testUpdateBook() {
//        // Arrange
//        when(bookService.updateBook(1L, book1)).thenReturn(book1);
//
//        // Act
//        ResponseEntity<Book> response = bookController.updateBook(1L, book1);
//
//        // Assert
//        assertThat(response.getStatusCodeValue()).isEqualTo(200);
//        assertThat(response.getBody()).isEqualTo(book1);
//        verify(bookService, times(1)).updateBook(1L, book1);
//    }
//
//    @Test
//    public void testDeleteBook() {
//        // Arrange
//        when(bookService.deleteBook(1L)).thenReturn("Book deleted successfully!");
//
//        // Act
//        ResponseEntity<String> response = bookController.deleteBook(1L);
//
//        // Assert
//        assertThat(response.getStatusCodeValue()).isEqualTo(200);
//        assertThat(response.getBody()).isEqualTo("Book deleted successfully!");
//        verify(bookService, times(1)).deleteBook(1L);
//    }
//
//    @Test
//    public void testSearchBooks() {
//        // Arrange
//        when(bookService.searchBooks("Test")).thenReturn(Arrays.asList(book1, book2));
//
//        // Act
//        ResponseEntity<List<Book>> response = bookController.searchBooks("Test");
//
//        // Assert
//        assertThat(response.getStatusCodeValue()).isEqualTo(200);
//        assertThat(response.getBody()).hasSize(2);
//        assertThat(response.getBody()).contains(book1, book2);
//        verify(bookService, times(1)).searchBooks("Test");
//    }
//
//    @Test
//    public void testSortBooksByTitle() {
//        // Arrange
//        when(bookService.sortBooksByTitle()).thenReturn(Arrays.asList(book1, book2));
//
//        // Act
//        ResponseEntity<List<Book>> response = bookController.sortBooksByTitle();
//
//        // Assert
//        assertThat(response.getStatusCodeValue()).isEqualTo(200);
//        assertThat(response.getBody()).hasSize (2);
//        assertThat(response.getBody()).contains(book1, book2);
//        verify(bookService, times(1)).sortBooksByTitle();
//    }
//
//    @Test
//    public void testSortBooksByPublicationDate() {
//        // Arrange
//        when(bookService.sortBooksByPublicationDate()).thenReturn(Arrays.asList(book1, book2));
//
//        // Act
//        ResponseEntity<List<Book>> response = bookController.sortBooksByPublicationDate();
//
//        // Assert
//        assertThat(response.getStatusCodeValue()).isEqualTo(200);
//        assertThat(response.getBody()).hasSize(2);
//        assertThat(response.getBody()).contains(book1, book2);
//        verify(bookService, times(1)).sortBooksByPublicationDate();
//    }
//
//    @Test
//    public void testCountBooksByAuthor() {
//        // Arrange
//        Map<String, Long> authorCount = new HashMap<>();
//        authorCount.put("John Doe", 2L);
//        when(bookService.countBooksByAuthor()).thenReturn(authorCount);
//
//        // Act
//        ResponseEntity<Map<String, Long>> response = bookController.countBooksByAuthor();
//
//        // Assert
//        assertThat(response.getStatusCodeValue()).isEqualTo(200);
//        assertThat(response.getBody()).isEqualTo(authorCount);
//        verify(bookService, times(1)).countBooksByAuthor();
//    }
//}



//import com.example.library_management.entity.Book;
//import com.example.library_management.service.BookService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.http.ResponseEntity;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Map;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//
//public class BookControllerTest {
//
//    @Mock
//    private BookService bookService;
//
//    @InjectMocks
//    private BookController bookController;
//
//    private Book book;
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.openMocks(this);
//        book = new Book(1L, "Test Book", null, null, null);
//    }
//
//    @Test
//    public void testCreateBook() {
//        when(bookService.createBook(any(Book.class))).thenReturn(book);
//
//        ResponseEntity<Book> response = bookController.createBook(book);
//
//        assertThat(response.getStatusCodeValue()).isEqualTo(201);
//        assertThat(response.getBody()).isNotNull();
//        assertThat(response.getBody().getTitle()).isEqualTo("Test Book");
//    }
//
//    @Test
//    public void testGetAllBooks() {
//        when(bookService.getAllBooks()).thenReturn(Arrays.asList(book));
//
//        ResponseEntity<List<Book>> response = bookController.getAllBooks();
//
//        assertThat(response.getStatusCodeValue()).isEqualTo(200);
//        assertThat(response.getBody()).isNotEmpty();
//        assertThat(response.getBody().get(0).getTitle()).isEqualTo("Test Book");
//    }
//
//    @Test
//    public void testGetBookById() {
//        when(bookService.getBookById(1L)).thenReturn(book);
//
//        ResponseEntity<Book> response = bookController.getBookById(1L);
//
//        assertThat(response.getStatusCodeValue()).isEqualTo(200);
//        assertThat(response.getBody()).isNotNull();
//        assertThat(response.getBody().getId()).isEqualTo(1L);
//    }
//
//    @Test
//    public void testUpdateBook() {
//        when(bookService.updateBook(any(Long.class), any(Book.class))).thenReturn(book);
//
//        ResponseEntity<Book> response = bookController.updateBook(1L, book);
//
//        assertThat(response.getStatusCodeValue()).isEqualTo(200);
//        assertThat(response.getBody()).isNotNull();
//        assertThat(response.getBody().getId()).isEqualTo(1L);
//    }
//
//    @Test
//    public void testDeleteBook() {
//        when(bookService.deleteBook(1L)).thenReturn("Book deleted successfully!");
//
//        ResponseEntity<String> response = bookController.deleteBook(1L);
//
//        assertThat(response.getStatusCodeValue()).isEqualTo(200);
//        assertThat(response.getBody()).isEqualTo("Book deleted successfully!");
//    }
//
//    @Test
//    public void testSearchBooks() {
//        when(bookService.searchBooks("Test")).thenReturn(Arrays.asList(book));
//
//        ResponseEntity<List<Book>> response = bookController.searchBooks("Test");
//
//        assertThat(response.getStatusCodeValue()).isEqualTo(200);
//        assertThat(response.getBody()).isNotEmpty();
//        assertThat(response.getBody().get(0).getTitle()).isEqualTo("Test Book");
//    }
//
//
//
//
//    @Test
//    public void testSortBooksByTitle() {
//        when(bookService.sortBooksByTitle()).thenReturn(Arrays.asList(book));
//
//        ResponseEntity<List<Book>> response = bookController.sortBooksByTitle();
//
//        assertThat(response.getStatusCodeValue()).isEqualTo(200);
//        assertThat(response.getBody()).isNotEmpty();
//        assertThat(response.getBody().get(0).getTitle()).isEqualTo("Test Book");
//    }
//
//    @Test
//    public void testSortBooksByPublicationDate() {
//        when(bookService.sortBooksByPublicationDate()).thenReturn(Arrays.asList(book));
//
//        ResponseEntity<List<Book>> response = bookController.sortBooksByPublicationDate();
//
//        assertThat(response.getStatusCodeValue()).isEqualTo(200);
//        assertThat(response.getBody()).isNotEmpty();
//        assertThat(response.getBody().get(0).getPublicationDate()).isNull(); // Adjust based on your test data
//    }
//
//    @Test
//    public void testCountBooksByAuthor() {
//        when(bookService.countBooksByAuthor()).thenReturn(Map.of("John Doe", 1L));
//
//        ResponseEntity<Map<String, Long>> response = bookController.countBooksByAuthor();
//
//        assertThat(response.getStatusCodeValue()).isEqualTo(200);
//        assertThat(response.getBody()).isNotEmpty();
//        assertThat(response.getBody().get("John Doe")).isEqualTo(1L);
//    }
//}

import com.example.library_management.entity.Book;
import com.example.library_management.exception.ResourceNotFoundException;
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
        when(bookService.createBook(any(Book.class))).thenReturn(book1);
        ResponseEntity<String> response = bookController.createBook(book1);
        assertThat(response.getStatusCodeValue()).isEqualTo(201);
        assertThat(response.getBody()).isEqualTo("Book created successfully!");
    }

    @Test
    public void testGetAllBooks() {
        when(bookService.getAllBooks()).thenReturn(Arrays.asList(book1, book2));
        ResponseEntity<List<Book>> response = bookController.getAllBooks();
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).hasSize(2).contains(book1, book2);
    }

    @Test
    public void testGetBookById() {
        when(bookService.getBookById(1L)).thenReturn(book1);
        ResponseEntity<Book> response = bookController.getBookById(1L);
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).isEqualTo(book1);
    }

    @Test
    public void testGetBookById_NotFound() {
        when(bookService.getBookById(1L)).thenThrow(new ResourceNotFoundException("Book not found"));
//        ResponseEntity<Book> response = bookController.getBookById(1L);
//        assertThat(response.getStatusCodeValue()).isEqualTo(404);
    }

    @Test
    public void testUpdateBook() {
        when(bookService.updateBook(1L, book1)).thenReturn(book1);
        ResponseEntity<Book> response = bookController.updateBook(1L, book1);
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).isEqualTo(book1);
    }

//    @Test
//    public void testUpdateBook_NotFound() {
//        when(bookService.updateBook(any(Long.class), any(Book.class))).thenThrow(new ResourceNotFoundException("Book not found"));
//        ResponseEntity<Book> response = bookController.updateBook(1L, book1);
//        assertThat(response.getStatusCodeValue()).isEqualTo(404);
//    }

    @Test
    public void testDeleteBook() {
        when(bookService.deleteBook(1L)).thenReturn("Book deleted successfully!");
        ResponseEntity<String> response = bookController.deleteBook(1L);
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).isEqualTo("Book deleted successfully!");
    }

    @Test
    public void testSearchBooks() {
        when(bookService.searchBooks("Test")).thenReturn(Arrays.asList(book1, book2));
        ResponseEntity<List<Book>> response = bookController.searchBooks("Test");
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).hasSize(2).contains(book1, book2);
    }

    @Test
    public void testSearchBooks_NoResults() {
        when(bookService.searchBooks("Nonexistent")).thenReturn(Arrays.asList());
        ResponseEntity<List<Book>> response = bookController.searchBooks("Nonexistent");
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).isEmpty();
    }

    @Test
    public void testSortBooksByTitle() {
        when(bookService.sortBooksByTitle()).thenReturn(Arrays.asList(book1, book2));
        ResponseEntity<List <Book>> response = bookController.sortBooksByTitle();
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).hasSize(2).contains(book1, book2);
    }

    @Test
    public void testSortBooksByTitle_NoBooks() {
        when(bookService.sortBooksByTitle()).thenReturn(Arrays.asList());
        ResponseEntity<List<Book>> response = bookController.sortBooksByTitle();
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).isEmpty();
    }

    @Test
    public void testSortBooksByPublicationDate() {
        when(bookService.sortBooksByPublicationDate()).thenReturn(Arrays.asList(book1, book2));
        ResponseEntity<List<Book>> response = bookController.sortBooksByPublicationDate();
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).hasSize(2).contains(book1, book2);
    }

    @Test
    public void testSortBooksByPublicationDate_NoBooks() {
        when(bookService.sortBooksByPublicationDate()).thenReturn(Arrays.asList());
        ResponseEntity<List<Book>> response = bookController.sortBooksByPublicationDate();
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).isEmpty();
    }

    @Test
    public void testCountBooksByAuthor() {
        Map<String, Long> authorCount = new HashMap<>();
        authorCount.put("John Doe", 2L);
        when(bookService.countBooksByAuthor()).thenReturn(authorCount);
        ResponseEntity<Map<String, Long>> response = bookController.countBooksByAuthor();
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).isEqualTo(authorCount);
    }

    @Test
    public void testCountBooksByAuthor_NoBooks() {
        when(bookService.countBooksByAuthor()).thenReturn(new HashMap<>());
        ResponseEntity<Map<String, Long>> response = bookController.countBooksByAuthor();
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).isEmpty();
    }

//    @Test
//    public void testCreateBook_InvalidData() {
//        Book invalidBook = new Book(null, "", null, null, null); // Assuming title cannot be empty
//        ResponseEntity<String> response = bookController.createBook(invalidBook);
//        assertThat(response.getStatusCodeValue()).isEqualTo(400); // Assuming you return 400 for bad requests
//        assertThat(response.getBody()).contains("Invalid data");
//    }
}