package Ex13.model;

import java.util.ArrayList;
import java.util.List;

public class LibraryList implements ILibrary {
    private List<Book> books;
    private String name;

    public LibraryList(String name){
        this.name = name;
        books = new ArrayList<>();
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
    public int addBook(String title, List<String> authors){
        Book newBook = new Book(title, authors);
        books.add(newBook);
        return newBook.getID();
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
    public Book findBook(String name) throws CloneNotSupportedException { //check equals method in Book class
        Book tempBook = new Book(name, List.of());
        int index = books.indexOf(tempBook);
        if (index >= 0)
            return books.get(index).clone();
        return null;
    }

    @Override
    public boolean removeBook(int id){
        for (Book book: books){
            if (book.getID() == id) {
                books.remove(book);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeBook(String name){
        return books.remove(new Book(name, List.of()));
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
