import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        BookRepository repository = new BookRepository();
        Library library = new Library(repository);
        Scanner scanner = new Scanner(System.in);
        InputValidation validation = new InputValidation(scanner);
        LibraryMenu lb = new LibraryMenu(library, scanner, validation);
        lb.show();
    }
}
