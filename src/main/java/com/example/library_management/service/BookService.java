package com.example.library_management.service;






//import org.springframework.stereotype.Service;
//
//import com.example.library_management.entity.Book;
//import com.example.library_management.repository.BookRepository;
//
//import java.time.LocalDate;
//import java.util.Comparator;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//import java.util.stream.Collectors;
// 
//@Service
//public class BookService {
// 
//    private final BookRepository bookRepository;
// 
//    public BookService(BookRepository bookRepository) {
//        this.bookRepository = bookRepository;
//    }
// 
//    // Create Book
//   public Book createBook(Book book) {
//        return bookRepository.save(book);
//    }
// 
//    // Get all Books
//    public List<Book> getAllBooks() {
//        return bookRepository.findAll();
//    }
// 
//    // Get Book by ID
//    public Optional<Book> getBookById(Long id) {
//        return bookRepository.findById(id);
//    }
// 
//    // Update Book
//    public Book updateBook(Long id, Book updatedBook) {
//        updatedBook.setId(id);
//        return bookRepository.save(updatedBook);
//    }
// 
//    // Delete Book
//    public void deleteBook(Long id) {
//        bookRepository.deleteById(id);
//    }
// 
// // Search Books by Title, Author, or Publisher
//    public List<Book> searchBooks(String searchTerm) {
//        return bookRepository.findAll().stream()
//               .filter(book -> book.getTitle().toLowerCase().contains(searchTerm.toLowerCase()) ||
//                                book.getAuthor().getName().toLowerCase().contains(searchTerm.toLowerCase()) ||
//                                book.getPublisher().getName().toLowerCase().contains(searchTerm.toLowerCase()))
//                .collect(Collectors.toList());
//    }
// 
//    // Sort Books by Title
//    public List<Book> sortBooksByTitle() {
//        return bookRepository.findAll().stream()
//                .sorted(Comparator.comparing(Book::getTitle))
//               .collect(Collectors.toList());
//    }
// 
//    
// 
//    // Sort Books by Publication Date
//    public List<Book> sortBooksByPublicationDate() {
//        return bookRepository.findAll().stream()
//                .sorted(Comparator.comparing(Book::getPublicationDate))
//                .collect(Collectors.toList());
//    }
//// Generate Report: Count of Books by Author
//    public Map<String, Long> countBooksByAuthor() {
//        return bookRepository.findAll().stream()
//                .collect(Collectors.groupingBy(book -> book.getAuthor().getName(), Collectors.counting()));
//    }
//}
//
//
//
//
//


import com.example.library_management.entity.Book;
import com.example.library_management.entity.Author; // Assuming you have an Author entity
import com.example.library_management.entity.Publisher; // Assuming you have a Publisher entity
import com.example.library_management.exception.ResourceNotFoundException;
import com.example.library_management.exception.InvalidDataException;
import com.example.library_management.repository.BookRepository;
import com.example.library_management.repository.AuthorRepository; // Assuming you have an AuthorRepository
import com.example.library_management.repository.PublisherRepository; // Assuming you have a PublisherRepository
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository; // Inject AuthorRepository
    private final PublisherRepository publisherRepository; // Inject PublisherRepository

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

   public Book createBook(Book book) {
        validateBook(book);
        return bookRepository.save(book);
    }
    
////     Create Book
//  public Book createBook(Book book) {
//      return bookRepository.save(book);
//  }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));
    }

//    public Book updateBook(Long id, Book updatedBook) {
//        validateBook(updatedBook);
//        if (!bookRepository.existsById(id)) {
//            throw new ResourceNotFoundException("Book not found with id: " + id);
//        }
//        updatedBook.setId(id);
//        return bookRepository.save(updatedBook);
//    }
    
    public Book updateBook(Long id, Book updatedBook) {
        validateBook(updatedBook);
        
        if (!bookRepository.existsById(id)) {
            throw new ResourceNotFoundException("Book not found with id: " + id);
        } else {
            updatedBook.setId(id);
            return bookRepository.save(updatedBook);
        }
    }

    public String deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new ResourceNotFoundException("Book not found with id: " + id);
        }
        bookRepository.deleteById(id);
        return "Book deleted successfully!";
    }

  private  void validateBook(Book book) {
        StringBuilder errorMessage = new StringBuilder();
        boolean authorExists = true;
        boolean publisherExists = true;

        if (book.getTitle() == null || book.getTitle().isEmpty()) {
            errorMessage.append("Book title cannot be null or empty. ");
        }

        if (book.getAuthor() == null || book.getAuthor().getId() == null || !authorRepository.existsById(book.getAuthor().getId())) {
            authorExists = false;
        }

        if (book.getPublisher() == null || book.getPublisher().getId() == null || !publisherRepository.existsById(book.getPublisher().getId())) {
            publisherExists = false;
        }

        if (book.getPublicationDate() == null) {
            errorMessage.append("Book publication date cannot be null. ");
        }

        // Construct the error message for author and publisher
        if (!authorExists && !publisherExists) {
            errorMessage.append("Book author and publisher must exist. ");
        } else if (!authorExists) {
            errorMessage.append("Book author must exist. ");
        } else if (!publisherExists) {
            errorMessage.append("Book publisher must exist. ");
        }

        // If there are any validation errors, throw an exception with the combined message
        if (errorMessage.length() > 0) {
            throw new InvalidDataException(errorMessage.toString().trim());
        }
    }
    
    
    
    
    
// Search Books by Title, Author, or Publisher
  public List<Book> searchBooks(String searchTerm) {
     return bookRepository.findAll().stream()
              .filter(book -> book.getTitle().toLowerCase().contains(searchTerm.toLowerCase()) ||
                              book.getAuthor().getName().toLowerCase().contains(searchTerm.toLowerCase()) ||
                              book.getPublisher().getName().toLowerCase().contains(searchTerm.toLowerCase()))
              .collect(Collectors.toList());
  }

  // Sort Books by Title
  public List<Book> sortBooksByTitle() {
      return bookRepository.findAll().stream()
              .sorted(Comparator.comparing(Book::getTitle))
              .collect(Collectors.toList());
  }

//Sort Books by Publication Date
public List<Book> sortBooksByPublicationDate() {
    return bookRepository.findAll().stream()
            .sorted(Comparator.comparing(Book::getPublicationDate))
            .collect(Collectors.toList());
}

//Generate Report: Count of Books by Author
public Map<String, Long> countBooksByAuthor() {
  return bookRepository.findAll().stream()
          .collect(Collectors.groupingBy(book -> book.getAuthor().getName(), Collectors.counting()));
}


}
