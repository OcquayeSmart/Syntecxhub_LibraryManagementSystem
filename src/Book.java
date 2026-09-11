public class Book {
    final private String ISBN;
    final private String author;
    final private String title;
    private int pageCount;
    private boolean isAvailable;

    public Book(String ISBN, String author, String title, int pageCount, boolean isAvailable) {
        this.ISBN = ISBN;
        this.author = author;
        this.title = title;
        this.pageCount = pageCount;
        this.isAvailable = isAvailable;
    }
    public String toCSV(){
        return ISBN + "," + title + "," + author + "," + pageCount + "," + isAvailable;
    }
    public static Book fromCSV(String line){
        String[] parts = line.split(",");
        String isbn = parts[0];
        String title = parts[1];
        String author = parts[2];
        int pageCount = Integer.parseInt(parts[3]);
        boolean isAvailable = Boolean.parseBoolean(parts[4]);
        return new Book(isbn, title, author, pageCount, isAvailable);
    }

    public String getISBN() {
        return ISBN;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getPageCount() {
        return pageCount;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    @Override
    public String toString() {
        return "Book{" +
                "ISBN='" + ISBN + '\'' +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", pageCount=" + pageCount +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
