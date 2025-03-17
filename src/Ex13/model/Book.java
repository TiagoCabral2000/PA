package Ex13.model;

// -> Book class represents the concept of a book record in a library
// -> It should be possible tothercreate objects of the Book class,
//giving information about the title and authors
// -> The book id must be generated automatically
// -> The Book class should implement the following methods (from Object class):
//      - toString() which returns a string with the object's description
//      -  equals() twotherbooks are considered the same if they have the same name
//      - hashCode() which returns the hash code of the object
//      - clone() which generates a copy of the object

import java.util.List;

public class Book {
    String title;
    List<String> authors;
    private final int id;
    static int counter = 0;

    public Book(String title, List<String> authors){
        this.title = title;
        this.authors = authors;
        id = ++counter;
    }

    public String getTitle(){
        return title;
    }

    public boolean setTitle(String newTitle){
        if (title == null)
            return false;
        title = newTitle;
        return true;
    }

    public List<String> getAuthors(){
        return List.copyOf(authors);
    }

    public int getID(){
        return id;
    }

    public boolean setAuthors(List<String> authors){
        if (authors == null)
            return false;
        this.authors = List.copyOf(authors);
        return true;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this)
            return true;
        if (other== null || getClass() != other.getClass())
            return false;

        Book book = (Book) other;
        return title.equalsIgnoreCase(book.title);
    }

    @Override
    public int hashCode() {
        return title.toUpperCase().hashCode();
    }

    @Override
    public String toString() {
        String strAuthors = getAuthors().toString(); //Output = [author1, author2, ...]

        return String.format("[%d] - %s - %s", id, title, strAuthors.substring(1, strAuthors.length()-1));
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Book newBook = (Book) super.clone();
        newBook.authors = List.copyOf(authors);
        return newBook;
    }
}
