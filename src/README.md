📚 Library Management System
This Library Management System is a Java-based project that enables basic management of books and users, such as adding, removing, and borrowing books. The system ensures that only the user who borrowed a book can return it, preventing others from returning or borrowing already occupied books. This project is developed using Test-Driven Development (TDD) with JUnit and Maven for project management.

🚀 Key Features
Book Management:

Add books with details like title, author, ISBN, price, pages, language, published date, etc.
Remove books by title and ISBN.
Validate that the book doesn't already exist before adding it.
User Management:

Add users with unique IDs and names.
Ensure only valid users can borrow or return books.
Book Borrowing & Returning:

Borrow books by title and ISBN.
Validate that the book is not already borrowed.
Return books only if the user who borrowed it is the one returning it.
Track which user borrowed which book using a map.
🛠️ Technologies Used
Java (version 17): Core language for the application.
Maven: Project management and build tool.
JUnit 5: Used for writing and running unit tests.
Surefire Plugin: Generates test reports for JUnit tests.

📂 Project Structure
css
Copy code
├── src
│   ├── main
│   │   └── java
│   │       └── com
│   │           └── programming
│   │               └── Book
│   │                   ├── book.java
│   │                   ├── bookManager.java
│   │                   └── User.java
│   ├── test
│   │   └── java
│   │       └── com
│   │           └── programming
│   │               └── Book
│   │                   ├── bookManagerTest.java
│   │                   └── UserTest.java
└── pom.xml
🧩 Functionality Overview
📖 Book Management
Add Book: Adds a book with all details. Validates the book details and ensures the ISBN is unique and properly formatted.

java
Copy code
library.addBook("The SnowBall", "NoOne", "TATA", "2345567890123", 10, 231, "English", new Date(), false);
Remove Book: Removes a book from the library by title and ISBN, ensuring the book exists.

java
Copy code
library.removeBook("The SnowBall", "2345567890123");
Borrow Book: Allows a user to borrow a book if it is not already occupied. It checks the user’s ID and ensures that only valid users can borrow books.

java
Copy code
library.borrowBook("The SnowBall", "2345567890123", "U01");
Return Book: Ensures that only the user who borrowed a book can return it, preventing others from tampering with the borrowing process.

java
Copy code
library.returnBook("The SnowBall", "2345567890123", "U01");
👤 User Management
Add User: Adds a user to the system with a unique ID and name.

java
Copy code
library.addUser("U01", "Alice");
User Validation: Ensures user details are not null, and each user has a unique ID.

🧪 Tests
The project follows TDD practices, and JUnit 5 is used to write and run unit tests.

Running Tests
To run the test cases, use:

bash
Copy code
mvn test
Generating Test Report
To generate a detailed test report:

bash
Copy code
mvn surefire-report:report
The test report will be available at target/site/surefire-report.html.

Example Test
Here’s an example of a test case that ensures only the user who borrowed the book can return it:

java
Copy code
assertThrows(RuntimeException.class , () -> {
library.returnBook("The SnowBall", "2345567890123", "A123");
});
📂 Version Control & Git Commands
Creating a New Branch for Feature Development
To start working on a new feature or bug fix, create a new branch:

bash
Copy code
git checkout -b feature/add-new-functionality
Committing Changes
Once you've made changes, stage and commit them:

bash
Copy code
git add .
git commit -m "Add new functionality to borrow books"
Pushing Changes to the Remote Repository
Push your changes to the GitHub repository:


bash
Copy code
git push origin feature/add-new-functionality
Merging Changes Back to Main Branch
After the feature is complete and tested, merge it back into the main branch:

bash
Copy code
git checkout main
git merge feature/add-new-functionality

🎉 Conclusion
This Library Management System provides a robust way to manage books and users, ensuring that only the right users can borrow and return books. It incorporates validation at each step, ensuring data integrity and correctness.