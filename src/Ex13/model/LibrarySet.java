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
        Book newBook = new Book(title);
        if (books.contains(newBook))
            return newBook;
        return null;

        /*
        for (Book book:books){
            if (book.getTitle().equalsIgnoreCase(title))
                return book.clone();
        }
        return null;*/
    }

    @Override
    public Book findBook(int id) throws CloneNotSupportedException {
        for (Book book:books){
            if (book.getID() == id)
                return book.clone();
        }
        return null;
    }

    @Override
    public boolean removeBook(String title) {
        return books.remove(new Book(title));
    }

    @Override
    public boolean removeBook(int id) {
        for (Book book:books){
            if (book.getID() == id)
                return books.remove(book);
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(String.format("Library %s:\n", name));
        for (Book book:books)
            str.append(book.toString() + "\n");
        return str.toString();
    }
}
