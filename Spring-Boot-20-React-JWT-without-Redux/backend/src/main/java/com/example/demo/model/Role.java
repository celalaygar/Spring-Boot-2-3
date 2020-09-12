package com.example.demo.model;

import javax.persistence.*;

import org.hibernate.annotations.NaturalId;

import lombok.Data;

@Entity
@Table(name = "roles")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = 60)
    private RoleName name;
    
    private Long user_id;

    public Role() {

    }

}
