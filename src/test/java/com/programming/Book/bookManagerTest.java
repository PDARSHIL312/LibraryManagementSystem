package com.programming.Book;

import org.junit.jupiter.api.*;

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

    @Test
    @DisplayName("Here checking for the Validation and also if their null than it will throw error i use here assertThrows For that")
    public void checkThatEntryDoneHavingAnyNullOrNotAndTheValidtion()
    {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2003, Calendar.DECEMBER, 3);
        Date publishedDate = calendar.getTime();
        library.addBook("The SnowBall", "NoOne", "TATA", "2345567890123", 10, 231, "English", publishedDate, false);
        assertThrows(RuntimeException.class , () ->{
            library.addBook("The SnowBall", "NoOne", "TATA", null, 10, 231, "English", publishedDate, false);
            library.addBook(null, "NoOne", "TATA", null, 10, 231, "English", publishedDate, false);
            library.addBook(null, null, "TATA", null, 10, 231, "English", publishedDate, false);
            library.addBook(null, null, null, null, 10, 231, "English", publishedDate, false);
            library.addBook("The SnowBall", "NoOne", "TATA", "12345", 0, 231, "English", publishedDate, false);
            library.addBook("The SnowBall", "NoOne", "TATA", "12345", 110, 0, "English", publishedDate, false);
            library.addBook("The SnowBall", "NoOne", "TATA", "12345", 0, 231, null, publishedDate, false);
            library.addBook("The SnowBall", "NoOne", "TATA", "12345", 0, 231, "English", null, false);
        });
    }

    @Test
    @DisplayName("Here check that this boook is already exist if yes than throw error")
    public void checkIfBookIsAlreadyAdded()
    {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2003, Calendar.DECEMBER, 3);
        Date publishedDate = calendar.getTime();
        library.addBook("The SnowBall", "NoOne", "TATA", "2345567890123", 10, 231, "English", publishedDate, false);

        assertFalse(library.getAllBooks().isEmpty(), "The library should not be empty after adding a book.");

        // Here i am checking that if i agian enter the same book it Thorw exception or not
        library.addBook("The SnowBall", "NoOne", "TATA", "2345567890123", 10, 231, "English", publishedDate, false);
    }

//    @Test



}
