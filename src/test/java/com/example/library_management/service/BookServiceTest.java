package com.example.library_management.service;



//import com.example.library_management.entity.Book;
//import com.example.library_management.entity.Author;
//import com.example.library_management.entity.Publisher;
//import com.example.library_management.exception.ResourceNotFoundException;
//import com.example.library_management.exception.InvalidDataException;
//import com.example.library_management.repository.BookRepository;
//import com.example.library_management.repository.AuthorRepository;
//import com.example.library_management.repository.PublisherRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.time.LocalDate;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//
//public class BookServiceTest {
//
//    @Mock
//    private BookRepository bookRepository;
//
//    @Mock
//    private AuthorRepository authorRepository;
//
//    @Mock
//    private PublisherRepository publisherRepository;
//
//    @InjectMocks
//    private BookService bookService;
//
//    private Book book;
//    private Author author;
//    private Publisher publisher;
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.openMocks(this);
//        
//        author = new Author(1L, "John Doe", null);
//        publisher = new Publisher(1L, "Test Publisher", null);
//        book = new Book(1L, "Test Book", LocalDate.of(2023, 1, 1), author, publisher);
//    }
//
//    @Test
//    public void testCreateBook() {
//        // Arrange
//        when(authorRepository.existsById(author.getId())).thenReturn(true);
//        when(publisherRepository.existsById(publisher.getId())).thenReturn(true);
//        when(bookRepository.save(any(Book.class))).thenReturn(book);
//
//        // Act
//        Book createdBook = bookService.createBook(book);
//
//        // Assert
//        assertThat(createdBook).isEqualTo(book);
//        verify(bookRepository, times(1)).save(book);
//    }
//
//    @Test
//    public void testCreateBookWithInvalidData() {
//        // Arrange
//        book.setTitle(null); // Invalid title
//        when(authorRepository.existsById(author.getId())).thenReturn(true);
//        when(publisherRepository.existsById(publisher.getId())).thenReturn(true);
//
//        // Act & Assert
//        InvalidDataException exception = assertThrows(InvalidDataException.class, () -> bookService.createBook(book));
//        assertThat(exception.getMessage()).contains("Book title cannot be null or empty.");
//    }
//
//    @Test
//    public void testGetAllBooks() {
//        // Arrange
//        when(bookRepository.findAll()).thenReturn(Arrays.asList(book));
//
//        // Act
//        List<Book> books = bookService.getAllBooks();
//
//        // Assert
//        assertThat(books).hasSize(1).contains(book);
//        verify(bookRepository, times(1)).findAll();
//    }
//
//    @Test
//    public void testGetBookById() {
//        // Arrange
//        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));
//
//        // Act
//        Book foundBook = bookService.getBookById(1L);
//
//        // Assert
//        assertThat(foundBook).isEqualTo(book);
//        verify(bookRepository, times(1)).findById(1L);
//    }
//
//    @Test
//    public void testGetBookByIdNotFound() {
//        // Arrange
//        when(bookRepository.findById(1L)).thenReturn(Optional.empty());
//
//        // Act & Assert
//        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class, () -> bookService.getBookById(1L));
//        assertThat(exception.getMessage()).isEqualTo("Book not found with id: 1");
//    }
//
//    @Test
//    public void testUpdateBook() {
//        // Arrange
//        when(bookRepository.existsById(1L)).thenReturn(true);
//        when(authorRepository.existsById(author.getId())).thenReturn(true);
//        when(publisherRepository.existsById(publisher.getId())).thenReturn(true);
//        when(bookRepository.save(any(Book.class))).thenReturn(book);
//
//        // Act
//        Book updatedBook = bookService.updateBook(1L, book);
//
//        // Assert
//        assertThat(updatedBook).isEqualTo(book);
//        verify(bookRepository, times(1)).save(book);
//    }
//
////    @Testl
////    public void testUpdateBookNotFound() {
////        // Arrange
////        when(bookRepository.existsById(1L)).thenReturn(false); // Simulate that the book does not exist
////
////        // Act & Assert
////        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class, () -> {
////            bookService.updateBook(1L, book); // Attempt to update a non-existing book
////        });
////
////        // Assert
////        assertThat(exception.getMessage()).isEqualTo("Book not found with id: 1");
////    }
//    @Test
//    public void testDeleteBook() {
//        // Arrange
//        when(bookRepository.existsById(1L)).thenReturn(true);
//
//        // Act
//        String message = bookService.deleteBook(1L);
//
//        // Assert
//        assertThat(message).isEqualTo("Book deleted successfully!");
//        verify(bookRepository, times(1)).deleteById(1L);
//    }
//
//    @Test
//    public void testDeleteBookNotFound() {
//        // Arrange
//        when(bookRepository.existsById(1L)).thenReturn(false);
//
//        // Act & Assert
//        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class, () -> bookService.deleteBook(1L));
//        assertThat(exception.getMessage()).isEqualTo("Book not found with id: 1");
//    }
//
//    @Test
//    public void testSearchBooks() {
//        // Arrange
//        when(bookRepository.findAll()).thenReturn(Arrays.asList(book));
//        
//        // Act
//        List<Book> foundBooks = bookService.searchBooks("Test");
//
//        // Assert
//        assertThat(foundBooks).hasSize(1).contains(book);
//        verify(bookRepository, times(1)).findAll();
//    }
//
//    @Test
//    public void testSortBooksByTitle() {
//        // Arrange
//        when(bookRepository.findAll()).thenReturn(Arrays.asList(book));
//
//        // Act
//        List<Book> sortedBooks = bookService.sortBooksByTitle();
//
//        // Assert
//        assertThat(sortedBooks).hasSize(1).contains(book);
//        verify(bookRepository, times(1)).findAll();
//    }
//
//    @Test
//    public void testSortBooksByPublicationDate() {
//        // Arrange
//        when(bookRepository.findAll()).thenReturn(Arrays.asList(book));
//
//        // Act
//        List<Book> sortedBooks = bookService.sortBooksByPublicationDate();
//
//        // Assert
//        assertThat(sortedBooks).hasSize(1).contains(book);
//        verify(bookRepository, times(1)).findAll();
//    }
//
//    @Test
//    public void testCountBooksByAuthor() {
//        // Arrange
//        when(bookRepository.findAll()).thenReturn(Arrays.asList(book));
//        
//        // Act
//        Map<String, Long> authorCount = bookService.countBooksByAuthor();
//
//        // Assert
//        assertThat(authorCount).containsEntry("John Doe", 1L);
//        verify(bookRepository, times(1)).findAll();
//    }
//}



