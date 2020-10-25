package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
@Table(name="users")
public class User implements Serializable {

    @Id
    @SequenceGenerator(name = "sq_users", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_users")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;
    
	@Column(name = "bornDate")
	private Date bornDate;
	
	@Column(name = "createdDate")
	private Date createdDate;
    
    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;
    
    @Column(name="realPassword")
    private String realPassword;

    @Enumerated(EnumType.STRING)
    @Column(name="role")
    private Role role;

    @Transient
    private String token;
}
