import java.util.Scanner;

public class LibraryMenu {
    private Library library;
    private Scanner scanner;
    private InputValidation validation;
    boolean isRunning = true;

    public LibraryMenu(Library library, Scanner scanner, InputValidation validation) {
        this.library = library;
        this.scanner = scanner;
        this.validation = validation;
    }

    public void show(){
        while(isRunning){
            System.out.println("""
    LIBRARY MANAGEMENT SYSTEM
1. Add Book
2. Remove Book
3. Search by Title
4. Search by Author
5. View All Books
0. Exit
""");
            System.out.print("Enter you choice(1-5): ");
            int choice = validation.checkInt();
            switch(choice){
                case 1 -> addBook();
                case 2 -> removeBook();
                case 3 -> searchByTitle();
                case 4 -> searchByAuthor();
                case 5 -> viewAvailableBooks();
                case 0 -> isRunning = false;
            }
        }
    }
}
