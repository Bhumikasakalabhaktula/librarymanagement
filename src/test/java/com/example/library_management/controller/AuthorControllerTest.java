package com.example.library_management.controller;



import com.example.library_management.controller.AuthorController;
import com.example.library_management.entity.Author;
import com.example.library_management.exception.ResourceNotFoundException;
import com.example.library_management.service.AuthorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class AuthorControllerTest {

    @Mock
    private AuthorService authorService;

    @InjectMocks
    private AuthorController authorController;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;
    private Author author;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(authorController).build();
        objectMapper = new ObjectMapper();
        author = new Author(1L, "John Doe", null);
    }

    @Test
    public void createAuthorTest() throws Exception {
        // Arrange: Mock the behavior of the service
        when(authorService.createAuthor(any(Author.class))).thenReturn(author);

        // Act: Perform the POST request
        mockMvc.perform(post("/api/authors")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(author)))
                // Assert: Check the response status and content
                .andExpect(status().isCreated())
                .andExpect(content().string("Author created successfully."));
    }
    @Test
    public void getAllAuthorsTest() throws Exception {
        when(authorService.getAllAuthors()).thenReturn(List.of(author));

        mockMvc.perform(get("/api/authors"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("John Doe"));
    }

    @Test
    public void getAuthorByIdTest() throws Exception {
        when(authorService.getAuthorById(1L)).thenReturn(author);

        mockMvc.perform(get("/api/authors/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John Doe"));
    }

//    @Test
//    public void getAuthorByIdNotFoundTest() throws Exception {
//        // Arrange: Mock the behavior of the service to throw ResourceNotFoundException
//        when(authorService.getAuthorById(1L)).thenThrow(new ResourceNotFoundException("Author not found with id: 1"));
//
//        // Act: Perform the GET request
//        mockMvc.perform(get("/api/authors/{id}", 1L))
//                // Assert: Check the response status and content
//                .andExpect(status().isNotFound())
//                .andExpect(content().string("Author not found with id: 1"));
//    }

    @Test
    public void updateAuthorTest() throws Exception {
        Author updatedAuthor = new Author(1L, "Jane Doe", null);
        when(authorService.updateAuthor(anyLong(), any(Author.class))).thenReturn(updatedAuthor);

        mockMvc.perform(put("/api/authors/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedAuthor)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Jane Doe"));
    }

    @Test
    public void deleteAuthorTest() throws Exception {
        // Arrange: Mock the behavior of the service
        when(authorService.deleteAuthor(1L)).thenReturn("Author deleted successfully.");

        // Act: Perform the DELETE request
        mockMvc.perform(delete("/api/authors/{id}", 1L))
                // Assert: Check the response status and content
                .andExpect(status().isOk())
                .andExpect(content().string("Author deleted successfully."));
    }

//    @Test
//    public void deleteAuthorNotFoundTest() throws Exception {
//        // Arrange: Mock the behavior of the service to throw ResourceNotFoundException
//        doThrow(new ResourceNotFoundException("Author not found with id: 1")).when(authorService).deleteAuthor(anyLong());
//
//        // Act: Perform the DELETE request
//        mockMvc.perform(delete("/api/authors/{id}", 1L))
//                // Assert: Check the response status and content
//                .andExpect(status().isNotFound())
//                .andExpect(content().string("Author not found with id: 1"));
//    }
}

