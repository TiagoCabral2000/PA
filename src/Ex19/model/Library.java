package Ex19.model;

import java.util.Collection;
import java.util.List;

public abstract class Library implements ILibrary{
    protected String name;

    public Library(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int addOldBook(String title, List<String> authors, int nrCopies){
        return addBook(new OldBook(title, authors, nrCopies));
    }

    public int addRecentBook(String title, List<String> authors, String isbn, double price){
        return addBook(new RecentBook(title, authors, price, isbn));
    }

    abstract int addBook(Book book);

    abstract Collection<Book> getBooks();

    @Override
    public Book findBook(String title) throws CloneNotSupportedException{
        Collection<Book> books = getBooks();

        for (Book book:books){
            if (book.getTitle().equalsIgnoreCase(title))
                return book.clone();
        }

        return null;
    }

    @Override
    public Book findBook(int id) throws CloneNotSupportedException{
        Collection<Book> books = getBooks();

        for(Book book: books){
            if (book.getId() == id)
                return book.clone();
        }

        return null;
    }

    @Override
    public boolean removeBook(String title){
        Collection<Book> books = getBooks();
        return books.remove(new Book(title, List.of()));
    }

    @Override
    public boolean removeBook(int id){
        Collection<Book> books = getBooks();
        for (Book book:books){
            if (book.getId() == id)
                return books.remove(book);
        }
        return false;
    }

    @Override
    public String toString() {
        Collection<Book> books= getBooks();
        StringBuilder output = new StringBuilder();
        output.append(String.format("Library %s:\n",name));
        for(Book book : books)
            output.append(String.format("  - %s\n",book));
        return output.toString();
    };

}
