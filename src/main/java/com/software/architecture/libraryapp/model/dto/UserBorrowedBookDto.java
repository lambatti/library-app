package com.software.architecture.libraryapp.model.dto;

public class UserBorrowedBookDto {
    private String coverUrl;
    private String title;
    private String author;
    private String publicationDate;
    private String genre;
    private String cover;
    private String borrowDate;
    private String returnDate;

    public UserBorrowedBookDto(String coverUrl, String title, String author, String publicationDate, String genre, String cover, String borrowDate, String returnDate) {
        this.coverUrl = coverUrl;
        this.title = title;
        this.author = author;
        this.publicationDate = publicationDate;
        this.genre = genre;
        this.cover = cover;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
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

    public String getGenre() {
        return genre;
    }

    public String getCover() {
        return cover;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public String getReturnDate() {
        return returnDate;
    }
}
