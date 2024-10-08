package com.example.library_management.controller;




import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.library_management.entity.Publisher;
import com.example.library_management.service.PublisherService;

import java.util.List;
 
@RestController
@RequestMapping("/api/publishers")
public class PublisherController {
 
    private final PublisherService publisherService;
 
    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }
 
    @PostMapping
    public ResponseEntity<Publisher> createPublisher(@RequestBody Publisher publisher) {
        Publisher createdPublisher = publisherService.createPublisher(publisher);
        return ResponseEntity.status(201).body(createdPublisher);
    }
 
    @GetMapping
    public ResponseEntity<List<Publisher>> getAllPublishers() {
        List<Publisher> publishers = publisherService.getAllPublishers();
        return ResponseEntity.ok(publishers);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<Publisher> getPublisherById(@PathVariable Long id) {
        return publisherService.getPublisherById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
 
    @PutMapping("/{id}")
    public ResponseEntity<Publisher> updatePublisher(@PathVariable Long id, @RequestBody Publisher updatedPublisher) {
        return ResponseEntity.ok(publisherService.updatePublisher(id, updatedPublisher));
    }
 
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePublisher(@PathVariable Long id) {
        publisherService.deletePublisher(id);
        return ResponseEntity.noContent().build();
    }
}


