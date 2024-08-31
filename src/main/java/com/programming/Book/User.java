package com.programming.Book;

import java.util.Objects;

public class User {
    private String userId;
    private String name;

    public User(String userId, String name) {
        validate(userId, name);
        this.userId = userId;
        this.name = name;
    }

    public void validate(String userId, String name) {
        if (userId == null || userId.trim().isEmpty()) {
            throw new IllegalArgumentException("User ID cannot be null or empty.");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("User{id='%s', name='%s'}", userId, name);
    }

}
