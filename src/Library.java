import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> listOfBooks;
    private BookRepository repository;

    public Library(BookRepository repository, List<Book> books) {
        this.repository = repository;
        this.listOfBooks = repository.loadAll();
    }

    public void addBook(Book book){
        for(Book books:listOfBooks){
            if(book.getISBN().equals(books.getISBN())){
                System.out.println("Book already exists");
                return;
            }
            listOfBooks.add(book);
            repository.saveAll(listOfBooks);
            System.out.println("Your book has been added successfully");
        }
    }
    public void removeBook(Book book){
        for(Book singularbook:listOfBooks){
            if(!listOfBooks.contains(singularbook)){
                System.out.println("Book already removed!!");
                return;
            }
            listOfBooks.remove(book);
            repository.saveAll(listOfBooks);
            System.out.println("Your book has been removed");
        }
    }
    public void searchByTitle(Book book){
        for(Book singularbook:listOfBooks){
            if(!singularbook.getTitle().equalsIgnoreCase(book.getTitle())){
                System.out.println("Book does not exist");
                return;
            }
            System.out.println("You searched for: ");
            System.out.println(singularbook);
        }
    }
    public void searchByAuthor(Book book){
        for(Book singularbook:listOfBooks){
            if(!singularbook.getAuthor().equalsIgnoreCase(book.getTitle())){
                System.out.println("Book does not exist");
                return;
            }
            System.out.println("You searched for: ");
            System.out.println(singularbook);
        }
    }
    public void viewAvailableBooks(Book book){
        if(listOfBooks.isEmpty()){
            System.out.println("No books found.");
            return;
        }
        for(Book singularbook:listOfBooks){

        }
    }
}
