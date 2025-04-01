package Ex19.model;

import java.util.Comparator;
import java.util.List;

public class Book implements Cloneable, Comparable<Book> {
    private static int counter = 0;

    public static int getNewId() {
        return ++counter;
    }

    private int id;
    private String title;
    private List<String> authors;

    protected Book(String title, List<String> authors) {
        this.id = getNewId();
        this.title = title;
        this.authors = List.copyOf(authors);
    }

    //optional
    protected Book(String title, String... authors) {
        this.id = getNewId();
        this.title = title;
        this.authors = List.of(authors);
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAuthors() {
        return List.copyOf(authors);
    }

    public void setAuthors(List<String> authors) {
        this.authors = List.copyOf(authors);
    }

    @Override
    public String toString() {
        String strAuthors = authors.toString();
        return String.format("[%d] %s - %s",
                id,title,
                strAuthors.substring(1,strAuthors.length()-1));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Book book)) //Verifica se o é uma instância de Book - Se for, automaticamente faz o cast e atribui a uma nova variável chamada book
            return false;

        return title.equalsIgnoreCase(book.title);
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.toUpperCase().hashCode() : 0;
        return result;
    }

    @Override
    protected Book clone() throws CloneNotSupportedException {
        Book newBook = (Book) super.clone();
        //newBook.id = getNewId(); // ????
        newBook.authors = List.copyOf(authors);
        return newBook;
    }


    @Override
    public int compareTo(Book o) {
        return title.toUpperCase().compareTo(o.title.toUpperCase());
    }
}

class BookComparator implements Comparator<Book>{
    @Override
    public int compare(Book o1, Book o2) {
        return o1.getTitle().compareTo(o2.getTitle());
    }
}

class BookComparatorIgnoreCase implements Comparator<Book>{
    @Override
    public int compare(Book o1, Book o2) {
        return o1.getTitle().toUpperCase().compareTo(o2.getTitle().toUpperCase());
    }
}

