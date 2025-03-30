package Ex13.model;

import java.util.HashSet;
import java.util.List;

public class LibrarySet implements ILibrary{
    private HashSet<Book> books;
    private String name;

    public LibrarySet(String name){
        books = new HashSet<>();
        this.name = name;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int addBook(String title, List<String> authors) {
        Book newBook = new Book(title, authors);
        if (!books.add(newBook))
            return -1;
        return newBook.getID();
    }

    @Override
    public Book findBook(String title) throws CloneNotSupportedException {
        return null;
    }

    @Override
    public Book findBook(int id) throws CloneNotSupportedException {
        return null;
    }

    @Override
    public boolean removeBook(String title) {
        return false;
    }

    @Override
    public boolean removeBook(int id) {
        return false;
    }
}
