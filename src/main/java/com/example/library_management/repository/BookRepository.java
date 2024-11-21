package com.example.library_management.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library_management.entity.Book;

import java.util.List;
 
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitleContaining(String title);
    List<Book> findByAuthorName(String authorName);
    List<Book> findByPublisherName(String publisherName);
	
}