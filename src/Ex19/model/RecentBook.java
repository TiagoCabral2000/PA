package Ex19.model;

import java.util.List;

public class RecentBook extends Book{
    private double cost;
    private String ISBN;

    public RecentBook(String title, List<String> authors, double cost, String ISBN){
        super(title, authors);
        this.cost = cost;
        this.ISBN = ISBN;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString(){
        return "-RecentBook- " + super.toString()
                + String.format(", ISBN: %s, Cost: %.2f", ISBN, cost);
    }
}
