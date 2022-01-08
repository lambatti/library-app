package com.software.architecture.libraryapp.model;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String coverUrl;
    private String title;
    private String author;
    private String publicationDate;
    // TODO: private Genres genre(?) DONE
    @Enumerated(EnumType.STRING)
    private Genres genre;
    private boolean isHardcover;
    private int count;
    private boolean isAvailable;
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Book() {

    }

    public int getId() {
        return id;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public Genres getGenre() {
        return genre;
    }

    public boolean isHardcover() {
        return isHardcover;
    }

    public int getCount() {
        return count;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public String getDescription() {
        return description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }


}
