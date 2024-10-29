package com.booksStore.bookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booksStore.bookStore.models.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher,Long>{
    
}
