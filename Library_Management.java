import java.util.Scanner;
public class Library_Management{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Book Variables
        int bookId = 0;
        String bookName = "";
        String authorName = "";
        String category = "";
        int totalCopies = 0;
        int availableCopies = 0;

        // Student Variables
        int studentId = 0;
        String studentName = "";

        // Status Variables
        boolean bookAdded = false;
        boolean bookIssued = false;

        int choice;

        do {

            System.out.println("\n========== Library Management System ==========");
            System.out.println("1. Add Book");
            System.out.println("2. View Book");
            System.out.println("3. Search Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Delete Book");
            System.out.println("7. Library Report");
            System.out.println("8. Exit");
            System.out.print("Enter Your Choice : ");

            choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {

                case 1:

                    if(bookAdded) {
                        System.out.println("Book Already Exists.");
                        break;
                    }

                    System.out.print("Enter Book ID : ");
                    bookId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Book Name : ");
                    bookName = sc.nextLine();

                    System.out.print("Enter Author Name : ");
                    authorName = sc.nextLine();

                    System.out.print("Enter Category : ");
                    category = sc.nextLine();

                    System.out.print("Enter Total Copies : ");
                    totalCopies = sc.nextInt();

                    availableCopies = totalCopies;

                    bookAdded = true;

                    System.out.println("\nBook Added Successfully.");
                    break;

                case 2:

                    if(!bookAdded) {
                        System.out.println("No Book Available.");
                    }
                    else {

                        System.out.println("\n------ Book Details ------");

                        System.out.println("Book ID : " + bookId);
                        System.out.println("Book Name : " + bookName);
                        System.out.println("Author Name : " + authorName);
                        System.out.println("Category : " + category);
                        System.out.println("Total Copies : " + totalCopies);
                        System.out.println("Available Copies : " + availableCopies);
                    }

                    break;

                case 3:

                    if(!bookAdded) {

                        System.out.println("No Book Available.");
                        break;
                    }

                    System.out.println("Search By");
                    System.out.println("1. Book ID");
                    System.out.println("2. Book Name");
                    System.out.print("Enter Choice : ");

                    int searchChoice = sc.nextInt();
                    sc.nextLine();

                    if(searchChoice == 1) {

                        System.out.print("Enter Book ID : ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        if(id == bookId) {

                            System.out.println("Book Found");
                            System.out.println("Book Name : " + bookName);
                            System.out.println("Author : " + authorName);
                            System.out.println("Category : " + category);

                        } else {

                            System.out.println("Book Not Found.");
                        }

                    } else if(searchChoice == 2) {

                        System.out.print("Enter Book Name : ");
                        String name = sc.nextLine();

                        if(name.equalsIgnoreCase(bookName)) {

                            System.out.println("Book Found");
                            System.out.println("Book ID : " + bookId);
                            System.out.println("Author : " + authorName);
                            System.out.println("Category : " + category);

                        } else {

                            System.out.println("Book Not Found.");
                        }
                    }

                    break;
                                    case 4:

                    if (!bookAdded) {
                        System.out.println("No Book Available.");
                        break;
                    }

                    if (availableCopies <= 0) {
                        System.out.println("Book Not Available.");
                        break;
                    }

                    if (bookIssued) {
                        System.out.println("Book Already Issued.");
                        break;
                    }

                    System.out.print("Enter Student ID : ");
                    studentId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Student Name : ");
                    studentName = sc.nextLine();

                    availableCopies--;
                    bookIssued = true;

                    System.out.println("Book Issued Successfully.");
                    break;

                case 5:

                    if (!bookIssued) {
                        System.out.println("No Book Issued.");
                        break;
                    }

                    System.out.print("Enter Student ID : ");
                    int returnId = sc.nextInt();

                    if (returnId == studentId) {

                        availableCopies++;
                        bookIssued = false;
                        studentId = 0;
                        studentName = "";

                        System.out.println("Book Returned Successfully.");

                    } else {

                        System.out.println("Invalid Student ID.");
                    }

                    break;

                case 6:

                    if (!bookAdded) {

                        System.out.println("No Book Available.");
                        break;
                    }

                    bookId = 0;
                    bookName = "";
                    authorName = "";
                    category = "";
                    totalCopies = 0;
                    availableCopies = 0;

                    studentId = 0;
                    studentName = "";

                    bookAdded = false;
                    bookIssued = false;

                    System.out.println("Book Deleted Successfully.");
                    break;

                case 7:

                    if (!bookAdded) {

                        System.out.println("No Book Available.");
                        break;
                    }

                    int issuedCopies = totalCopies - availableCopies;

                    System.out.println("\n========== Library Report ==========");
                    System.out.println("Book ID : " + bookId);
                    System.out.println("Book Name : " + bookName);
                    System.out.println("Total Copies : " + totalCopies);
                    System.out.println("Available Copies : " + availableCopies);
                    System.out.println("Issued Copies : " + issuedCopies);

                    break;

                case 8:

                    System.out.println("Thank You for Using Library Management System.");
                    break;

                default:

                    System.out.println("Invalid Choice.");

            }

        } while (choice != 8);

        sc.close();

    }
}
    

        

