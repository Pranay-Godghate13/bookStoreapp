package com.booksStore.bookStore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.booksStore.bookStore.models.Author;
import com.booksStore.bookStore.repository.AuthorRepository;

import java.util.*;

@Service
public class AuthorService {
    
    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> findAllAuthors()
    {
        return authorRepository.findAll();
    }

    public Author findAuthorById(Long id)
    {
        Author author=authorRepository.findById(id).orElseThrow(()->new RuntimeException("Author details not present"));
        return author;
    }

    public void saveAuthor(Author author)
    {
        authorRepository.save(author);
    }
  
    public void deleteAuthor(Long id)
    {
        Author author=authorRepository.findById(id).orElseThrow(()->new RuntimeException("Author details not present"));
        authorRepository.deleteById(id);

    }

    public void updateAuthor(Long id,Author author)
    {
        Author savedAuthor=authorRepository.findById(id).orElseThrow(()->new RuntimeException("Author not present in store"));
        savedAuthor.setAuthorName(author.getAuthorName());
        savedAuthor.setBooks(author.getBooks());
        savedAuthor.setAuthorDescription(author.getAuthorDescription());
        authorRepository.save(savedAuthor);
    }
}
