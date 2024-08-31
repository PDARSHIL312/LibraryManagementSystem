package com.programming.Book;

import java.util.Date;

public class book
{
    private String title;
    private String author;
    private String publisher;
    private String isbn;
    private int price;
    private int pages;
    private String language;
    private Date publishedDate;
    private boolean occupied;

    public book(String title, String author, String publisher, String isbn, int price, int pages, String language, Date publishedDate, boolean occupied) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.price = price;
        this.pages = pages;
        this.language = language;
        this.publishedDate = publishedDate;
        this.occupied = occupied;
    }
// Add like borrowed Date and Return Date And Calsulate duration pay for rent functionallity...


    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getPrice() {
        return price;
    }

    public int getPages() {
        return pages;
    }

    public String getLanguage() {
        return language;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public void validate() {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        if (author == null || author.isEmpty()) {
            throw new IllegalArgumentException("Author cannot be null or empty");
        }
        if (publisher == null || publisher.isEmpty()) {
            throw new IllegalArgumentException("Publisher cannot be null or empty");
        }
//        long isbndigit = Long.parseLong(this.isbn);
        if (isbn == null || isbn.length() != 13 || !isbn.matches("\\d{13}")) {
            throw new IllegalArgumentException("ISBN must be a 13-digit number without any letters");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be greater than zero");
        }
        if (pages <= 0) {
            throw new IllegalArgumentException("Pages must be greater than zero");
        }
        if (language == null || language.isEmpty()) {
            throw new IllegalArgumentException("Language cannot be null or empty");
        }
        if (publishedDate == null) {
            throw new IllegalArgumentException("Published date cannot be null");
        }
        if (occupied != true && occupied != false) {
            throw new IllegalArgumentException("Occupied must be a boolean value");
        }
    }

    // Getters and setters omitted for brevity

    @Override
    public String toString() {
        return String.format("Book{title='%s', author='%s', publisher='%s', isbn='%s', price=%d, pages=%d, language='%s', publishedDate=%s, occupied=%b}",
                title, author, publisher, isbn, price, pages, language, publishedDate, occupied);
    }

}
