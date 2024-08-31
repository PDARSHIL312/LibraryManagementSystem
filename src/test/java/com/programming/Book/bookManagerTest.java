package com.programming.Book;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class bookManagerTest {

    bookManager library;

    @BeforeAll
    public void setupAll() {
        System.out.println("This will run before the execution of all the test methods.");
    }

    @BeforeEach
    public void setup() {
        library = new bookManager();
    }

    @Test
    public void checkThatBookCanAddOrNot() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2003, Calendar.DECEMBER, 3);
        Date publishedDate = calendar.getTime();
        library.addBook("The SnowBall", "NoOne", "TATA", "12345", 0, 231, "English", publishedDate, false);    }

    @Test
    public void checkThatEntryisDoneInBookDatailsORNot() {
        // Ensure that a book is added before checking here
        Calendar calendar = Calendar.getInstance();
        calendar.set(2003, Calendar.DECEMBER, 3);
        Date publishedDate = calendar.getTime();


        library.addBook("The SnowBall", "NoOne", "TATA", "12345", 0, 231, "English", publishedDate, false);

        assertFalse(library.getAllBooks().isEmpty(), "The library should not be empty after adding a book.");

        System.out.println(library.getAllBooks());

    }
}
