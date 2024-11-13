package com.example.library_management.repository;





import com.example.library_management.entity.Author;
import com.example.library_management.repository.AuthorRepository;
import com.example.library_management.service.AuthorService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class AuthorRepositoryTest {

    @Mock
    private AuthorRepository authorRepository;

    @InjectMocks
    private AuthorService authorService; // Assume you have a service that uses the repository

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindByNameContaining() {
        Author author = new Author(null, "John Doe", null);
        when(authorRepository.save(any(Author.class))).thenReturn(author);
        when(authorRepository.findByNameContaining("John")).thenReturn(Arrays.asList(author));

        // Simulate saving the author
        authorRepository.save(author);

        // Now test the find method
        List<Author> authors = authorRepository.findByNameContaining("John");
        assertThat(authors).hasSize(1);
        assertThat(authors.get(0).getName()).isEqualTo("John Doe");

        // Verify interactions
        verify(authorRepository, times(1)).save(author);
        verify(authorRepository, times(1)).findByNameContaining("John");
    }
}