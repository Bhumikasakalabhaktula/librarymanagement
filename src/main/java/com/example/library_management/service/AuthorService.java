package com.example.library_management.service;


import org.springframework.stereotype.Service;

import com.example.library_management.entity.Author;
import com.example.library_management.repository.AuthorRepository;

import java.util.List;
import java.util.Optional;
 
@Service
public class AuthorService {
 
    private final AuthorRepository authorRepository;
 
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
 
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }
 
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }
 
    public Optional<Author> getAuthorById(Long id) {
        return authorRepository.findById(id);
    }
 
    public Author updateAuthor(Long id, Author updatedAuthor) {
        updatedAuthor.setId(id);
        return authorRepository.save(updatedAuthor);
    }
 
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}



