package com.example.library_management.controller;








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
 
    
    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book createdBook = bookService.createBook(book);
        return ResponseEntity.status(201).body(createdBook);
    }
 
    
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }
 
    
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return bookService.getBookById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
 
    
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        return ResponseEntity.ok(bookService.updateBook(id, updatedBook));
    }
 
   
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
 
 
    @GetMapping("/search")
    public ResponseEntity<List<Book>> searchBooks(@RequestParam String searchTerm) {
        List<Book> books = bookService.searchBooks(searchTerm);
        return ResponseEntity.ok(books);
    }
 
    
    @GetMapping("/sort/title")
    public ResponseEntity<List<Book>> sortBooksByTitle() {
        List<Book> books = bookService.sortBooksByTitle();
        return ResponseEntity.ok(books);
    }
 
        @GetMapping("/sort/publication-date")
    public ResponseEntity<List<Book>> sortBooksByPublicationDate() {
        List<Book> books = bookService.sortBooksByPublicationDate();
        return ResponseEntity.ok(books);
    }
 
    
    @GetMapping("/report/author-count")
    public ResponseEntity<Map<String, Long>> countBooksByAuthor() {
        Map<String, Long> report = bookService.countBooksByAuthor();
        return ResponseEntity.ok(report);
    }


}