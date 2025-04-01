package Ex13;

import Ex13.model.ILibrary;
import Ex13.model.LibraryMap;
import Ex13.ui.LibraryUI;

public class MainMap {
    public static void main(String[] args) throws CloneNotSupportedException {
        ILibrary library = new LibraryMap("DEIS-ISEC-List");
        LibraryUI ui = new LibraryUI(library);
        ui.start();
    }
}
