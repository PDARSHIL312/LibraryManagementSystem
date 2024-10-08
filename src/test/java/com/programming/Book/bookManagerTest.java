package com.programming.Book;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

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
        assertThrows(RuntimeException.class, () -> {
            library.addBook("The SnowBall", "NoOne", "TATA", "12345", 0, 231, "English", publishedDate, false);

        });
    }


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
        assertThrows(RuntimeException.class , ()->{
            library.addBook("The SnowBall", "NoOne", "TATA", "2345567890123", 10, 231, "English", publishedDate, false);

        });
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

        assertThrows(RuntimeException.class, () -> {
            library.removeBook("The SnowBall", "1234567890123");
        });

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
    @Test
    public  void testReturnBookFunctionalityCheckFirstThatbookExist()
    {
        library.addBook("The SnowBall", "NoOne", "TATA", "2345567890123", 10, 231, "English", new Date(), false);
        library.addUser("U01", "Alice");
        library.borrowBook("The SnowBall" ,"2345567890123" , "U01" );
        assertThrows(RuntimeException.class , () ->{
            library.returnBook("RichDadPoorDad" ,"2345567890333" ,"U01");
        });
    }

    @Test
    public  void testReturnBookFunctionalityCheckFirstThatUserExist()
    {
        library.addBook("The SnowBall", "NoOne", "TATA", "2345567890123", 10, 231, "English", new Date(), false);
        System.out.println(library.getAllBooks());
        library.addUser("U01", "Alice");
//        library.addUser("A123" ,"DarshilPatel");
        System.out.println(library.getAllUser());
        library.borrowBook("The SnowBall" ,"2345567890123" , "U01" );
        assertThrows(RuntimeException.class , () ->
        {
            library.returnBook("The SnowBall" ,"2345567890123" ,"A123");
        });
    }

    @Test
    public  void testReturnBookFunctionalityCheckReturnDoneByTheUserWhoBorrowedBook()
    {
        library.addBook("The SnowBall", "NoOne", "TATA", "2345567890123", 10, 231, "English", new Date(), false);
        System.out.println(library.getAllBooks());
        library.addUser("U01", "Alice");
        library.addUser("A123" ,"DarshilPatel");
        System.out.println(library.getAllUser());
        library.borrowBook("The SnowBall" ,"2345567890123" , "U01" );
        assertThrows(RuntimeException.class , () ->
        {
            library.returnBook("The SnowBall" ,"2345567890123" ,"A123");
        });
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/BookData.csv")
    public void testtoAddBookFromCsvFile(String entry)
    {
        Object[] parts = entry.split(",");
        String title =(String)parts[0];
        String author = (String)parts[1];
        String publisher = (String)parts[2];
        String isbn  =(String)parts[3];
        int price = Integer.parseInt((String)parts[4]);
        int pages = Integer.parseInt((String)parts[5]);
        String language = (String)parts[6];
        boolean occupied = Boolean.parseBoolean((String)parts[8]);

        library.addBook(title, author , publisher,isbn ,price ,pages ,language, new Date() ,occupied);
        System.out.println(library.getAllBooks());
  }


}
