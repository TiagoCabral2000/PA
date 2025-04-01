package Ex19.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LibraryList extends Library {
    private List<Book> books;

    public LibraryList(String name){
        super(name);
        books = new ArrayList<>();
    }

    public Collection<Book> getBooks(){
        return books;
    }

    @Override
    int addBook(Book book){
        if (books.contains(book))
            return -1;
        books.add(book);
        return book.getId();
    }

    @Override
    public String toStringSorted() { //Use Comparable<T> for sorting
        StringBuilder sb = new StringBuilder(String.format("Library: %s", name));
        sb.append("\nBooks:\n");
        if (books == null || books.isEmpty())
            sb.append("The library is empty");
        else{
            List<Book> orderedList = new ArrayList<>(books);
            Collections.sort(orderedList);
            for (Book book:orderedList)
                sb.append(String.format(" - %s\n", book.toString()));
        }
        return sb.toString();
    }
}
