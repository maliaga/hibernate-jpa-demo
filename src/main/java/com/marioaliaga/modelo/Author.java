package com.marioaliaga.modelo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by maliaga on 6/15/17.
 */
@Entity
@Table(name = "AUTHOR")
public class Author {

    @Id
    @Column(name = "AUTHOR_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "NATIONALITY")
    private String notionality;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Book> bookList = new ArrayList<>(0);


    public Author() {
    }

    public Author(Long id, String name, String notionality) {
        this.id = id;
        this.name = name;
        this.notionality = notionality;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotionality() {
        return notionality;
    }

    public void setNotionality(String notionality) {
        this.notionality = notionality;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", notionality='" + notionality + '\'' +
                '}';
    }
}
