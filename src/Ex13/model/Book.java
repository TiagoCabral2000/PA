package Ex13.model;

import java.util.List;

public class Book implements Cloneable{
    private String title;
    private List<String> authors;
    private final int ID;
    private static int count = 0;

    public Book(String title, List<String> authors){
        this.title = title;
        this.authors = authors;
        this.ID = ++count;
    }

    //optional
    public Book(String title, String... authors) {
        this.ID = ++count;
        this.title = title;
        this.authors = List.of(authors);
    }

    @Override
    public String toString() {
        String strAuth = authors.toString(); //output: [auth1,auth2,auth3]
        return String.format(
                "[%d] %s - %s",
                ID, title, strAuth.substring(1, strAuth.length() - 1)
        );
    }

    @Override
    public boolean equals(Object other) {
        if (other == this)
            return true;
        if (other == null || other.getClass() != getClass())
            return false;

        Book o = (Book) other;
        return title.equalsIgnoreCase(o.title);
    }

    @Override
    public int hashCode(){
        return title != null ? title.toUpperCase().hashCode() : 0;
    }

    @Override
    protected Book clone() throws CloneNotSupportedException {
        Book newBook = (Book) super.clone();
        newBook.authors = List.copyOf(authors);
        return newBook;
    }

    //getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public int getID() {
        return ID;
    }

}
