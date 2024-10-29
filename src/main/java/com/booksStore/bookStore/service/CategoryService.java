package com.booksStore.bookStore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

import com.booksStore.bookStore.models.Book;
import com.booksStore.bookStore.models.Category;
import com.booksStore.bookStore.repository.CategoryRepository;

@Service
public class CategoryService{
    
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAllCategories()
    {
        return categoryRepository.findAll();
    }

    public Category findCategoryById(Long id)
    {
        Category category=categoryRepository.findById(id).orElseThrow(()->new RuntimeException("Category does not exist"));
        return category;
    }

    public void saveCategory(Category category)
    {
        categoryRepository.save(category);
    }

    public void deleteCategory(Long id)
    {
        Category category=categoryRepository.findById(id).orElseThrow(()->new RuntimeException("Category does not exist"));
        categoryRepository.deleteById(category.getCategoryId());

    }

    public void updateCategory(Category category,Long id)
    {
        Category savedCategory=categoryRepository.findById(id).orElseThrow(()->new RuntimeException("Category not present in store"));
        //savedCategory.setCategoryId(category.getCategoryId());
        savedCategory.setCategoryName(category.getCategoryName());
        savedCategory.setBooks(category.getBooks());

        categoryRepository.save(savedCategory);
    }
}
