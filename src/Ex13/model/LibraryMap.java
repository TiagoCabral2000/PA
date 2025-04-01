package Ex13.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryMap implements ILibrary{
    private String name;
    private Map<Integer, Book> books;

    public LibraryMap(String name){
        this.name = name;
        books = new HashMap<>();
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
        Book newBook = new Book (title, authors);
        if (books.values().contains(newBook))
            return -1;
        books.put(newBook.getID(), newBook);
        return newBook.getID();
    }

    @Override
    public Book findBook(String title) throws CloneNotSupportedException {
        for (Book book:books.values()){
            if (book.getTitle().equalsIgnoreCase(title))
                return book.clone();
        }
        return null;
    }

    @Override
    public Book findBook(int id) throws CloneNotSupportedException {
        Book book = books.get(id);
        return book != null ? book.clone() : null;
    }

    @Override
    public boolean removeBook(String title) {
        for (Book book: books.values()){
            if (book.getTitle().equalsIgnoreCase(title)){
                return books.remove(book.getID()) != null;
            }
        }
        return false;
    }

    @Override
    public boolean removeBook(int id) {
        return books.remove(id) != null;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("Library %s:\n",name));
        for(Book book : books.values())
            output.append(String.format("  - %s\n",book));
        return output.toString();
    }
}
