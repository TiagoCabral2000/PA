package Ex11.model;

import java.util.Scanner;

public class Report {
    private String title;
    private String[] authors;
    int currentAuthors;
    private final int AUTHORS_SIZE = 5;
    private StringBuilder text;

    public Report(String title){
        this.title = title;
        this.authors = new String[AUTHORS_SIZE];
        this.currentAuthors = 0;
        this.text = new StringBuilder();
    }

    public void addAuthor(String author){
        for (int i = 0; i < currentAuthors; i++) {
            if (authors[i].equals(author)) {
                return;
            }
        }

        if (currentAuthors == authors.length){
            String[] aux = new String[currentAuthors + AUTHORS_SIZE];
            System.arraycopy(authors, 0, aux, 0, authors.length);
            authors = aux;
        }

        authors[currentAuthors++] = author;
        return;
    }

    public boolean removeAuthor(String author) {
        for (int i = 0; i < currentAuthors; i++) {
            if (authors[i].equals(author)) {
                for (int j = i; j < currentAuthors - 1; j++) {
                    authors[j] = authors[j + 1];
                }
                authors[--currentAuthors] = null;
                return true;
            }
        }
        return false;
    }

    public void addText(String text) {
        this.text.append(text + " ");

    }

    public void capitalizeSentences() {
        if (text.length() == 0) {
            return;
        }
        text.setCharAt(0, Character.toUpperCase(text.charAt(0)));

        for (int i = 1; i < text.length(); i++) {
            if (text.charAt(i - 1) == '.' || text.charAt(i - 1) == '!' || text.charAt(i - 1) == '?') {
                if (Character.isWhitespace(text.charAt(i))) {
                    i++;
                }
                if (i < text.length()) {
                    text.setCharAt(i, Character.toUpperCase(text.charAt(i)));
                }
            }
        }
    }

    public int getNumberOfWords() {
        int numWords = 0;
        Scanner sc = new Scanner(text.toString());
        sc.useDelimiter("[\\s,.!?]+");
        while (sc.hasNext()){
            String str = sc.next();
            numWords++;
        }
        return numWords;
    }

    public int getNumberOfOccurrences(String word) {
        int count = 0;
        Scanner sc = new Scanner(text.toString());
        sc.useDelimiter("[\\s,.!?]+");
        while (sc.hasNext()){
            String str = sc.next();
            if (str.equalsIgnoreCase(word))
                count++;
        }
        return count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Title: ").append(title).append("\n");
        sb.append("Authors: ");
        if (currentAuthors > 0) {
            for (int i = 0; i < currentAuthors; i++) {
                sb.append(authors[i]);
                if (i < currentAuthors - 1) {
                    sb.append(", ");
                }
            }
        } else {
            sb.append("None");
        }
        sb.append("\n");
        sb.append("Text: ").append(text.toString());
        return sb.toString();
    }
}
