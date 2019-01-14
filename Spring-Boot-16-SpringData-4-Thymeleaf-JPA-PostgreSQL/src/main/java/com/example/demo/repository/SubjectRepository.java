package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Student;
import com.example.demo.entity.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {


}
