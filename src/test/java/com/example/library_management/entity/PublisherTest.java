package com.example.library_management.entity;



import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PublisherTest {

    @Test
    public void testPublisherCreation() {
        Publisher publisher = new Publisher(1L, "Test Publisher", null);
        assertEquals(1L, publisher.getId());
        assertEquals("Test Publisher", publisher.getName());
    }
}