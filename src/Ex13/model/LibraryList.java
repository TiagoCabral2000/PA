package Ex13.model;

// -> This class represents a library which as a set of books
// -> In addition to books, the library has a name
// -> When an object of the LibraryList class is created, its name should be given
// -> The LibraryList is created without book records
// Methods:   - addBook() receives all the information to create a book
//              record, creates the record, and adds it to the library
//              It should return the id of the added book
//            - findBook()  receives either the id or name of the book to find
//              returns a reference to the book or null if no book is found
//            - removeBook() receives either the id or name of the book to remove
//              returns a boolean indicating the success of the operation
//            - toString() returns a string with the library description (name and books)

import java.util.ArrayList;
import java.util.List;

public class LibraryList implements ILibrary{

    private String name;
    private List<Book> books;

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
    public int addBook(String title, List<String> authors) {
        Book newBook = new Book(title, authors);
        if (books.contains(newBook))
            return -1;

        books.add(newBook);
        return newBook.getID();
    }

    @Override
    public Book findBook(String title) throws CloneNotSupportedException {
        Book dummyBook = new Book(title, List.of());
        int index = books.indexOf(dummyBook);
        if (index < 0)
            return null;
        return (Book) books.get(index).clone();
    }

    @Override
    public Book findBook(int id) throws CloneNotSupportedException {
        for (Book book:books) {
            if (book.getID() == id)
                return (Book) book.clone();
        }
        return null;
    }

    @Override
    public boolean removeBook(String title) {
        return books.remove(new Book(title, List.of()));
    }

    @Override
    public boolean removeBook(int id) {
        for (Book book:books) {
            if (book.getID() == id)
                return books.remove(book);
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("Library: %s \n", name));
        for (Book book:books)
            output.append(String.format(" - %s\n", book));

        return output.toString();
    }
}
