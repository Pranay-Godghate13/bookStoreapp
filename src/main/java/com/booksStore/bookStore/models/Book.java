package com.booksStore.bookStore.models;

import java.util.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    @Column(name = "ISBN",length = 50,nullable =false,unique = true)
    private String isbn;
    @Column(name = "Book name",length = 50,nullable=false)
    private String bookName;
    @Column(name = "Book description",length = 500,nullable = false)
    private String bookDescription;
    @Column(name="Book link")
    private String link;
    
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "Books_Category", joinColumns = {@JoinColumn(name="Books_id")},inverseJoinColumns = {@JoinColumn(name="Category_id")})
    private Set<Category> categories=new HashSet<Category>();

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "Books_Author", joinColumns = {@JoinColumn(name="Books_id")},inverseJoinColumns = {@JoinColumn(name="Authors_id")})
    private Set<Author> authors=new HashSet<Author>();

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "Book_Publisher",joinColumns = {@JoinColumn(name="Books_id")},inverseJoinColumns = {@JoinColumn(name="Publisher_id")})
    private Set<Publisher> publishers=new HashSet<Publisher>();

    public void removePublisher(Publisher publisher)
    {
        this.publishers.remove(publisher);
        publisher.getBooks().remove(publisher);
    }

    public void addPublisher(Publisher publisher)
    {
        this.publishers.add(publisher);
        publisher.getBooks().add(this);
    }

    public void removeAuthor(Author author)
    {
        this.authors.remove(author);
        author.getBooks().remove(author);
    }

    public void addAuthor(Author author)
    {
        this.authors.add(author);
        author.getBooks().add(this);
    }

    public void removeCategory(Category category)
    {
        this.categories.remove(category);
        category.getBooks().remove(category);
    }

    public void addCategory(Category category)
    {
        this.categories.add(category);
        category.getBooks().add(this);
    }

    public Book(String isbn, String bookName,String link, String bookDescription) {
        this.isbn=isbn;
        this.bookName=bookName;
        this.link=link;
        this.bookDescription=bookDescription;
    }
}
