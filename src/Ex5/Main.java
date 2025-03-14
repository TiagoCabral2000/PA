package Ex5;

public class Main {
    public static void main(String[] args) {
        Aposta a1 = new Aposta();
        a1.preencheAposta();
        a1.showAposta();

        int chave[] = {3, 32, 26, 17, 16};
        int numeroSorte = 10;
        a1.comparaAposta(chave, numeroSorte);
    }
}
