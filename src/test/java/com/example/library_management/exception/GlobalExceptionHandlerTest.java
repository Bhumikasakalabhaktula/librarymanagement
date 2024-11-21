package com.example.library_management.exception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class GlobalExceptionHandlerTest {

    private GlobalExceptionHandler globalExceptionHandler;

    @BeforeEach
    public void setUp() {
        globalExceptionHandler = new GlobalExceptionHandler();
    }

    @Test
    public void testHandleResourceNotFound() {
        // Arrange
        ResourceNotFoundException exception = new ResourceNotFoundException("Resource not found");

        // Act
        ResponseEntity<String> response = globalExceptionHandler.handleResourceNotFound(exception);

        // Assert
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        assertThat(response.getBody()).isEqualTo("Resource not found");
    }

    @Test
    public void testHandleInvalidData() {
        // Arrange
        InvalidDataException exception = new InvalidDataException("Invalid data provided");

        // Act
        ResponseEntity<String> response = globalExceptionHandler.handleInvalidData(exception);

        // Assert
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        assertThat(response.getBody()).isEqualTo("Invalid data provided");
    }

    @Test
    public void testHandleGenericException() {
        // Arrange
        Exception exception = new Exception("An unexpected error");

        // Act
        ResponseEntity<String> response = globalExceptionHandler.handleGenericException(exception);

        // Assert
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
        assertThat(response.getBody()).contains("An unexpected error occurred: An unexpected error");
    }
}