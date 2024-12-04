package com.example.demo.model;

import com.example.demo.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Code{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer code;
    private Integer nextCode;


    // Getters and Setters
}

