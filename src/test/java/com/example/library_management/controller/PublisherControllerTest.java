package com.example.library_management.controller;




import com.example.library_management.entity.Publisher;
import com.example.library_management.service.PublisherService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class PublisherControllerTest {

    @Mock
    private PublisherService publisherService;

    @InjectMocks
    private PublisherController publisherController;

    private Publisher publisher;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        publisher = new Publisher(1L, "Test Publisher", null);
    }

    @Test
    public void createPublisherTest() {
        // Arrange
        when(publisherService.createPublisher(any(Publisher.class))).thenReturn(publisher);

        // Act
        ResponseEntity<String> response = publisherController.createPublisher(publisher);

        // Assert
        assertThat(response.getStatusCodeValue()).isEqualTo(201);
        assertThat(response.getBody()).isEqualTo("Publisher created successfully.");
        verify(publisherService, times(1)).createPublisher(publisher);
    }

    @Test
    public void getAllPublishersTest() {
        // Arrange
        when(publisherService.getAllPublishers()).thenReturn(List.of(publisher));

        // Act
        ResponseEntity<List<Publisher>> response = publisherController.getAllPublishers();

        // Assert
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).hasSize(1);
        assertThat(response.getBody().get(0).getName()).isEqualTo("Test Publisher");
        verify(publisherService, times(1)).getAllPublishers();
    }

    @Test
    public void getPublisherByIdTest() {
        // Arrange
        when(publisherService.getPublisherById(anyLong())).thenReturn(publisher);

        // Act
        ResponseEntity<Publisher> response = publisherController.getPublisherById(1L);

        // Assert
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody().getName()).isEqualTo("Test Publisher");
        verify(publisherService, times(1)).getPublisherById(1L);
    }

    @Test
    public void updatePublisherTest() {
        // Arrange
        when(publisherService.updatePublisher(anyLong(), any(Publisher.class))).thenReturn(publisher);

        // Act
        ResponseEntity<Publisher> response = publisherController.updatePublisher(1L, publisher);

        // Assert
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody().getName()).isEqualTo("Test Publisher");
        verify(publisherService, times(1)).updatePublisher(1L, publisher);
    }

    @Test
    public void deletePublisherTest() {
        // Arrange
        when(publisherService.deletePublisher(anyLong())).thenReturn("Publisher deleted successfully.");

        // Act
        ResponseEntity<String> response = publisherController.deletePublisher(1L);

        // Assert
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).isEqualTo("Publisher deleted successfully.");
        verify(publisherService, times(1)).deletePublisher(1L);
    }
}