package Ex19.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class LibrarySet extends Library {
    private HashSet<Book> books;

    public LibrarySet(String name){
        super(name);
        books = new HashSet<>();
    }

    public Collection<Book> getBooks(){
        return books;
    }

    @Override
    int addBook(Book book) {
        if (!books.add(book))
            return -1;
        return book.getId();
    }

    @Override
    public String toStringSorted() { //Use Comparator<T> for sorting
        StringBuilder sb = new StringBuilder(String.format("Library %s:\n",name));
        sb.append("\nBooks:\n");
        if (books ==null || books.isEmpty())
            sb.append("The library is empty");
        else {
            List<Book> orderList = new ArrayList<>(books);
            //Collections.sort(orderList,new BookComparator());
            orderList.sort(new BookComparator());
            for (Book book : orderList)
                sb.append(String.format("- %s\n", book.toString()));
        }
        return sb.toString();
    }

}