import com.example.library_management.entity.Book;
import com.example.library_management.entity.Author;
import com.example.library_management.entity.Publisher;
import com.example.library_management.exception.ResourceNotFoundException;
import com.example.library_management.exception.InvalidDataException;
import com.example.library_management.repository.BookRepository;
import com.example.library_management.repository.AuthorRepository;
import com.example.library_management.repository.PublisherRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @Mock
    private AuthorRepository authorRepository;

    @Mock
    private PublisherRepository publisherRepository;

    @InjectMocks
    private BookService bookService;

    private Book book;
    private Author author;
    private Publisher publisher;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        
        author = new Author(1L, "John Doe", null);
        publisher = new Publisher(1L, "Test Publisher", null);
        book = new Book(1L, "Test Book", LocalDate.of(2023, 1, 1), author, publisher);
    }

    @Test
    public void testCreateBook() {
        when(bookRepository.save(any(Book.class))).thenReturn(book);

        Book createdBook = bookService.createBook(book);

        assertThat(createdBook).isNotNull();
        assertThat(createdBook.getId()).isEqualTo(1L);
        assertThat(createdBook.getTitle()).isEqualTo("Test Book");
    }

    @Test
    public void testGetAllBooks() {
        when(bookRepository.findAll()).thenReturn(Arrays.asList(book));

        List<Book> books = bookService.getAllBooks();

        assertThat(books).isNotEmpty();
        assertThat(books.size()).isEqualTo(1);
    }

    @Test
    public void testGetBookByIdFound() {
        when(bookRepository.findById(1L)).thenReturn(java.util.Optional.of(book));

        Book foundBook = bookService.getBookById(1L);

        assertThat(foundBook).isNotNull();
        assertThat(foundBook.getId()).isEqualTo(1L);
    }

    @Test
    public void testGetBookByIdNotFound() {
        when(bookRepository.findById(1L)).thenReturn(java.util.Optional.empty());

        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class, () -> {
            bookService.getBookById(1L);
        });

        assertThat(exception.getMessage()).isEqualTo("Book not found with id: 1");
    }

    @Test
  public void testUpdateBook() {
      // Arrange
      when(bookRepository.existsById(1L)).thenReturn(true);
      when(authorRepository.existsById(author.getId())).thenReturn(true);
      when(publisherRepository.existsById(publisher.getId())).thenReturn(true);
      when(bookRepository.save(any(Book.class))).thenReturn(book);

      // Act
     Book updatedBook = bookService.updateBook(1L, book);

      // Assert
      assertThat(updatedBook).isEqualTo(book);
      verify(bookRepository, times(1)).save(book);
  }

    @Test
    public void testUpdateBookNotFound() {
        // Arrange
        when(bookRepository.existsById(1L)).thenReturn(false);

        // Act & Assert
        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class, () -> {
            bookService.updateBook(1L, book);
        });

        assertThat(exception.getMessage()).isEqualTo("Book not found with id: 1");
    }

    @Test
    public void testDeleteBookFound() {
        when(bookRepository.existsById(1L)).thenReturn(true);

        String message = bookService.deleteBook(1L);

        assertThat(message).isEqualTo("Book deleted successfully!");
        verify(bookRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testDeleteBookNotFound() {
        when(bookRepository.existsById(1L)).thenReturn(false);

        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class, () -> {
            bookService.deleteBook(1L);
        });

        assertThat(exception.getMessage()).isEqualTo("Book not found with id: 1");
    }

    @Test
    public void testSearchBooks() {
        when(bookRepository.findAll()).thenReturn(Arrays.asList(book));

        List<Book> foundBooks = bookService.searchBooks("Test");

        assertThat(foundBooks).isNotEmpty();
        assertThat(foundBooks.size()).isEqualTo(1);
        assertThat(foundBooks.get(0).getTitle()).isEqualTo("Test Book");
    }

    @Test
    public void testSortBooksByTitle() {
        when(bookRepository.findAll()).thenReturn(Arrays.asList(book));

        List<Book> sortedBooks = bookService.sortBooksByTitle();

        assertThat(sortedBooks).isNotEmpty();
        assertThat(sortedBooks.get(0).getTitle()).isEqualTo("Test Book");
    }

    @Test
    public void testSortBooksByPublicationDate() {
        when(bookRepository.findAll()).thenReturn(Arrays.asList(book));

        List<Book> sortedBooks = bookService.sortBooksByPublicationDate();

        assertThat(sortedBooks).isNotEmpty();
        assertThat(sortedBooks.get(0).getPublicationDate()).isEqualTo(LocalDate.of(2023, 1, 1));
    }

    @Test
    public void testCountBooksByAuthor() {
        when(bookRepository.findAll()).thenReturn(Arrays.asList(book));

        Map<String, Long> report = bookService.countBooksByAuthor();

        assertThat(report).isNotEmpty();
        assertThat(report.get("John Doe")).isEqualTo(1L);
    }
}