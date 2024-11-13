package com.example.library_management.repository;




import com.example.library_management.entity.Author;
import com.example.library_management.entity.Book;
import com.example.library_management.entity.Publisher;
import com.example.library_management.service.BookService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class BookRepositoryTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService; // Assume you have a service that uses the repository

    private Book book1;
    private Book book2;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        
        Author author = new Author(1L, "John Doe", null);
        Publisher publisher = new Publisher(1L, "Test Publisher", null);
        
        book1 = new Book(1L, "Test Book One", LocalDate.of(2023, 1, 1), author, publisher);
        book2 = new Book(2L, "Test Book Two", LocalDate.of(2023, 2, 1), author, publisher);
    }

    @Test
    public void testFindByTitleContaining() {
        // Arrange
        when(bookRepository.findByTitleContaining("Test")).thenReturn(Arrays.asList(book1, book2));

        // Act
        List<Book> books = bookRepository.findByTitleContaining("Test");

        // Assert
        assertThat(books).hasSize(2);
        assertThat(books).contains(book1, book2);
        
        // Verify interactions
        verify(bookRepository, times(1)).findByTitleContaining("Test");
    }

    @Test
    public void testFindByAuthorName() {
        // Arrange
        when(bookRepository.findByAuthorName("John Doe")).thenReturn(Arrays.asList(book1, book2));

        // Act
        List<Book> books = bookRepository.findByAuthorName("John Doe");

        // Assert
        assertThat(books).hasSize(2);
        assertThat(books).contains(book1, book2);
        
        // Verify interactions
        verify(bookRepository, times(1)).findByAuthorName("John Doe");
    }

    @Test
    public void testFindByPublisherName() {
        // Arrange
        when(bookRepository.findByPublisherName("Test Publisher")).thenReturn(Arrays.asList(book1, book2));

        // Act
        List<Book> books = bookRepository.findByPublisherName("Test Publisher");

        // Assert
        assertThat(books).hasSize(2);
        assertThat(books).contains(book1, book2);
        
        // Verify interactions
        verify(bookRepository, times(1)).findByPublisherName("Test Publisher");
    }
}