package com.security.securityProject.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Set;

@Data
@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String email;
    private String password; // Şifrelenmiş parola
    private Set<String> roles; // Örneğin: ROLE_ADMIN, ROLE_USER
}

