package com.example.demo.model;
import com.example.demo.base.BaseEntity;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Customer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Book> books;

    // Getters and Setters
}
