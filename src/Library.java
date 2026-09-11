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
}
