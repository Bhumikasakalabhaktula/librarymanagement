package com.example.library_management.service;



import com.example.library_management.entity.Author;
import com.example.library_management.exception.InvalidDataException;
import com.example.library_management.exception.ResourceNotFoundException;
import com.example.library_management.repository.AuthorRepository;
import com.example.library_management.service.AuthorService;

import jakarta.persistence.EntityNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class AuthorServiceTest {

    @Mock
    private AuthorRepository authorRepository;

    @InjectMocks
    private AuthorService authorService;

    private Author author;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        author = new Author(1L, "John Doe", null);
    }

    @Test
    public void createAuthorTest() {
        when(authorRepository.save(any(Author.class))).thenReturn(author);

        Author createdAuthor = authorService.createAuthor(author);
        assertNotNull(createdAuthor);
        assertEquals("John Doe", createdAuthor.getName());
    }

    @Test
    public void createAuthorWithEmptyNameTest() {
     Author invalidAuthor = new Author(null, "", null);

       Exception exception = assertThrows(InvalidDataException.class, () -> {
            authorService.createAuthor(invalidAuthor);
        });

        assertEquals("Author name cannot be null or empty.", exception.getMessage());
    }

    @Test
    public void getAllAuthorsTest() {
       when(authorRepository.findAll()).thenReturn(List.of(author));

        List<Author> authors = authorService.getAllAuthors();
       assertNotNull(authors);
       assertEquals(1, authors.size());
        assertEquals("John Doe", authors.get(0).getName());
    }

    @Test
    public void getAuthorByIdTest() {
        when(authorRepository.findById(1L)).thenReturn(Optional.of(author));

        Author foundAuthor = authorService.getAuthorById(1L);
        assertNotNull(foundAuthor);
        assertEquals("John Doe", foundAuthor.getName());
   }

    @Test
    public void getAuthorByIdNotFoundTest() {
        when(authorRepository.findById(1L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            authorService.getAuthorById(1L);
        });

       assertEquals("Author not found with id: 1", exception.getMessage());
    }

//   @Test
//   public Author updateAuthor(Long id, Author updatedAuthor) {
//       Author existingAuthor = authorRepository.findById(id)
//              .orElseThrow(() -> new EntityNotFoundException("Author not found"));
//
//       existingAuthor.setName(updatedAuthor.getName());
//       // Update other fields as necessary
//
//       return authorRepository.save(existingAuthor);
//   }

    @Test
    public void updateAuthorWithEmptyNameTest() {
        Author invalidAuthor = new Author(null, "", null);

        Exception exception = assertThrows(InvalidDataException.class, () -> {
            authorService.updateAuthor(1L, invalidAuthor);
        });

        assertEquals("Author name cannot be null or empty.", exception.getMessage());
    }

    @Test
    public void deleteAuthorTest() {
        when(authorRepository.existsById(1L)).thenReturn(true);
        doNothing().when(authorRepository).deleteById(1L);

        String message = authorService.deleteAuthor(1L);
        assertEquals("Author deleted successfully.", message);
    }

    @Test
    public void deleteAuthorNotFoundTest() {
        when(authorRepository.existsById(1L)).thenReturn(false);

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            authorService.deleteAuthor(1L);
       });

       assertEquals("Author not found with id: 1", exception.getMessage());
    }
    @Test
    public void testUpdateAuthor_Success() {
        // Arrange
        Author updatedAuthor = new Author();
        updatedAuthor.setName("Updated Author");

        // Mock the behavior of the repository
        when(authorRepository.findById(1L)).thenReturn(Optional.of(author));
        when(authorRepository.save(any(Author.class))).thenReturn(author);

        // Act
        Author result = authorService.updateAuthor(1L, updatedAuthor);

        // Assert
//        assertEquals("Updated Author", result.getName());
//        assertEquals(1L, result.getId());
//        verify(authorRepository).save(any(Author.class));
    }

    @Test
    public void testUpdateAuthor_InvalidName_Null() {
        // Arrange
        Author updatedAuthor = new Author();
        updatedAuthor.setName(null); // Invalid name

        // Act & Assert
        InvalidDataException exception = assertThrows(InvalidDataException.class, () -> {
            authorService.updateAuthor(1L, updatedAuthor);
        });

        assertEquals("Author name cannot be null or empty.", exception.getMessage());
    }

    @Test
    public void testUpdateAuthor_InvalidName_Empty() {
        // Arrange
        Author updatedAuthor = new Author();
        updatedAuthor.setName(""); // Invalid name

        // Act & Assert
        InvalidDataException exception = assertThrows(InvalidDataException.class, () -> {
            authorService.updateAuthor(1L, updatedAuthor);
        });

        assertEquals("Author name cannot be null or empty.", exception.getMessage());
    }
}






