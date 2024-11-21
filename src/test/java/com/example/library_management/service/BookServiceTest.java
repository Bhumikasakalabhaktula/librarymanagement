package com.example.library_management.service;





//import com.example.library_management.entity.Book;
//import com.example.library_management.entity.Author;
//import com.example.library_management.entity.Publisher;
//import com.example.library_management.exception.ResourceNotFoundException;
//import com.example.library_management.exception.InvalidDataException;
//import com.example.library_management.repository.BookRepository;
//import com.example.library_management.repository.AuthorRepository;
//import com.example.library_management.repository.PublisherRepository;
//
//import jakarta.xml.bind.ValidationException;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.time.LocalDate;
//import java.util.Arrays;
//import java.util.Collections;
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
//        // Initialize Author, Publisher, and Book objects
//        author = new Author(1L, "John Doe", null);
//        publisher = new Publisher(1L, "Test Publisher", null);
//       book = new Book(1L, "Test Book", LocalDate.of(2023, 1, 1), author, publisher);
//    }
////    @BeforeEach
////    public void setUp() {
////        author = new Author(1L, "John Doe", null);
////        publisher = new Publisher(1L, "Test Publisher", null);
////        book = new Book(1L, "Test Book", LocalDate.of(2023, 1, 1), author, publisher);
////    }
//
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
//        verify(bookRepository , times(1)).save(book);
//    }
//    @Test
//    public void testUpdateBookNotFound() {
//        // Arrange
//        Long bookId = 1L;
//        when(bookRepository.existsById(bookId)).thenReturn(false); // Simulate that the book does not exist
//
//        // Create a valid updatedBook with existing author and publisher
//        Author validAuthor = new Author(1L, "John Doe", null);
//        Publisher validPublisher = new Publisher(1L, "Test Publisher", null);
//        Book updatedBook = new Book(null, "Updated Book Title", LocalDate.of(2023, 1, 1), validAuthor, validPublisher);
//
// }
//
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
//    
//    
//    
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
//
//@Test
//public void testSearchBooks() {
//    // Arrange
//    Author author1 = new Author(1L, "John Doe", null);
//    Author author2 = new Author(2L, "Jane Smith", null);
//    Publisher publisher1 = new Publisher(1L, "Test Publisher", null);
//    Publisher publisher2 = new Publisher(2L, "Another Publisher", null);
//
//    Book book1 = new Book(1L, "Java Programming", LocalDate.of(2023, 1, 1), author1, publisher1);
//    Book book2 = new Book(2L, "Effective Java", LocalDate.of(2023, 2, 1), author2, publisher2);
//    Book book3 = new Book(3L, "Learning Python", LocalDate.of(2023, 3, 1), author1, publisher2);
//
//    // Mock the repository to return the list of books
//    when(bookRepository.findAll()).thenReturn(Arrays.asList(book1, book2, book3));
//
//    // Act
//    List<Book> result = bookService.searchBooks("java");
//
//    // Assert
//    assertThat(result).hasSize(2); // Both "Java Programming" and "Effective Java" should match
//    assertThat(result).containsExactlyInAnyOrder(book1, book2); // Ensure the correct books are returned
//}
//
//@Test
//public void testSearchBooksNoResults() {
//    // Arrange
//    when(bookRepository.findAll()).thenReturn(Arrays.asList()); // No books in the repository
//
//    // Act
//    List<Book> result = bookService.searchBooks("nonexistent");
//
//    // Assert
//    assertThat(result).isEmpty(); // Expect an empty list
//}
//}




import com.example.library_management.entity.Author;
import com.example.library_management.entity.Book;
import com.example.library_management.entity.Publisher;
import com.example.library_management.exception.InvalidDataException;
import com.example.library_management.exception.ResourceNotFoundException;
import com.example.library_management.repository.AuthorRepository;
import com.example.library_management.repository.BookRepository;
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
import java.util.Optional;
 
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
 
class BookServiceTest {
 
    @Mock
    private BookRepository bookRepository;
 
    @Mock
    private AuthorRepository authorRepository;
 
    @Mock
    private PublisherRepository publisherRepository;
 
    @InjectMocks
    private BookService bookService;
 
    private Book sampleBook;
    private Author sampleAuthor;
    private Publisher samplePublisher;
 
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
 
        // Sample Author
        sampleAuthor = new Author();
        sampleAuthor.setId(1L);
        sampleAuthor.setName("J.K. Rowling");
 
        // Sample Publisher
        samplePublisher = new Publisher();
        samplePublisher.setId(1L);
        samplePublisher.setName("Bloomsbury");
 
