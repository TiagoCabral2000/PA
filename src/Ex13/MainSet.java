package Ex13;

import Ex13.model.ILibrary;
import Ex13.model.LibrarySet;
import Ex13.ui.LibraryUI;

public class MainSet {
    public static void main(String[] args) throws CloneNotSupportedException {
        ILibrary library = new LibrarySet("My Library");
        LibraryUI ui = new LibraryUI(library);
        ui.start();
    }
}
