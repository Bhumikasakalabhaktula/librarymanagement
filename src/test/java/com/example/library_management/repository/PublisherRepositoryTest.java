package com.example.library_management.repository;





import com.example.library_management.entity.Publisher;
import com.example.library_management.service.PublisherService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class PublisherRepositoryTest {

    @Mock
    private PublisherRepository publisherRepository;

    @InjectMocks
    private PublisherService publisherService; // Assume you have a service that uses the repository

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindByNameContaining() {
        // Arrange
        Publisher publisher = new Publisher(null, "Test Publisher", null);
        when(publisherRepository.save(any(Publisher.class))).thenReturn(publisher);
        when(publisherRepository.findByNameContaining("Test")).thenReturn(Arrays.asList(publisher));

        // Simulate saving the publisher
        publisherRepository.save(publisher);

        // Now test the find method
        List<Publisher> publishers = publisherRepository.findByNameContaining("Test");
        assertThat(publishers).hasSize(1);
        assertThat(publishers.get(0).getName()).isEqualTo("Test Publisher");

        // Verify interactions
        verify(publisherRepository, times(1)).save(publisher);
        verify(publisherRepository, times(1)).findByNameContaining("Test");
    }
}