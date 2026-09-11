import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> listOfBooks;
    private BookRepository repository;

    public Library(BookRepository repository, List<Book> listOfBooks) {
        this.repository = repository;
        this.listOfBooks = repository.loadAll();
    }

    public void addBook(Book book){
        for(Book books:listOfBooks) {
            if (book.getISBN().equals(books.getISBN())) {
                System.out.println("Book already exists");
                return;
            }
        }
        listOfBooks.add(book);
        repository.saveAll(listOfBooks);
        System.out.println("Your book has been added successfully");

    }
    public void removeBook(String ISBN){
        Book bookFound = null;
        for(Book singularbook:listOfBooks) {
            if (singularbook.getISBN().equalsIgnoreCase(ISBN)) {
                bookFound = singularbook;
                break;
            }
        }
        if(bookFound != null){
            listOfBooks.remove(bookFound);
            repository.saveAll(listOfBooks);
            System.out.println("The book has been removed");
        }
        else {
            System.out.println("The book cannot be found");
        }
    }
    public List<Book> searchByTitle(String title){
        List<Book> emptyBook = new ArrayList<>();
        for(Book singularbook:listOfBooks){
            if(singularbook.getTitle().contains(title)){
                emptyBook.add(singularbook);
            }
        }
        return emptyBook;
    }
    public List<Book> searchByAuthor(String author){
        List<Book> emptyBook = new ArrayList<>();
        for(Book singularbook:listOfBooks){
            if(singularbook.getAuthor().contains(author)){
                emptyBook.add(singularbook);
            }
        }
        return emptyBook;
    }
    public void viewAvailableBooks(){
        if(listOfBooks.isEmpty()){
            System.out.println("There are no books in the library.");
            return;
        }
        System.out.println("\nISBN\t\tTitle\t\tAuthor\t\tPages\tAvailable");
        for(Book singularbook: listOfBooks){
            System.out.println(singularbook.getISBN() + "\t" + singularbook.getTitle() + "\t" + singularbook.getAuthor() + "\t" + singularbook.getPageCount() + "\t" + singularbook.isAvailable());
        }
    }
}
