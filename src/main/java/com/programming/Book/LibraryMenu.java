package com.programming.Book;

import java.util.Date;
import java.util.Scanner;

public class LibraryMenu {

    private static bookManager manager = new bookManager();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nLibrary Management System Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Show All Books");
            System.out.println("5. Add User");
            System.out.println("6. Show All Users");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    borrowBook();
                    break;
                case 3:
                    returnBook();
                    break;
                case 4:
                    showAllBooks();
                    break;
                case 5:
                    addUser();
                    break;
                case 6:
                    showAllUsers();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addBook() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter publisher: ");
        String publisher = scanner.nextLine();
        System.out.print("Enter ISBN (13 digits): ");
        String isbn = scanner.nextLine();
        System.out.print("Enter price: ");
        int price = scanner.nextInt();
        System.out.print("Enter number of pages: ");
        int pages = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter language: ");
        String language = scanner.nextLine();
        Date publishedDate = new Date();
        System.out.print("Is the book occupied (true/false): ");
        boolean occupied = scanner.nextBoolean();

        try {
            manager.addBook(title, author, publisher, isbn, price, pages, language, publishedDate, occupied);
            System.out.println("Book added successfully.");
        } catch (Exception e) {
            System.out.println("Error adding book: " + e.getMessage());
        }
    }

    private static void borrowBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter ISBN (13 digits): ");
        String isbn = scanner.nextLine();
        System.out.print("Enter user ID: ");
        String userId = scanner.nextLine();

        try {
            manager.borrowBook(title, isbn, userId);
        } catch (Exception e) {
            System.out.println("Error borrowing book: " + e.getMessage());
        }
    }

    private static void returnBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter ISBN (13 digits): ");
        String isbn = scanner.nextLine();
        System.out.print("Enter user ID: ");
        String userId = scanner.nextLine();

        try {
            manager.returnBook(title, isbn, userId);
        } catch (Exception e) {
            System.out.println("Error returning book: " + e.getMessage());
        }
    }

    private static void showAllBooks() {
        System.out.println("Books in the library:");
        for (book b : manager.getAllBooks()) {
            System.out.println(b);
        }
    }

    private static void addUser() {
        System.out.print("Enter user ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter user name: ");
        String name = scanner.nextLine();

        try {
            manager.addUser(userId, name);
            System.out.println("User added successfully.");
        } catch (Exception e) {
            System.out.println("Error adding user: " + e.getMessage());
        }
    }

    private static void showAllUsers() {
        System.out.println("Users in the system:");
        for (User u : manager.getAllUser()) {
            System.out.println(u);
        }
    }
}
