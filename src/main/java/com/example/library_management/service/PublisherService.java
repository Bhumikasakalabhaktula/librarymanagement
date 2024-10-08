package com.example.library_management.service;


import org.springframework.stereotype.Service;

import com.example.library_management.entity.Publisher;
import com.example.library_management.repository.PublisherRepository;

import java.util.List;
import java.util.Optional;
 
@Service
public class PublisherService {
 
    private final PublisherRepository publisherRepository;
 
    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }
 
    public Publisher createPublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }
 
    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }
 
    public Optional<Publisher> getPublisherById(Long id) {
        return publisherRepository.findById(id);
    }
 
    public Publisher updatePublisher(Long id, Publisher updatedPublisher) {
        updatedPublisher.setId(id);
        return publisherRepository.save(updatedPublisher);
    }
 
    public void deletePublisher(Long id) {
        publisherRepository.deleteById(id);
    }
}