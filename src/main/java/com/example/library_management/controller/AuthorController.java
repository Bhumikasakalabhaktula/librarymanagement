package com.example.library_management.controller;




import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.library_management.entity.Author;
import com.example.library_management.service.AuthorService;

import java.util.List;
 
@RestController
@RequestMapping("/api/authors")
public class AuthorController {
 
    private final AuthorService authorService;
 
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }
 
    @PostMapping
    public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
        Author createdAuthor = authorService.createAuthor(author);
        return ResponseEntity.status(201).body(createdAuthor);
    }
 
    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthors() {
        List<Author> authors = authorService.getAllAuthors();
        return ResponseEntity.ok(authors);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Long id) {
        return authorService.getAuthorById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
 
    @PutMapping("/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable Long id, @RequestBody Author updatedAuthor) {
        return ResponseEntity.ok(authorService.updateAuthor(id, updatedAuthor));
    }
 
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return ResponseEntity.noContent().build();
    }
}