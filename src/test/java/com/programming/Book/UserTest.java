package com.programming.Book;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User user;

    @Test
    void testUserCreationValid() {
        // Test creating a valid user
        user = new User("U01", "Alice");
        assertNotNull(user);
        assertEquals("U01", user.getUserId());
        assertEquals("Alice", user.getName());
    }

    @Test
    void testUserCreationWithNullUserId() {
        // Test creating a user with a null userId should throw an exception
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new User(null, "Alice");
        });
        assertEquals("User ID cannot be null or empty.", exception.getMessage());
    }

    @Test
    void testUserCreationWithEmptyUserId() {
        // Test creating a user with an empty userId should throw an exception
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new User("", "Alice");
        });
        assertEquals("User ID cannot be null or empty.", exception.getMessage());
    }

    @Test
    void testUserCreationWithNullName() {
        // Test creating a user with a null name should throw an exception
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new User("U01", null);
        });
        assertEquals("Name cannot be null or empty.", exception.getMessage());
    }

    @Test
    void testUserCreationWithEmptyName() {
        // Test creating a user with an empty name should throw an exception
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new User("U01", "");
        });
        assertEquals("Name cannot be null or empty.", exception.getMessage());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/user.csv")
    public void testUserCreationWithNullUserIds(String entries ) {
        // Create a User object with the CSV data

        String[] parts = entries.split(",");
        String Id = parts[0].trim();
        String name = parts[1].trim();
        User user = new User(Id, name);

        // Construct the expected string based on the current data
        String expectedString = "User{id='" + Id + "', name='" + name + "'}";

        // Assert that the toString method returns the expected string
        assertEquals(expectedString, user.toString());
    }
}
