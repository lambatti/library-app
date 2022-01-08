package com.software.architecture.libraryapp.model.dto;


import com.software.architecture.libraryapp.model.Genres;
import org.yaml.snakeyaml.util.EnumUtils;

public class BookDto {
    // hidden id
    private String coverUrl;
    private String title;
    private String author;
    private String publicationDate;
    // converted genre:
    private Genres genre;

    private boolean isHardcover;
    private int count;
    private boolean isAvailable;
    private String description;
    // hidden User


    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Genres getGenre() {
        return genre;
    }

    public void setGenre(Genres genre) {
        this.genre = genre;
    }

    public boolean isHardcover() {
        return isHardcover;
    }

    public void setHardcover(boolean hardcover) {
        isHardcover = hardcover;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
