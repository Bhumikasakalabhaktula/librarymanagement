package com.example.library_management.controller;




//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import com.example.library_management.entity.Book;
//import com.example.library_management.service.BookService;
//
//import java.util.List;
// 
//@RestController
//@RequestMapping("/api/books")
//public class BookController {
// 
//    private final BookService bookService;
// 
//    public BookController(BookService bookService) {
//        this.bookService = bookService;
//    }
// 
//    @PostMapping
//    public ResponseEntity<Book> createBook(@RequestBody Book book) {
//        Book createdBook = bookService.createBook(book);
//        return ResponseEntity.status(201).body(createdBook);
//    }
// 
//    @GetMapping
//    public ResponseEntity<List<Book>> getAllBooks() {
//        List<Book> books = bookService.getAllBooks();
//        return ResponseEntity.ok(books);
//    }
// 
//    @GetMapping("/{id}")
//    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
//        return bookService.getBookById(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
// 
//    @PutMapping("/{id}")
//    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
//        return ResponseEntity.ok(bookService.updateBook(id, updatedBook));
//    }
// 
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
//        bookService.deleteBook(id);
//        return ResponseEntity.noContent().build();
//    }
//}



















//import org.springframework.http.ResponseEntity;
//
//import org.springframework.web.bind.annotation.*;
//
//import com.example.library_management.entity.Book;
//import com.example.library_management.service.BookService;
//
//import java.util.List;
//
//import java.util.Map;
//
//@RestController
//
//@RequestMapping("/api/books")
//
//public class BookController {
// 
//    private final BookService bookService;
// 
//    public BookController(BookService bookService) {
//
//       this.bookService = bookService;
//
//    }
// 
//    @PostMapping
//
//    public ResponseEntity<Book> createBook(@RequestBody Book book) {
//
//        Book createdBook = bookService.createBook(book);
//
//        return ResponseEntity.status(201).body(createdBook);
//
//    }
// 
//    @GetMapping
//
//    public ResponseEntity<List<Book>> getAllBooks() {
//
//        List<Book> books = bookService.getAllBooks();
//
//        return ResponseEntity.ok(books);
//
//   }
// 
//    @GetMapping("/{id}")
//
//    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
//
//        return bookService.getBookById(id)
//
//               .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//
//    }
// 
//   @PutMapping("/{id}")
//
//    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
//
//        return ResponseEntity.ok(bookService.updateBook(id, updatedBook));
//
//    }
// 
//    @DeleteMapping("/{id}")
//
//    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
//
//        bookService.deleteBook(id);
//
//        return ResponseEntity.noContent().build();
//
//   }
// 
//    // Search books by title, author name, or publisher name
//
//   @GetMapping("/search")
//
//    public ResponseEntity<List<Book>> searchBooks(@RequestParam String searchTerm) {
//
//        List<Book> books = bookService.searchBooks(searchTerm);
//
//       return ResponseEntity.ok(books);
//
//    }
// 
//    // Sort books by title
//
//    @GetMapping("/sort/title")
//
//    public ResponseEntity<List<Book>> sortBooksByTitle() {
//
//        List<Book> sortedBooks = bookService.sortBooksByTitle();
//
//       return ResponseEntity.ok(sortedBooks);
//
//    }
//
//   // Sort books by publication date
//
//    @GetMapping("/sort/publication-date")
//
//    public ResponseEntity<List<Book>> sortBooksByPublicationDate() {
//
//        List<Book> sortedBooks = bookService.sortBooksByPublicationDate();
//
//        return ResponseEntity.ok(sortedBooks);
//
//    }
// 
//    // Generate report: Count the number of books each author has written
//
//    @GetMapping("/report/books-count-by-author")
//
//   public ResponseEntity<Map<String, Long>> getBooksCountByAuthor() {
//
//        Map<String, Long> report = bookService.getBooksCountByAuthor();
//
//        return ResponseEntity.ok(report);
//
//    }
//
//}
//
//
//
//
//
//
//
//




import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.library_management.entity.Book;
import com.example.library_management.service.BookService;

import java.util.List;
import java.util.Map;
 
@RestController
@RequestMapping("/api/books")
public class BookController {
 
    private final BookService bookService;
 
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
 
    // Create Book
    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book createdBook = bookService.createBook(book);
        return ResponseEntity.status(201).body(createdBook);
    }
 
    // Get all Books
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }
 
    // Get Book by ID
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return bookService.getBookById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
 
    // Update Book
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        return ResponseEntity.ok(bookService.updateBook(id, updatedBook));
    }
 
    // Delete Book
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
 
 // Search Books
    @GetMapping("/search")
    public ResponseEntity<List<Book>> searchBooks(@RequestParam String searchTerm) {
        List<Book> books = bookService.searchBooks(searchTerm);
        return ResponseEntity.ok(books);
    }
 
    // Sort Books by Title
    @GetMapping("/sort/title")
    public ResponseEntity<List<Book>> sortBooksByTitle() {
        List<Book> books = bookService.sortBooksByTitle();
        return ResponseEntity.ok(books);
    }
 
    // Sort Books by Publication Date
    @GetMapping("/sort/publication-date")
    public ResponseEntity<List<Book>> sortBooksByPublicationDate() {
        List<Book> books = bookService.sortBooksByPublicationDate();
        return ResponseEntity.ok(books);
    }
 
    // Generate Report: Count of Books by Author
    @GetMapping("/report/author-count")
    public ResponseEntity<Map<String, Long>> countBooksByAuthor() {
        Map<String, Long> report = bookService.countBooksByAuthor();
        return ResponseEntity.ok(report);
    }


}