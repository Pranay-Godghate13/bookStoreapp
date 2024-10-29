package com.booksStore.bookStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import com.booksStore.bookStore.models.Author;
import com.booksStore.bookStore.service.AuthorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class AuthorController {
    
    @Autowired
    AuthorService authorService;

    @GetMapping("/authors")
    public String findAllAuthors(Model model) {
        List<Author> authors=authorService.findAllAuthors();
        model.addAttribute("authors", authors);
        return "authors";
    }

    @GetMapping("/remove-author/{id}")
    public String removeAuthorById(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return "redirect:/authors";
    }
    

    @GetMapping("/update-author/{id}")
    public String updateAuthorById(@PathVariable Long id,Model model) {
        Author author=authorService.findAuthorById(id);
        model.addAttribute("author",author);
        return "update-author";
    }
    
    @PostMapping("/save-update-author/{id}")
    public String saveUpdateAuthorById(@PathVariable Long id,Author author,BindingResult result,Model model) {
        if(result.hasErrors())
        return "update-author";
        authorService.updateAuthor(id, author);
        return "redirect:/authors";

    }
    
    @GetMapping("/add-author")
    public String addAuthor(Author author) {
       return "add-author";
    }

    @PostMapping("/save-add-author")
    public String saveAddAuthor(@Validated Author author,BindingResult result,Model model) {
        if(result.hasErrors())
        return "add-author";
        authorService.saveAuthor(author);
        return "redirect:/authors";
    }
    
    
    
}
