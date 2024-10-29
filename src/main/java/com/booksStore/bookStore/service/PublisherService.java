package com.booksStore.bookStore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.booksStore.bookStore.models.Publisher;
import com.booksStore.bookStore.repository.PublisherRepository;

@Service
public class PublisherService {
    @Autowired
    private PublisherRepository publisherRepository;

    public List<Publisher> findAllPublishers()
    {
        return publisherRepository.findAll();
    }

    public Publisher findPublisherById(Long id)
    {
        Publisher publisher=publisherRepository.findById(id).orElseThrow(()->new RuntimeException("Category does not exist"));
        return publisher;
    }

    public void savePublisher(Publisher publisher)
    {
        publisherRepository.save(publisher);
    }

    public void deletePublisher(Long id)
    {
        Publisher publisher=publisherRepository.findById(id).orElseThrow(()->new RuntimeException("Category does not exist"));
        publisherRepository.deleteById(publisher.getPublisherId());

    }

    public void updatPublisher(Long id,Publisher publisher)
    {
        Publisher savedPublisher=publisherRepository.findById(id).orElseThrow(()->new RuntimeException("No publisher present"));
        savedPublisher.setPublisherName(publisher.getPublisherName());
        savedPublisher.setBooks(publisher.getBooks());
        publisherRepository.save(savedPublisher);
    }

}
