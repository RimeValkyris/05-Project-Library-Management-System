package lbs;

/**
 * Book subclass extending LibraryItem
 */
public class Book extends LibraryItem {
    private String author;
    private String genre;
    private String publisher;
    private int year;

    
    public Book(String isbn, String title, String author, String genre, String publisher, int year) {
        super(title, isbn); // title and isbn (as itemId) to parent
        this.author = author;
        this.genre = genre;
        this.publisher = publisher;
        this.year = year;
    }

 
    public Book() {
        super("", ""); // Call parent default
    }

    // Getters
    public String getIsbn() {
        return getItemId(); // isbn is stored as itemId in parent
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getYear() {
        return year;
    }

    // Setters
    public void setIsbn(String isbn) {
        setItemId(isbn); // Update itemId in parent
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String getDetails() {
        return "Book: " + getTitle() + " by " + author + ", ISBN: " + getItemId() + ", Genre: " + genre + ", Publisher: " + publisher + ", Year: " + year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + getItemId() + '\'' +
                ", title='" + getTitle() + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", publisher='" + publisher + '\'' +
                ", year=" + year +
                ", isAvailable=" + isAvailable() +
                '}';
    }
}