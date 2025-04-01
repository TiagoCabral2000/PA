package Ex19;

import Ex19.model.ILibrary;
import Ex19.model.LibraryList;
import Ex19.ui.LibraryUI;

public class MainList {
    public static void main(String[] args) throws CloneNotSupportedException {
        ILibrary library = new LibraryList("DEIS-ISEC-List");
        LibraryUI ui = new LibraryUI(library);
        ui.start();
    }
}
