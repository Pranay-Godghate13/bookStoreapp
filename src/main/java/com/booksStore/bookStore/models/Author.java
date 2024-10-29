package com.booksStore.bookStore.models;

import java.util.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Author")
public class Author {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authorID;
    @Column(name = "Authors name",length = 100,unique = true,nullable = false)
    private String authorName;
    @Column(name = "Author description",length = 250,nullable = false)
    private String authorDescription;

    @ManyToMany(mappedBy = "authors",cascade = CascadeType.ALL)
    private Set<Book> books=new HashSet<Book>();

    public Author(String authorName, String authorDescription) {
        this.authorName=authorName;
        this.authorDescription=authorDescription;
    }

}
