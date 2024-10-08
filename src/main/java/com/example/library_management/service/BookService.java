package com.example.library_management.service;




//import org.springframework.stereotype.Service;
//
//import com.example.library_management.entity.Book;
//import com.example.library_management.repository.BookRepository;
//
//import java.util.List;
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
//    public Book createBook(Book book) {
//        return bookRepository.save(book);
//    }
// 
//    public List<Book> getAllBooks() {
//        return bookRepository.findAll();
//    }
// 
//    public Optional<Book> getBookById(Long id) {
//        return bookRepository.findById(id);
//    }
// 
//    public Book updateBook(Long id, Book updatedBook) {
//        updatedBook.setId(id);
//        return bookRepository.save(updatedBook);
//    }
// 
//    public void deleteBook(Long id) {
//        bookRepository.deleteById(id);
//    }
// 
//    // Search books by title, author name, or publisher name
//    public List<Book> searchBooks(String searchTerm) {
//        return bookRepository.findAll().stream()
//                .filter(book -> book.getTitle().toLowerCase().contains(searchTerm.toLowerCase()) ||
//                        book.getAuthor().getName().toLowerCase().contains(searchTerm.toLowerCase()) ||
//                        book.getPublisher().getName().toLowerCase().contains(searchTerm.toLowerCase()))
//                .collect(Collectors.toList());
//    }
// 
//    // Sort books by title or publication date
//    public List<Book> sortBooksByTitle() {
//        return bookRepository.findAll().stream()
//                .sorted((b1, b2) -> b1.getTitle().compareToIgnoreCase(b2.getTitle()))
//                .collect(Collectors.toList());
//    }
// 
//    public List<Book> sortBooksByPublicationDate() {
//        return bookRepository.findAll().stream()
//                .sorted((b1, b2) -> b1.getPublicationDate().compareTo(b2.getPublicationDate()))
//                .collect(Collectors.toList());
//    }
// 
//    // Additional reporting method can be implemented as needed






//
//import org.springframework.stereotype.Service;
//
//import com.example.library_management.entity.Book;
//import com.example.library_management.repository.BookRepository;
//
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
//    public Book createBook(Book book) {
//       return bookRepository.save(book);
//  }
// 
//    public List<Book> getAllBooks() {
//        return bookRepository.findAll();
//    }
// 
//    public Optional<Book> getBookById(Long id) {
//  return bookRepository.findById(id);
//   }
// 
//    public Book updateBook(Long id, Book updatedBook) {
//        updatedBook.setId(id);
//        return bookRepository.save(updatedBook);
//    }
// 
//    public void deleteBook(Long id) {
//        bookRepository.deleteById(id);
//    }
////      Search books by title, author name, or publisher name
//   public List<Book> searchBooks(String searchTerm) {
//        return bookRepository.findAll().stream()
//                .filter(book -> book.getTitle().toLowerCase().contains(searchTerm.toLowerCase()) ||
//                        book.getAuthor().getName().toLowerCase().contains(searchTerm.toLowerCase()) ||
//                        book.getPublisher().getName().toLowerCase().contains(searchTerm.toLowerCase()))
//                .collect(Collectors.toList());
//    }
// 
////     Sort books by title
//    public List<Book> sortBooksByTitle() {
//        return bookRepository.findAll().stream()
//                .sorted((b1, b2) -> b1.getTitle().compareToIgnoreCase(b2.getTitle()))
//                .collect(Collectors.toList());
//    }
// 
////     Sort books by publication date
//    public List<Book> sortBooksByPublicationDate() {
//        return bookRepository.findAll().stream()
//                .sorted((b1, b2) -> b1.getPublicationDate().compareTo(b2.getPublicationDate()))
//                .collect(Collectors.toList());
//    }
// 
////     Report: Count the number of books each author has written
//    public Map<String, Long> getBooksCountByAuthor() {
//        return bookRepository.findAll().stream()
//                .collect(Collectors.groupingBy(
//                        book -> book.getAuthor().getName(), 
//                        Collectors.counting()
//                ));
//    }
//}
//
//
//
//
//
//
//






import org.springframework.stereotype.Service;

import com.example.library_management.entity.Book;
import com.example.library_management.repository.BookRepository;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
 
@Service
public class BookService {
 
    private final BookRepository bookRepository;
 
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
 
    // Create Book
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }
 
    // Get all Books
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
 
    // Get Book by ID
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }
 
    // Update Book
    public Book updateBook(Long id, Book updatedBook) {
        updatedBook.setId(id);
        return bookRepository.save(updatedBook);
    }
 
    // Delete Book
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
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
 
    // Sort Books by Publication Date
    public List<Book> sortBooksByPublicationDate() {
        return bookRepository.findAll().stream()
                .sorted(Comparator.comparing(Book::getPublicationDate))
                .collect(Collectors.toList());
    }
 
    // Generate Report: Count of Books by Author
    public Map<String, Long> countBooksByAuthor() {
        return bookRepository.findAll().stream()
                .collect(Collectors.groupingBy(book -> book.getAuthor().getName(), Collectors.counting()));
    }
}
