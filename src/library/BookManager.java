package library;

public abstract class BookManager {
    abstract void addBook(Book book);
    abstract void printAllBook();
    abstract void updateBook(Book book);
    abstract void removeBook(long id);
}
