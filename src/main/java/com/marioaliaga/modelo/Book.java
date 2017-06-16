package com.marioaliaga.modelo;

import javax.persistence.*;

/**
 * Created by maliaga on 6/15/17.
 */
@Entity
@Table
public class Book {

    @Id
    @Column(name = "BOOK_ID")
    private Long id;

    @Column(name = "NAME")
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AUTHOR_ID")
    private Author author;

    public Book() {
    }

    public Book(Long id, String title, Author author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author=" + author +
                '}';
    }
}