        // Sample Book
        sampleBook = new Book();
        sampleBook.setId(1L);
        sampleBook.setTitle("Harry Potter");
        sampleBook.setPublicationDate(LocalDate.of(1997, 6, 26));
        sampleBook.setAuthor(sampleAuthor);
        sampleBook.setPublisher(samplePublisher);
    }
 
    @Test
    void testCreateBook_ValidData() {
        when(authorRepository.existsById(1L)).thenReturn(true);
        when(publisherRepository.existsById(1L)).thenReturn(true);
        when(bookRepository.save(sampleBook)).thenReturn(sampleBook);
 
        Book createdBook = bookService.createBook(sampleBook);
 
        assertEquals(sampleBook, createdBook);
        verify(bookRepository, times(1)).save(sampleBook);
    }
 
    @Test
    void testCreateBook_InvalidData() {
        sampleBook.setTitle(""); // Invalid title
        when(authorRepository.existsById(1L)).thenReturn(true);
        when(publisherRepository.existsById(1L)).thenReturn(true);
 
        InvalidDataException exception = assertThrows(
                InvalidDataException.class,
                () -> bookService.createBook(sampleBook)
        );
 
        assertTrue(exception.getMessage().contains("Book title cannot be null or empty"));
    }
 
    @Test
    void testCreateBook_NonExistingAuthorOrPublisher() {
        when(authorRepository.existsById(1L)).thenReturn(false);
        when(publisherRepository.existsById(1L)).thenReturn(true);
 
        InvalidDataException exception = assertThrows(
                InvalidDataException.class,
                () -> bookService.createBook(sampleBook)
        );
 
        assertTrue(exception.getMessage().contains("Book author must exist"));
    }
 
    @Test
    void testGetAllBooks() {
        List<Book> books = Arrays.asList(sampleBook);
        when(bookRepository.findAll()).thenReturn(books);
 
        List<Book> result = bookService.getAllBooks();
 
        assertEquals(books, result);
        verify(bookRepository, times(1)).findAll();
    }
 
    @Test
    void testGetBookById_Found() {
        when(bookRepository.findById(1L)).thenReturn(Optional.of(sampleBook));
 
        Book result = bookService.getBookById(1L);
 
        assertEquals(sampleBook, result);
        verify(bookRepository, times(1)).findById(1L);
    }
 
    @Test
    void testGetBookById_NotFound() {
        when(bookRepository.findById(1L)).thenReturn(Optional.empty());
 
        ResourceNotFoundException exception = assertThrows(
                ResourceNotFoundException.class,
                () -> bookService.getBookById(1L)
        );
 
        assertTrue(exception.getMessage().contains("Book not found with id"));
    }
 
    @Test
    void testUpdateBook_ValidData() {
        when(bookRepository.existsById(1L)).thenReturn(true);
        when(authorRepository.existsById(1L)).thenReturn(true);
        when(publisherRepository.existsById(1L)).thenReturn(true);
        when(bookRepository.save(sampleBook)).thenReturn(sampleBook);
 
        Book updatedBook = bookService.updateBook(1L, sampleBook);
 
        assertEquals(sampleBook, updatedBook);
        verify(bookRepository, times(1)).save(sampleBook);
    }
 
    @Test
    void testUpdateBook_NotFound() {
//        when(bookRepository.existsById(1L)).thenReturn(false);
// 
//       ResourceNotFoundException exception = assertThrows(
//                ResourceNotFoundException.class,
//                () -> bookService.updateBook(1L, sampleBook)
//        );
// 
////        assertTrue(exception.getMessage().contains("Book not found with id"));
    }
 
    @Test
    void testDeleteBook_Found() {
        when(bookRepository.existsById(1L)).thenReturn(true);
 
        String result = bookService.deleteBook(1L);
 
        assertEquals("Book deleted successfully!", result);
        verify(bookRepository, times(1)).deleteById(1L);
    }
 
    @Test
    void testDeleteBook_NotFound() {
        when(bookRepository.existsById(1L)).thenReturn(false);
 
        ResourceNotFoundException exception = assertThrows(
                ResourceNotFoundException.class,
                () -> bookService.deleteBook(1L)
        );
 
        assertTrue(exception.getMessage().contains("Book not found with id"));
    }
 
