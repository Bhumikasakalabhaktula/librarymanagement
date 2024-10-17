package com.example.library_management.repository;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.library_management.entity.Publisher;
 
@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {
	List<Publisher> findByNameContaining(String name);
}