package com.programming.Book;

import java.util.*;

public class bookManager {

    private Map<String, book> bookDetails = new HashMap<>();
    private Map<String, User> users = new HashMap<>();

    // Adding the Book into the Map , here validation create new one and the duplication not happen
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

    // Borrowing the Book // so here for the key purpose needed isbn and book name so by which verification can done here
    public void borrowBook(String title, String isbn, String userId) {
        String key = generateKey(new book(title, null, null, isbn, 0, 0, null, null, false));
        if (!bookDetails.containsKey(key)) {
            throw new RuntimeException("Book does not exist");
        }
        if (!users.containsKey(userId)) {
            throw new RuntimeException("User does not exist");
        }
        book bookClass = bookDetails.get(key);
        if (bookClass.isOccupied()) {
            throw new RuntimeException("Book is already borrowed");
        }
        bookClass.setOccupied(true);
        System.out.println("Book borrowed successfully by user: " + userId);
    }

    // Adding a new User for the adding new User here Add User functionality and validation of User
    public void addUser(String userId, String name) {
        User user = new User(userId, name);
        user.validate(userId ,name);
        if (users.containsKey(userId)) {
            throw new RuntimeException("User already exists");
        }
        users.put(userId, user);
    }

    // Validation of the attribute that it is Null Or Not // for the entered attribute which is not null and other cross check
    private void validateTheEntry(book bookClass) {
        bookClass.validate();
    }

    // Checking if Book Already Exists
    private void checkIfBookAlreadyExist(book bookClass) {
        if (bookDetails.containsKey(generateKey(bookClass)))
            throw new RuntimeException("Book Already Exists");
    }

    // Method to return a book
    public void returnBook(String title, String isbn, String userId) {
        String key = generateKey(new book(title, null, null, isbn, 0, 0, null, null, false));
        if (!bookDetails.containsKey(key)) {
            throw new RuntimeException("Book does not exist");
        }

        book bookClass = bookDetails.get(key);
        if (!bookClass.isOccupied()) {
            throw new RuntimeException("Book is not currently borrowed");
        }

        if (!users.containsKey(userId)) {
            throw new RuntimeException("Invalid user");
        }

        bookClass.setOccupied(false);
        System.out.println("Book returned successfully by user: " + userId);
    }

    // Providing the data that you inserted
    public Collection<book> getAllBooks() {
        return bookDetails.values();
    }


    // Providing the User that you inserted
    public Collection<User> getAllUser() {
        return users.values();
    }

    // Creating a unique Key to enter data
    private String generateKey(book bookClass) {
        return String.format("%s-%s", bookClass.getTitle(), bookClass.getIsbn());
    }



}
