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

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", isbn='" + isbn + '\'' +
                ", price=" + price +
                ", pages=" + pages +
                ", language='" + language + '\'' +
                ", publishedDate=" + publishedDate +
                ", occupied=" + occupied +
                '}';
    }

}
