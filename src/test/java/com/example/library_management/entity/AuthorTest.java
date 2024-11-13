package com.example.library_management.entity;



import com.example.library_management.entity.Author;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuthorTest {

    @Test
    public void authorConstructorTest() {
        Author author = new Author(1L, "John Doe", null);
        assertEquals(1L, author.getId());
        assertEquals("John Doe", author.getName());
    }
}