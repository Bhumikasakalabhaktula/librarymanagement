package com.example.library_management.service;



//import com.example.library_management.entity.Publisher;
//import com.example.library_management.exception.ResourceNotFoundException;
//import com.example.library_management.repository.PublisherRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.util.Collections;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.anyLong;
//import static org.mockito.Mockito.*;
//
//public class PublisherServiceTest {
//
//    @Mock
//    private PublisherRepository publisherRepository;
//
//    @InjectMocks
//    private PublisherService publisherService;
//
//    private Publisher publisher;
//
//    @BeforeEach
//    public void setup() {
//        MockitoAnnotations.openMocks(this);
//        publisher = new Publisher(1L, "Test Publisher", null);
//    }
//
//    @Test
//    public void createPublisherTest() {
//        // Arrange
//        when(publisherRepository.save(any(Publisher.class))).thenReturn(publisher);
//
//        // Act
//        Publisher createdPublisher = publisherService.createPublisher(publisher);
//
//        // Assert
//        assertEquals("Test Publisher", createdPublisher.getName());
//    }
//
//    @Test
//    public void getAllPublishersTest() {
//        // Arrange
//        when(publisherRepository.findAll()).thenReturn(Collections.singletonList(publisher));
//
//        // Act
//        List<Publisher> publishers = publisherService.getAllPublishers();
//
//        // Assert
//        assertEquals(1, publishers.size());
//        assertEquals("Test Publisher", publishers.get(0).getName());
//    }
//
//    @Test
//    public void getPublisherByIdTest() {
//        // Arrange
//        when(publisherRepository.findById(1L)).thenReturn(Optional.of(publisher));
//
//         Act
//        Publisher foundPublisher = publisherService.getPublisherById(1L);
//
//        // Assert
//        assertEquals("Test Publisher", foundPublisher.getName());
//    }
//}



import com.example.library_management.entity.Publisher;
import com.example.library_management.exception.InvalidDataException;
import com.example.library_management.exception.ResourceNotFoundException;
import com.example.library_management.repository.PublisherRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy; // Ensure this import is present
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class PublisherServiceTest {

    @Mock
    private PublisherRepository publisherRepository;

    @InjectMocks
    private PublisherService publisherService;

    private Publisher publisher;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        publisher = new Publisher(1L, "Test Publisher", null);
    }

    @Test
    public void createPublisherTest() {
        // Arrange
        when(publisherRepository.save(any(Publisher.class))).thenReturn(publisher);

        // Act
        Publisher createdPublisher = publisherService.createPublisher(publisher);

        // Assert
        assertThat(createdPublisher.getName()).isEqualTo("Test Publisher");
        verify(publisherRepository, times(1)).save(publisher);
    }

    @Test
    public void createPublisherInvalidDataTest() {
        // Arrange
        Publisher invalidPublisher = new Publisher(null, "", null);

        // Act & Assert
        assertThatThrownBy(() -> publisherService.createPublisher(invalidPublisher))
                .isInstanceOf(InvalidDataException.class)
                .hasMessage("Publisher name cannot be null or empty.");
    }

    @Test
    public void getAllPublishersTest() {
        // Arrange
        when(publisherRepository.findAll()).thenReturn(List.of(publisher));

        // Act
        List<Publisher> publishers = publisherService.getAllPublishers();

        // Assert
        assertThat(publishers).hasSize(1);
        assertThat(publishers.get(0).getName()).isEqualTo("Test Publisher");
    }

    @Test
    public void getPublisherByIdTest() {
        // Arrange
        when(publisherRepository.findById(anyLong())).thenReturn(Optional.of(publisher));

        // Act
        Publisher foundPublisher = publisherService.getPublisherById(1L);

        // Assert
        assertThat(foundPublisher.getName()).isEqualTo("Test Publisher");
    }

    @Test
    public void getPublisherByIdNotFoundTest() {
        // Arrange
        when(publisherRepository.findById(anyLong())).thenReturn(Optional.empty());

        // Act & Assert
        assertThatThrownBy(() -> publisherService.getPublisherById(1L))
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage("Publisher not found with id: 1");
    }

    @Test
    public void updatePublisherTest() {
        // Arrange
        when(publisherRepository.findById(anyLong())).thenReturn(Optional.of(publisher));
        when(publisherRepository.save(any(Publisher.class))).thenReturn(publisher);

        // Act
        Publisher updatedPublisher = publisherService.updatePublisher(1L, publisher);

        // Assert
        assertThat(updatedPublisher.getName()).isEqualTo("Test Publisher");
        verify(publisherRepository, times(1)).save(publisher);
    }

    @Test
    public void updatePublisherInvalidDataTest() {
        // Arrange
        Publisher invalidPublisher = new Publisher(null, "", null);

        // Act & Assert
        assertThatThrownBy(() -> publisherService.updatePublisher(1L, invalidPublisher))
                .isInstanceOf(InvalidDataException.class)
                .hasMessage("Publisher name cannot be null or empty.");
    }

    @Test
    public void deletePublisherTest() {
        // Arrange
        when(publisherRepository.existsById(anyLong())).thenReturn(true);

        // Act
        String message = publisherService.deletePublisher(1L);

        // Assert
        assertThat(message).isEqualTo("Publisher deleted successfully.");
        verify(publisherRepository, times(1)).deleteById(1L);
    }

    @Test
    public void deletePublisherNotFoundTest() {
        // Arrange
        when(publisherRepository.existsById (anyLong())).thenReturn(false);

        // Act & Assert
        assertThatThrownBy(() -> publisherService.deletePublisher(1L))
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage("Publisher not found with id: 1");
    }
}