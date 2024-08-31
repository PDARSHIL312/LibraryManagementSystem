package com.programming.Book;

public class User {
    // Right Now User Have it's UserId And The Name by Which User Will Identify
    private String userId;
    private String name;

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }
}
