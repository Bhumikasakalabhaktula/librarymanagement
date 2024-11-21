package com.example.library_management.exception;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InvalidDataExceptionTest {

    @Test
    public void testInvalidDataExceptionMessage() {
        // Arrange
        String expectedMessage = "Invalid data provided";

        // Act
        InvalidDataException exception = new InvalidDataException(expectedMessage);

        // Assert
        assertThat(exception.getMessage()).isEqualTo(expectedMessage);
    }

    @Test
    public void testInvalidDataExceptionInheritance() {
        // Act
        InvalidDataException exception = new InvalidDataException("Some message");

        // Assert
        assertThat(exception).isInstanceOf(RuntimeException.class);
    }
}