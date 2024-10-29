package com.booksStore.bookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booksStore.bookStore.models.Category;

public interface CategoryRepository extends JpaRepository<Category,Long>{
    
}
