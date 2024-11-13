package com.example.library_management.service;
//
//
//import org.springframework.stereotype.Service;
//
//import com.example.library_management.entity.Publisher;
//import com.example.library_management.repository.PublisherRepository;
//
//import java.util.List;
//import java.util.Optional;
// 
//@Service
//public class PublisherService {
// 
//    private final PublisherRepository publisherRepository;
// 
//    public PublisherService(PublisherRepository publisherRepository) {
//        this.publisherRepository = publisherRepository;
//    }
// 
//    public Publisher createPublisher(Publisher publisher) {
//        return publisherRepository.save(publisher);
//    }
// 
//    public List<Publisher> getAllPublishers() {
//        return publisherRepository.findAll();
//    }
// 
//    public Optional<Publisher> getPublisherById(Long id) {
//        return publisherRepository.findById(id);
//    }
// 
//    public Publisher updatePublisher(Long id, Publisher updatedPublisher) {
//        updatedPublisher.setId(id);
//        return publisherRepository.save(updatedPublisher);
//    }
// 
//    public void deletePublisher(Long id) {
//        publisherRepository.deleteById(id);
//    }
//}







import com.example.library_management.entity.Publisher;
import com.example.library_management.exception.ResourceNotFoundException;
import com.example.library_management.exception.InvalidDataException;
import com.example.library_management.repository.PublisherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {

    private final PublisherRepository publisherRepository;

    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public Publisher createPublisher(Publisher publisher) {
        if (publisher.getName() == null || publisher.getName().isEmpty()) {
            throw new InvalidDataException("Publisher name cannot be null or empty.");
        }
        return publisherRepository.save(publisher);
    }

    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    public Publisher getPublisherById(Long id) {
        return publisherRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Publisher not found with id: " + id));
    }

    public Publisher updatePublisher(Long id, Publisher updatedPublisher) {
        if (updatedPublisher.getName() == null || updatedPublisher.getName().isEmpty()) {
            throw new InvalidDataException("Publisher name cannot be null or empty.");
        }
        updatedPublisher.setId(id);
        return publisherRepository.save(updatedPublisher);
    }

    public String deletePublisher(Long id) {
        if (!publisherRepository.existsById(id)) {
            throw new ResourceNotFoundException("Publisher not found with id: " + id);
        }
        publisherRepository.deleteById(id);
        return "Publisher deleted successfully.";
    }
}

