package lbs;

import java.util.ArrayList;
import java.util.List;

public class BookManager {
    public static final BookManager instance = new BookManager();

    private List<Book> books = new ArrayList<>();
    private List<Transaction> transactions = new ArrayList<>();

    private BookManager() {
        // Add sample books for testing
        Book b1 = new Book("978-0-14-118280-3", "A Long Long Way", "Sebastian Barry", "Historical Fiction", "Faber & Faber", 2005);
        addBook(b1);
        Book b2 = new Book("978-0-19-921902-1", "Paradise Regained", "John Milton", "Poetry", "Oxford University Press", 1671);
        addBook(b2);
        Book b3 = new Book("978-0-14-042439-3", "Paradise Lost", "John Milton", "Poetry", "Penguin Classics", 1667);
        addBook(b3);
        Book b4 = new Book("978-0-345-34729-2", "The Guns of August", "Barbara Tuchman", "History", "Random House", 1962);
        addBook(b4);
        Book b5 = new Book("978-0-335-45634-5", "All Quiet on the Western Front", "Erich Maria Remarque", "History", "Propyläen Verlag", 1929);
        addBook(b5);
    }

    
    public void addBook(Book b) {
        books.add(b);
    }

    public void removeBook(int index) {
        if (index >= 0 && index < books.size()) {
            books.remove(index);
        }
    }

    public void updateBook(int index, Book b) {
        if (index >= 0 && index < books.size()) {
            books.set(index, b);
        }
    }

    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }

    public int getBookCount() {
        return books.size();
    }

    public int getIssuedBookCount() {
        int count = 0;
        for (Book b : books) {
            if (!b.isAvailable()) {
                count++;
            }
        }
        return count;
    }

    public List<Book> searchBooks(String query) {
        List<Book> result = new ArrayList<>();
        String lowerQuery = query.toLowerCase();
        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(lowerQuery) ||
                b.getAuthor().toLowerCase().contains(lowerQuery) ||
                b.getIsbn().toLowerCase().contains(lowerQuery) ||
                b.getGenre().toLowerCase().contains(lowerQuery) ||
                b.getPublisher().toLowerCase().contains(lowerQuery)) {
                result.add(b);
            }
        }
        return result;
    }

    public Book getBook(int index) {
        if (index >= 0 && index < books.size()) {
            return books.get(index);
        }
        return null;
    }

    public Book findBookByISBN(String isbn) {
        for (Book b : books) {
            if (b.getIsbn().equals(isbn)) {
                return b;
            }
        }
        return null;
    }

    public List<Transaction> getTransactions() {
        return new ArrayList<>(transactions);
    }

    public void addTransaction(Transaction t) {
        transactions.add(t);
    }

    // Remove a transaction from the central list
    public boolean removeTransaction(Transaction t) {
        return transactions.remove(t);
    }
}