package com.booksStore.bookStore.service;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.booksStore.bookStore.models.Book;
import com.booksStore.bookStore.repository.BookRepository;


@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    
    public List<Book> findAllBooks()
    {
        return bookRepository.findAll();
    }

    public Book findBookById(Long id)
    {
        Book book=bookRepository.findById(id).orElseThrow(()->new RuntimeException("Book not present in store"));
        return book;
    }
    public void saveBook(Book book)
    {
        bookRepository.save(book);
    }
    public void updateBook(Book book,Long id)
    {
        Book savedBook=bookRepository.findById(id).orElseThrow(()->new RuntimeException("Book not present in store"));
        savedBook.setIsbn(book.getIsbn());
        savedBook.setBookName(book.getBookName());
        savedBook.setBookDescription(book.getBookDescription());
        savedBook.setCategories(book.getCategories());
        savedBook.setAuthors(book.getAuthors());
        savedBook.setPublishers(book.getPublishers());

        bookRepository.save(savedBook);
    }

    public void deleteBook(Long id)
    {
        Book book=bookRepository.findById(id).orElseThrow(()->new RuntimeException("Book not present in the store so cannot be deleted"));
        bookRepository.deleteById(book.getBookId());

    }

    
}
