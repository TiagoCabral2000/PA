package EN2324;

import EN2324.model.Stand;
import EN2324.model.tipoMotor;

public class Main {
    public static void main(String[] args) {
        Stand a = new Stand("Stand AHHHHH");
        a.adicionaCarro("Opel Corsa", "PA3476", tipoMotor.GASOLINA, 200348 , 80);
        a.adicionaAnfibio("Tralalero Tralala", "PA1267", tipoMotor.HIBRIDO, 3677 , 50, 333);
        a.adicionaCarro("Ferrari F50", "PA7432", tipoMotor.GASOLINA, 128 , 500);

        System.out.println(a);
    }
}