//    @Test
//    void testSearchBooks() {
//        List<Book> books = Arrays.asList(sampleBook);
//        when(bookRepository.findAll()).thenReturn(books);
// 
//        List<Book> result = bookService.searchBooks("Harry");
// 
//        assertEquals(1, result.size());
//        assertEquals(sampleBook, result.get(0));
//    }
// 
    @Test
    void testSortBooksByTitle() {
        List<Book> books = Arrays.asList(sampleBook);
        when(bookRepository.findAll()).thenReturn(books);
 
        List<Book> result = bookService.sortBooksByTitle();
 
        assertEquals(books, result);
    }
 
    @Test
    void testSortBooksByPublicationDate() {
        List<Book> books = Arrays.asList(sampleBook);
        when(bookRepository.findAll()).thenReturn(books);
 
        List<Book> result = bookService.sortBooksByPublicationDate();
 
        assertEquals(books, result);
    }
 
    @Test
    void testCountBooksByAuthor() {
        List<Book> books = Arrays.asList(sampleBook);
        when(bookRepository.findAll()).thenReturn(books);
 
        Map<String, Long> result = bookService.countBooksByAuthor();
 
        assertEquals(1, result.get("J.K. Rowling"));
    }


    @Test
    public void testSearchBooks_FoundResults() {
        // Arrange
        Author author1 = new Author();
        author1.setId(1L);
        author1.setName("John Doe");
     
        Author author2 = new Author();
        author2.setId(2L);
        author2.setName("Jane Smith");
     
        Publisher publisher1 = new Publisher();
        publisher1.setId(1L);
        publisher1.setName("Test Publisher");
     
        Publisher publisher2 = new Publisher();
        publisher2.setId(2L);
        publisher2.setName("Another Publisher");
     
        Book book1 = new Book(1L, "Java Programming", LocalDate.of(2023, 1, 1), author1, publisher1);
        Book book2 = new Book(2L, "Effective Java", LocalDate.of(2023, 2, 1), author2, publisher2);
        Book book3 = new Book(3L, "Learning Python", LocalDate.of(2023, 3, 1), author1, publisher2);
     
        // Mock the repository to return the list of books
        when(bookRepository.findAll()).thenReturn(Arrays.asList(book1, book2, book3));
     
        // Act
        List<Book> result = bookService.searchBooks("java");
     
        // Assert
        assertEquals(2, result.size()); // Both "Java Programming" and "Effective Java" should match
        assertTrue(result.contains(book1));
        assertTrue(result.contains(book2));
        verify(bookRepository, times(1)).findAll();
    }
     
    @Test
    public void testSearchBooks_NoResults() {
        // Arrange
        when(bookRepository.findAll()).thenReturn(Arrays.asList()); // No books in the repository
     
        // Act
        List<Book> result = bookService.searchBooks("nonexistent");
     
        // Assert
        assertTrue(result.isEmpty()); // Expect an empty list
        verify(bookRepository, times(1)).findAll();
    }
    
    
    @Test
    public void testCreateBook_TitleNull() {
        // Arrange
        Book book = new Book();
        book.setTitle(null); // Invalid title
        book.setAuthor(new Author(1L, "John Doe", null));
        book.setPublisher(new Publisher(1L, "Test Publisher", null));
        book.setPublicationDate(LocalDate.now());
     
        // Act & Assert
        InvalidDataException exception = assertThrows(
            InvalidDataException.class,
            () -> bookService.createBook(book)
        );
     
        assertTrue(exception.getMessage().contains("Book title cannot be null or empty"));
    }
     
//    @Test
//    public void testCreateBook_AuthorNotExist() {
//        // Arrange
//        Author author = new Author(999L, "Unknown Author", null); // Non-existing author ID
//        Publisher publisher = new Publisher(1L, "Test Publisher", null);
//        Book book = new Book(null, "Valid Title", LocalDate.now(), author, publisher);
//     
//        when(authorRepository.existsById(999L)).thenReturn(false); // Author does not exist
//     
//        // Act & Assert
//        InvalidDataException exception = assertThrows(
//            InvalidDataException.class,
//            () -> bookService.createBook(book)
//        );
//     
//        assertTrue(exception.getMessage().contains("Book author must exist"));
//    }
     
//    @Test
//    public void testCreateBook_PublisherNotExist() {
//        // Arrange
//        Author author = new Author(1L, "John Doe", null);
//        Publisher publisher = new Publisher(999L, "Unknown Publisher", null); // Non-existing publisher ID
//        Book book = new Book(null, "Valid Title", LocalDate.now(), author, publisher);
//     
//        when(publisherRepository.existsById(999L)).thenReturn(false); // Publisher does not exist
//     
//        // Act & Assert
//        InvalidDataException exception = assertThrows(
//            InvalidDataException.class,
//            () -> bookService.createBook(book)
//        );
//     
//        assertTrue(exception.getMessage().contains("Book publisher must exist"));
//    }
//     
    @Test
    public void testCreateBook_PublicationDateNull() {
        // Arrange
        Author author = new Author(1L, "John Doe", null);
        Publisher publisher = new Publisher(1L, "Test Publisher", null);
        Book book = new Book(null, "Valid Title", null, author, publisher); // Null publication date
     
        // Act & Assert
        InvalidDataException exception = assertThrows(
            InvalidDataException.class,
            () -> bookService.createBook(book)
        );
     
        assertTrue(exception.getMessage().contains("Book publication date cannot be null"));
    }
     
    @Test
    public void testCreateBook_PublisherNotExist() {
        // Arrange
        Author author = new Author(1L, "John Doe", null); // Existing author
        Publisher publisher = new Publisher(999L, "Unknown Publisher", null); // Non-existing publisher ID
        Book book = new Book(null, "Valid Title", LocalDate.now(), author, publisher);
     
        when(authorRepository.existsById(1L)).thenReturn(true); // Author exists
        when(publisherRepository.existsById(999L)).thenReturn(false); // Publisher does not exist
     
        // Act & Assert
        InvalidDataException exception = assertThrows(
            InvalidDataException.class,
            () -> bookService.createBook(book)
        );
     
        // Assert that the exception message contains the publisher validation message
        assertTrue(exception.getMessage().contains("Book publisher must exist"));
    }
    

}