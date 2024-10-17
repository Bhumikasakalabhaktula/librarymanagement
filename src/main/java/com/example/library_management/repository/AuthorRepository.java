package com.example.library_management.repository;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.library_management.entity.Author;
 
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
	List<Author> findByNameContaining(String name);
    
}