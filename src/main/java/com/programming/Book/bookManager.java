package com.programming.Book;

import java.util.*;

public class bookManager {

    private Map<String, book> bookDetails = new HashMap<>();

    // Adding the Book into the Map here mailny adding , validation and duplication Not Happen that happen
    public void addBook(String title, String author, String publisher, String isbn, int price, int pages, String language, Date publishedDate, boolean occupied) {
        book bookClass = new book(title, author, publisher, isbn, price, pages, language, publishedDate, occupied);
        validateTheEntry(bookClass);
        checkIfBookAlreadyExist(bookClass);
        bookDetails.put(generateKey(bookClass), bookClass);
    }

    // Removing the Book from the Map
    public void removeBook(String title, String isbn) {
        String key = generateKey(new book(title, null, null, isbn, 0, 0, null, null, false));
        if (bookDetails.isEmpty()) {
            throw new RuntimeException("No books available to remove");
        }
        if (!bookDetails.containsKey(key)) {
            throw new RuntimeException("Book does not exist");
        }
        bookDetails.remove(key);
    }

    // Borrowing the Book here User entry and the Borrowing the Book and For that Occupied Data change will Happen
    public void borrowBook(String title, String isbn, User user) {
        String key = generateKey(new book(title, null, null, isbn, 0, 0, null, null, false)); // here only For Authentication Purpose Key needed For that
        if (!bookDetails.containsKey(key)) {
            throw new RuntimeException("Book does not exist");
        }
        book bookToBorrow = bookDetails.get(key);
        if (bookToBorrow.isOccupied()) {
            throw new RuntimeException("Book is already occupied");
        }
        bookToBorrow.setOccupied(true);
        System.out.println(user.getName() + " borrowed the book: " + title);
    }

    // Returning the Book
    public void returnBook(String title, String isbn) {
        String key = generateKey(new book(title, null, null, isbn, 0, 0, null, null, false));
        if (!bookDetails.containsKey(key)) {
            throw new RuntimeException("Book does not exist");
        }
        book bookToReturn = bookDetails.get(key);
        if (!bookToReturn.isOccupied()) {
            throw new RuntimeException("Book is not currently borrowed");
        }
        bookToReturn.setOccupied(false);
        System.out.println("Book: " + title + " has been returned.");
    }

    // Validation of the attribute that it is Null Or Not
    private void validateTheEntry(book bookClass) {
        bookClass.validate();
    }

    // Checking if Book Already Exists
    private void checkIfBookAlreadyExist(book bookClass) {
        if (bookDetails.containsKey(generateKey(bookClass)))
            throw new RuntimeException("Book Already Exists");
    }

    // Providing the data that you inserted
    public Collection<book> getAllBooks() {
        return bookDetails.values();
    }

    // Creating a unique Key to enter data
    private String generateKey(book bookClass) {
        return String.format("%s-%s", bookClass.getTitle(), bookClass.getIsbn());
    }
}
