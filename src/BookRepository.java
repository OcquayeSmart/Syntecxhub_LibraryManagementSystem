import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private static final String filePath = "books.csv";
    public void saveAll(List<Book> listOfBook){
        try(FileWriter fw = new FileWriter(filePath)) {
            fw.write("ISBN, Title, Author, Page Count, Is Available\n");
            for(Book singleBook:listOfBook){
                fw.write(singleBook.toCSV());
                fw.write("\n");
            }
        }
        catch (IOException e) {
            System.out.println("Could not read file");
        }
        catch(Exception e){
            System.out.println("An error occurred");
        }
    }
    public List<Book> loadAll(){
        List<Book> books = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            br.readLine();
            while((line = br.readLine()) != null){
                if(!line.trim().isBlank()){
                    books.add(Book.fromCSV(line));
                }
            }
        }
        catch (FileNotFoundException e) {
            return new ArrayList<>();
        }
        catch (IOException e) {
            System.out.println("Could not read file");
        }
        return books;
    }
}
