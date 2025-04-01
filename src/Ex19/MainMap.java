package Ex19;

import Ex19.model.ILibrary;
import Ex19.model.LibraryMap;
import Ex19.ui.LibraryUI;

public class MainMap {
    public static void main(String[] args) throws CloneNotSupportedException {
        ILibrary library = new LibraryMap("DEIS-ISEC-List");
        LibraryUI ui = new LibraryUI(library);
        ui.start();
    }
}
