package com.booksStore.bookStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.booksStore.bookStore.models.Book;
import com.booksStore.bookStore.models.Category;
import com.booksStore.bookStore.service.AuthorService;
import com.booksStore.bookStore.service.CategoryService;
import com.booksStore.bookStore.service.PublisherService;

import java.util.*;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;




@Controller
public class CategoryController {
    
    @Autowired
    CategoryService categoryService;

    @Autowired
    PublisherService publisherService;

    @Autowired
    AuthorService authorService;

    @GetMapping("/categories")
    public String findAllCategories(Model model) {
        List<Category> categories=categoryService.findAllCategories();
        model.addAttribute("categories",categories);
        return "categories";    
    }

   
    
    
    @GetMapping("/remove-category/{id}")
    public String removeCategoryById(@PathVariable Long id,Model model)
    {
        categoryService.deleteCategory(id);
        model.addAttribute("categories", categoryService.findAllCategories());
        return "categories";
    }

    @GetMapping("/update-category/{id}")
    public String updateCategoryById(@PathVariable Long id,Model model)
    {
        Category category=categoryService.findCategoryById(id);
        
        model.addAttribute("category",category);
        return "update-category";
        
    }

    @PostMapping("/save-update-category/{id}")
    public String saveUpdateById(@PathVariable Long id,Category category,BindingResult result,Model model) {
        if(result.hasErrors())
        {
            return "update-category"; 
        }
        categoryService.updateCategory(category,id);
        model.addAttribute("categories", categoryService.findAllCategories());
        return "redirect:/categories";
    }
    

    @GetMapping("/add-category")
    public String addCategory(Category category,Model model)
    {
       model.addAttribute("category", category);
        return "add-category";
        
    }


    @PostMapping("/save-add-category")
    public String saveCategory(Category category,BindingResult result,Model model) 
    {
        if(result.hasErrors())
        return "add-category";

        categoryService.saveCategory(category);
        
        model.addAttribute("categories",categoryService.findAllCategories());
        return "redirect:/categories";
    }
    
    
}
