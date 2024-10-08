package com.example.library_management.entity;



//import jakarta.persistence.*;
//import java.util.List;
// 
//@Entity
//public class Publisher {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
// 
//    @Column(nullable = false)
//    private String name;
// 
//    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
//    private List<Book> books;  // List for ordered collection
// 
//    // Getters and setters
//    public Long getId() {
//        return id;
//    }
// 
//    public void setId(Long id) {
//        this.id = id;
//    }
// 
//    public String getName() {
//        return name;
//    }
// 
//    public void setName(String name) {
//        this.name = name;
//    }
// 
//    public List<Book> getBooks() {
//        return books;
//    }
// 
//    public void setBooks(List<Book> books) {
//        this.books = books;
//    }
//}
//



import java.util.HashSet;
import java.util.Set;
 
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 
@Entity
@Table(name = "publishers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
 
    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Book> books = new HashSet<>();
}