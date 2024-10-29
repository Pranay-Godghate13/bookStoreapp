package com.booksStore.bookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booksStore.bookStore.models.Book;

public interface BookRepository extends JpaRepository<Book,Long> {


    
}
