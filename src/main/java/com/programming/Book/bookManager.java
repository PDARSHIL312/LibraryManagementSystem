package com.programming.Book;

import java.awt.print.Book;
import java.util.*;

public class bookManager {

    private Map<String, book> bookDetails = new HashMap<>();

    public void addBook(String title, String author, String publisher, String isbn, int price, int pages, String language, Date publishedDate, boolean occupied) {
        book bookClass = new book(title, author, publisher, isbn, price, pages, language, publishedDate, occupied);
        validateTheEntry(bookClass);
        checkIfBookAlreadyExist(bookClass);
        bookDetails.put(generateKey(bookClass), bookClass);
    }


    // validation of the attribute that it is Null Or Not
    private void validateTheEntry(book bookClass)
    {
        bookClass.validate();
    }

    private void checkIfBookAlreadyExist(book bookClass)
    {
        if (bookDetails.containsKey(generateKey(bookClass)))
            throw new RuntimeException("Book Already Exists");
    }

    public Collection<book> getAllBooks() {
        return bookDetails.values();
    }

    private String generateKey(book bookClass) {
        return String.format("%s-%s", bookClass.getTitle(), bookClass.getIsbn());
    }


}
