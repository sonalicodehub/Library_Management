# Library Management System 📚📚

A menu-driven Java console application for managing a single book record in a library — add, view, search, issue, return, delete, and report on a book's status.

## Features

- **Add Book** — enter book ID, name, author, category, and total copies
- **View Book** — display full details of the currently added book
- **Search Book** — look up the book by ID or by name
- **Issue Book** — issue the book to a student (tracks student ID and name)
- **Return Book** — return an issued book after verifying the student ID
- **Delete Book** — remove the current book record and reset all data
- **Library Report** — view a summary including total, available, and issued copies
- **Exit** — close the application

## Requirements

- Java Development Kit (JDK) 8 or later

## How to Compile and Run

1. Save the source code in a file named `Library_Management.java`.
2. Open a terminal in the file's directory.
3. Compile the program:
   ```bash
   javac Library_Management.java
   ```
4. Run the program:
   ```bash
   java Library_Management
   ```

## Usage

On running the program, a menu is displayed:

```
========== Library Management System ==========
1. Add Book
2. View Book
3. Search Book
4. Issue Book
5. Return Book
6. Delete Book
7. Library Report
8. Exit
Enter Your Choice :
```

Enter the number corresponding to the desired operation. The menu repeats after each action until option `8` (Exit) is chosen.

### Example Flow

```
Enter Your Choice : 1
Enter Book ID : 101
Enter Book Name : The Alchemist
Enter Author Name : Paulo Coelho
Enter Category : Fiction
Enter Total Copies : 5

Book Added Successfully.

Enter Your Choice : 4
Enter Student ID : 201
Enter Student Name : Jane Smith
Book Issued Successfully.

Enter Your Choice : 7

========== Library Report ==========
Book ID : 101
Book Name : The Alchemist
Total Copies : 5
Available Copies : 4
Issued Copies : 1
```

## Menu Option Details

| Option | Action | Notes |
|---|---|---|
| 1 | Add Book | Fails if a book has already been added (only one book at a time) |
| 2 | View Book | Fails if no book has been added |
| 3 | Search Book | Search by Book ID or Book Name; fails if no book exists |
| 4 | Issue Book | Fails if no copies are available or a book is already issued |
| 5 | Return Book | Requires matching student ID to succeed |
| 6 | Delete Book | Resets all book and student data to defaults |
| 7 | Library Report | Shows total, available, and issued copy counts |
| 8 | Exit | Ends the program loop |

## Known Limitations

- **Single book only**: the system supports only one book record at a time — adding a new book requires deleting the existing one first.
- **Single issue only**: only one copy can be marked as "issued" at a time via the `bookIssued` flag, even if `availableCopies` allows more.
- **No input validation**: non-numeric input where numbers are expected will throw an `InputMismatchException`.
- **No persistent storage**: all data is lost when the program exits (no file or database backing).
- **No multi-student tracking**: only one student's issue record is stored at a time.

## Possible Improvements

- Use arrays, `ArrayList`, or a `HashMap` to support multiple books and concurrent issues
- Add proper input validation and exception handling
- Persist data using file I/O or a database
- Track issue/return history and due dates
- Separate concerns into `Book` and `Student` classes for better structure.
