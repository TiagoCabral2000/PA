package Ex19.model;

import java.util.List;

public class OldBook extends Book{
    private int nrCopies;

    public OldBook(String title, List<String> authors, int nrCopies){
        super(title, authors);
        this.nrCopies = nrCopies;
    }

    public int getnCopies(){
        return nrCopies;
    }

    public boolean setnCopies(int nrCopies){
        if (nrCopies < 0)
            return false;
        this.nrCopies = nrCopies;
        return true;
    }

    @Override
    public String toString(){
        return "-OldBook- " + super.toString() + ", #NrCopies = " + nrCopies;
    }


}
