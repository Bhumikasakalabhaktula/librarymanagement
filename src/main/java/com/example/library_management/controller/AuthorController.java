//package com.example.library_management.controller;
//
//
//
//
////import org.springframework.http.ResponseEntity;
////import org.springframework.web.bind.annotation.*;
////
////import com.example.library_management.entity.Author;
////import com.example.library_management.service.AuthorService;
////
////import java.util.List;
//// 
////@RestController
////@RequestMapping("/api/authors")
////public class AuthorController {
//// 
////    private final AuthorService authorService;
//// 
////    public AuthorController(AuthorService authorService) {
////        this.authorService = authorService;
////    }
//// 
////    @PostMapping
////    public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
////        Author createdAuthor = authorService.createAuthor(author);
////        return ResponseEntity.status(201).body(createdAuthor);
////    }
//// 
////    @GetMapping
////    public ResponseEntity<List<Author>> getAllAuthors() {
////        List<Author> authors = authorService.getAllAuthors();
////        return ResponseEntity.ok(authors);
////    }
//// 
////    @GetMapping("/{id}")
////    public ResponseEntity<Author> getAuthorById(@PathVariable Long id) {
////        return authorService.getAuthorById(id)
////                .map(ResponseEntity::ok)
////                .orElse(ResponseEntity.notFound().build());
////    }
//// 
////    @PutMapping("/{id}")
////    public ResponseEntity<Author> updateAuthor(@PathVariable Long id, @RequestBody Author updatedAuthor) {
////        return ResponseEntity.ok(authorService.updateAuthor(id, updatedAuthor));
////    }
//// 
////    @DeleteMapping("/{id}")
////    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
////        authorService.deleteAuthor(id);
////        return ResponseEntity.noContent().build();
////    }
////}
//
//
//
//
//
//
//











package com.example.library_management.controller;

import com.example.library_management.entity.Author;
import com.example.library_management.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public ResponseEntity<String> createAuthor(@RequestBody Author author) {
        authorService.createAuthor(author);
        return ResponseEntity.status(201).body("Author created successfully.");
    }

    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthors() {
        List<Author> authors = authorService.getAllAuthors();
        return ResponseEntity.ok(authors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Long id) {
        Author author = authorService.getAuthorById(id);
        return ResponseEntity.ok(author);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable Long id, @RequestBody Author updatedAuthor) {
        Author author = authorService.updateAuthor(id, updatedAuthor);
        return ResponseEntity.ok(author);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAuthor(@PathVariable Long id) {
        String message = authorService.deleteAuthor(id);
        return ResponseEntity.ok(message);
    }
}