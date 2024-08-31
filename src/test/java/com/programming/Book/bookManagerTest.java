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
//        library = new bookManager();
        library = new bookManager();
//        library.addUser("U01", "Alice");
//        library.addBook("The SnowBall", "Alice", "TATA", "1234567890123", 200, 350, "English", new Date(), false);

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
//        library.addBook("The SnowBall", "NoOne", "TATA", "12345", 0, 231, "English", publishedDate, false);
        library.addBook("The SnowBall", "NoOne", "TATA", "2345567890123", 10, 231, "English", publishedDate, false);

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

    @Test
    // this test is for if we want to remove book and that is available in the Map
    public void testRemoveBookSuccess() {
        library.addBook("The SnowBall", "NoOne", "TATA", "2345567890123", 10, 231, "English", new Date(), false);

        library.removeBook("The SnowBall", "2345567890123");
        assertTrue(library.getAllBooks().isEmpty());
    }

    @Test
    public void testRemoveBookFailsWhenEmpty() {
        library.removeBook("The SnowBall", "1234567890123"); // Remove first
        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            library.removeBook("The SnowBall", "1234567890123");
        });
        assertEquals("Book does not exist", thrown.getMessage());
    }

    @Test
    // Testing the functionality of Add User and the Maping
    public void testAddingUserFunctionalityIfItIsEmpty()
    {
        library.addUser("123-dar" ,"Darshil");
        assertFalse(library.getAllUser().isEmpty());
    }

    @Test
    public void testUserBorroowfunctionalityBookNotExist()
    {
        library.addBook("The SnowBallsss", "NoOne", "TATA", "2345567890123", 10, 231, "English", new Date(), false);
        library.addUser("U01", "Alice");

        assertThrows(RuntimeException.class , ()-> {
            library.borrowBook("The SnowBall" ,"2345567890123" , "U01" );
        });
    }
    @Test
    public void testUserBorroowfunctionalityUserNotExist()
    {
        library.addBook("The SnowBall", "NoOne", "TATA", "2345567890123", 10, 231, "English", new Date(), false);
//        library.addUser("U01", "Alice");
        assertThrows(RuntimeException.class ,()->{
            library.borrowBook("The SnowBall" ,"2345567890123" , "U01111" );
        });
    }

    @Test
    public void testUserBorroowfunctionalityAlreadyBorrowed()
    {
        library.addBook("The SnowBall", "NoOne", "TATA", "2345567890123", 10, 231, "English", new Date(), false);
        library.addBook("The SnowBalls", "NoOne", "TATA", "2345567890133", 10, 231, "English", new Date(), false);
        library.addUser("U01", "Alice");
        library.borrowBook("The SnowBall" ,"2345567890123" , "U01" );

        assertThrows(RuntimeException.class ,() ->{
            library.addUser("U011", "Alice");
            library.borrowBook("The SnowBall" ,"2345567890123" , "U011" );
        });


    }



}
