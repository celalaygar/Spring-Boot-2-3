package com.security.securityProject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data // Getter, Setter, toString, equals, hashCode
@NoArgsConstructor // No-arg constructor
@AllArgsConstructor // All-arg constructor
@Document(collection = "sec_roles") // MongoDB koleksiyon adı
public class Role {
    @Id
    private String id;
    private String name; // Örn: USER, MODERATOR, ADMIN
}