package com.booksStore.bookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booksStore.bookStore.models.Author;

public interface AuthorRepository extends JpaRepository<Author,Long> {
    
}
