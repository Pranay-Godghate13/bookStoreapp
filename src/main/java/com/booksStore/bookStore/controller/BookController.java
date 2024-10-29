package com.booksStore.bookStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.booksStore.bookStore.models.Book;
import com.booksStore.bookStore.service.AuthorService;
import com.booksStore.bookStore.service.BookService;
import com.booksStore.bookStore.service.CategoryService;
import com.booksStore.bookStore.service.PublisherService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private PublisherService publisherService;

    @GetMapping("books")
    public String findAllBooks(Model model)
    {
        List<Book> books=bookService.findAllBooks();
        model.addAttribute("books", books);
        return "books";
    }
    
    @GetMapping("/book/{id}")
    public String geBookById(@PathVariable Long id,Model model) {
        Book book=bookService.findBookById(id);
        model.addAttribute("book", book);
        return "list-book";
    }

    @GetMapping("/remove-book/{id}")
    public String removeBookById(@PathVariable Long id,Model model)
    {
        bookService.deleteBook(id);
        model.addAttribute("books", bookService.findAllBooks());
        return "books";
    }

    @GetMapping("/update-book/{id}")
    public String updateBookById(@PathVariable Long id,Model model)
    {
        Book book=bookService.findBookById(id);
        model.addAttribute("book", book);
        model.addAttribute("categories", categoryService.findAllCategories());
        model.addAttribute("publishers", publisherService.findAllPublishers());
        model.addAttribute("authors", authorService.findAllAuthors());
        return "update-book";
        
    }

    @PostMapping("/save-update-book/{id}")
    public String saveUpdateById(@PathVariable Long id,Book book,BindingResult result,Model model) {
        if(result.hasErrors())
        {
            return "update-book"; 
        }
        bookService.updateBook(book,id);
        model.addAttribute("books", bookService.findAllBooks());
        return "redirect:/books";
    }
    
    @GetMapping("/add-book")
    public String addBook(Book book,Model model)
    {
        model.addAttribute("categories", categoryService.findAllCategories());
        model.addAttribute("publishers", publisherService.findAllPublishers());
        model.addAttribute("authors", authorService.findAllAuthors());
        return "add-book";
        
    }

    @PostMapping("/save-book")
    public String saveBook(Book book,BindingResult result,Model model) {
        if(result.hasErrors())
        {
            return "add-book"; 
        }
        bookService.saveBook(book);
        model.addAttribute("books", bookService.findAllBooks());
        return "redirect:/books";
    }
    
}
