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
                case 1 -> addBookToLibrary();
                case 2 -> removeBookToLibrary();
                case 3 -> searchBookByTitle();
                case 4 -> searchBookByAuthor();
                case 5 -> library.viewAvailableBooks();
                case 0 -> isRunning = false;
                default -> validation.checkRange(1,5);
            }
        }
    }
    public void addBookToLibrary(){
        System.out.print("Enter the book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter the ISBN: ");
        String ISBN = scanner.nextLine();
        System.out.print("Name of author: ");
        String author = scanner.nextLine();
        System.out.print("Enter the number of pages: ");
        int numberOfPages = validation.checkInt();
        Book book = new Book(ISBN, author, title, numberOfPages, true);
        library.addBook(book);
    }
    public void removeBookToLibrary(){
        System.out.print("Enter title of book to borrow: ");
        String title = scanner.nextLine();
        System.out.print("Enter the ISBN: ");
        String ISBN = scanner.nextLine();
        System.out.print("Enter the name of author: ");
        String author = scanner.nextLine();
        System.out.print("Enter the number of pages: ");
        int numberOfPages = validation.checkInt();
        boolean isAvailable = true;
        Book book = new Book(ISBN, author, title, numberOfPages, false);
        library.removeBook(book);
    }
    public void searchBookByTitle(){
        System.out.print("Enter the title of the book: ");
        String title = scanner.nextLine();
        library.searchByTitle(title);
    }
    public void searchBookByAuthor(){
        System.out.print("Enter the name of the author: ");
        String author = scanner.nextLine();
        library.searchByAuthor(author);
    }
}
