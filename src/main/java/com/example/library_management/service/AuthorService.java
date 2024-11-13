//package com.example.library_management.service;
//
//
//import org.springframework.stereotype.Service;
//
//import com.example.library_management.entity.Author;
//import com.example.library_management.repository.AuthorRepository;
//
//import java.util.List;
//import java.util.Optional;
// 
//@Service
//public class AuthorService {
// 
//    private final AuthorRepository authorRepository;
// 
//    public AuthorService(AuthorRepository authorRepository) {
//        this.authorRepository = authorRepository;
//    }
// 
//    public Author createAuthor(Author author) {
//        return authorRepository.save(author);
//    }
// 
//    public List<Author> getAllAuthors() {
//        return authorRepository.findAll();
//
//    }
// 
//    public Optional<Author> getAuthorById(Long id) {
//        return authorRepository.findById(id);
//    }
// 
//    public Author updateAuthor(Long id, Author updatedAuthor) {
//        updatedAuthor.setId(id);
//        return authorRepository.save(updatedAuthor);
//    }
// 
//    public void deleteAuthor(Long id) {
//        authorRepository.deleteById(id);
//    }
//}
//
//
//



 package com.example.library_management.service;

import com.example.library_management.entity.Author;
import com.example.library_management.exception.ResourceNotFoundException;
import com.example.library_management.exception.InvalidDataException;
import com.example.library_management.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author createAuthor(Author author) {
        if (author.getName() == null || author.getName().isEmpty()) {
            throw new InvalidDataException("Author name cannot be null or empty.");
        }
        return authorRepository.save(author);
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author getAuthorById(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id: " + id));
    }

    public Author updateAuthor(Long id, Author updatedAuthor) {
        if (updatedAuthor.getName() == null || updatedAuthor.getName().isEmpty()) {
            throw new InvalidDataException("Author name cannot be null or empty.");
        }
        updatedAuthor.setId(id);
        return authorRepository.save(updatedAuthor);
    }

    public String deleteAuthor(Long id) {
        if (!authorRepository.existsById(id)) {
            throw new ResourceNotFoundException("Author not found with id: " + id);
        }
        authorRepository.deleteById(id);
        return "Author deleted successfully.";
    }
}