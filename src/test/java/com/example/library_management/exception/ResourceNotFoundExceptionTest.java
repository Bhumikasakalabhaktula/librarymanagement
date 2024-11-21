package com.example.library_management.exception;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResourceNotFoundExceptionTest {

    @Test
    public void testResourceNotFoundExceptionMessage() {
        // Arrange
        String expectedMessage = "Resource not found";

        // Act
        ResourceNotFoundException exception = new ResourceNotFoundException(expectedMessage);

        // Assert
        assertThat(exception.getMessage()).isEqualTo(expectedMessage);
    }

    @Test
    public void testResourceNotFoundExceptionInheritance() {
        // Act
        ResourceNotFoundException exception = new ResourceNotFoundException("Some message");

        // Assert
        assertThat(exception).isInstanceOf(RuntimeException.class);
    }
}