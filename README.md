# 📚 Library Management System

This project is a Java-based Library Management System developed with a focus on Test-Driven Development (TDD). The system allows users to manage a collection of books, add or remove books, and handle book borrowing and returning functionality. The project is built using Maven for project management and JUnit for testing.

## 🛠️ Project Setup

- **Java Version:** 21
- **Maven:** 3.8.4
- **JUnit:** 5.9.0

## 🚀 Functionality

### Manage Books
- **Add Book:** Users can add books to the library collection. Each book entry is validated to ensure all fields are correctly populated.
- **Remove Book:** Users can remove a book from the collection. The system checks if the book exists before attempting removal.
- **View All Books:** Retrieve a list of all books in the library.

### Manage Users
- **Add User:** Add a user to the system. User details are validated to ensure completeness.
- **View All Users:** Retrieve a list of all registered users.

### Borrow and Return Books
- **Borrow Book:** Users can borrow a book. The system ensures that the book is not already borrowed and marks it as occupied. Additionally, only the user who borrowed the book can return it.
- **Return Book:** Users can return a borrowed book. The system checks that the returning user is the one who originally borrowed the book.

### Validation
- **Book Validation:** Ensures all book attributes (e.g., title, ISBN, price) are correctly formatted and not null. The ISBN must be a 13-digit number, and price must be greater than zero.
- **User Validation:** Ensures that user details (e.g., user ID, name) are correctly populated.

## 🧪 Running Tests

This project uses JUnit 5 for testing, following a TDD approach. The tests validate all core functionalities, including adding/removing books, borrowing/returning books, and user management.

To run the tests and generate a test report, use the following commands:

```bash
mvn test


src/
├── main/
│   └── java/
│       └── com/
│           └── programming/
│               ├── Book/
│               │   ├── book.java
│               │   ├── bookManager.java
│               └── User/
│                   └── User.java
├── test/
│   └── java/
│       └── com/
│           └── programming/
│               ├── Book/
│               │   └── bookManagerTest.java
│               └── User/
│                   └── UserTest.java
```

####🌐 Git Workflow
Here are some common git commands to manage your repository:

Initialize Repository:

bash
git init
Add Files:

bash
git add .
Commit Changes:

bash
git commit -m "Initial commit with book management functionality"
Create a New Branch for Tests:

bash
git checkout -b feature/tests
Merge Branch:

bash
git checkout main
git merge feature/tests
Push Changes to Remote:

bash
git push origin main
