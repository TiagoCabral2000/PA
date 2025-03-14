package Ex9;

public class Main {
    public static void main(String[] args) {
        PascalTriangle pt = new PascalTriangle(5);
        pt.show(false);
        System.out.println("-".repeat(10));
        pt.show(true);
    }
}