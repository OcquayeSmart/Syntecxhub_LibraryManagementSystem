public class Book {
    String ISBN;
    String author;
    String title;
    int pageCount;
    boolean isAvailable;

    public Book(String ISBN, String author, String title, int pageCount, boolean isAvailable) {
        this.ISBN = ISBN;
        this.author = author;
        this.title = title;
        this.pageCount = pageCount;
        this.isAvailable = isAvailable;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
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
