package Ex19.model;

import java.util.*;

public class LibraryMap extends Library {
    private Map<Integer, Book> books;

    public LibraryMap(String name){
        super(name);
        books = new HashMap<>();
    }

    public Collection<Book> getBooks(){
        return books.values();
    }

    @Override
    int addBook(Book book) {
        if (books.values().contains(book))
            return -1;
        books.put(book.getId(), book);
        return book.getId();
    }


    @Override
    public String toStringSorted() { //Use Comparator<T> for sorting, ignoring case
        StringBuilder sb = new StringBuilder(String.format("Library %s:\n",name));
        sb.append("\nBooks:\n");
        if (books ==null || books.isEmpty())
            sb.append("The library is empty");
        else {
            List<Book> orderList = new ArrayList<>(books.values());
            orderList.sort(new BookComparatorIgnoreCase());
            for (Book book : orderList)
                sb.append(String.format("- %s\n", book.toString()));
        }
        return sb.toString();
    }

}
