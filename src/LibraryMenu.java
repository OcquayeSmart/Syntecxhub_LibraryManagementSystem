import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class LibraryMenu {
    private final Library library;
    private final Scanner scanner;
    private final InputValidation validation;
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
            int choice = validation.checkRange(0,5);
            switch(choice){
                case 1 -> addBookToLibrary();
                case 2 -> removeBookToLibrary();
                case 3 -> searchBookByTitle();
                case 4 -> searchBookByAuthor();
                case 5 -> library.viewAvailableBooks();
                case 0 -> isRunning = false;
            }
        }
    }
    public void addBookToLibrary(){
        System.out.print("Enter the book title to add: ");
        String title = validation.checkString();
        String ISBN = UUID.randomUUID().toString().substring(0,8);
        System.out.print("Name of author: ");
        String author = validation.checkString();
        System.out.print("Enter the number of pages: ");
        int numberOfPages = validation.checkInt();
        System.out.println("Your ISBN is: " + ISBN);
        Book book = new Book(ISBN, author, title, numberOfPages, true);
        library.addBook(book);
    }
    public void removeBookToLibrary(){
        System.out.print("Enter the ISBN of the book to remove: ");
        String ISBN = scanner.nextLine();
        library.removeBook(ISBN);
    }
    public void searchBookByTitle(){
        System.out.print("Enter the title of the book: ");
        String title = validation.checkString();

        List<Book> bookList = library.searchByTitle(title);
        if(bookList.isEmpty()){
            System.out.println("There are no books with that tile");
        }
        else{
            System.out.println("Your book has been found");
            for(Book book:bookList){
                System.out.println(book.getTitle() + " by " + book.getAuthor());
            }
        }
    }
    public void searchBookByAuthor(){
        System.out.print("Enter the name of the author: ");
        String author = validation.checkString();
        List<Book> bookList = library.searchByAuthor(author);
        if(bookList.isEmpty()){
            System.out.println("There are no books with that author");
        }
        else{
            System.out.println("Your book has been found");
            for(Book book:bookList){
                System.out.println(book.getTitle() + " by " + book.getAuthor());
            }
        }
    }
}
