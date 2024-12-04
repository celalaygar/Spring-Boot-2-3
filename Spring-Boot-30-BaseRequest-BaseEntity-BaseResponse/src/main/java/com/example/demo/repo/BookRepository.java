package com.example.demo.repo;

import com.example.demo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE Book b SET b.title = :title WHERE b.id = :id")
    void updateBookTitle(Long id, String title);
}

