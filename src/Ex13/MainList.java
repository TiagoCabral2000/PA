package Ex13;

import Ex13.model.ILibrary;
import Ex13.model.LibraryList;
import Ex13.ui.LibraryUI;

public class MainList {
    public static void main(String[] args) throws CloneNotSupportedException {
        ILibrary library = new LibraryList("DEIS-ISEC-List");
        LibraryUI ui = new LibraryUI(library);
        ui.start();
    }
}
