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
    public Book fromCSV(String line){
        line = toCSV();
        String[] lines = line.split(",");
        lines[0] = ISBN;
        lines[1] = title;
        lines[2] = author;
        pageCount = Integer.parseInt(lines[3]);
        isAvailable = Boolean.parseBoolean(lines[4]);
        Book book = new Book(ISBN, title, author, pageCount, isAvailable);
        return book;
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
