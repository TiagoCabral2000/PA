package Ex5;

public class Aposta {
    private int aposta[];
    private int numSorte;
    private int numsPreenchidos;

    Aposta(){
        aposta = new int[5];
        numsPreenchidos = 0;
        numSorte = 0;
    }

    public boolean addNumero(int num, boolean flag){
        if (flag){ //true - numeros da aposta | false - numSorte
            if (num < 1 || num > 49 || numsPreenchidos == 5)
                return false;
            for (int i = 0; i < numsPreenchidos; i++){
                if (aposta[i] == num)
                    return false;
            }
            aposta[numsPreenchidos++] = num;
            return true;
        }
        else{
            if (num < 1 || num > 13 || numSorte != 0)
                return false;
            numSorte = num;
            return true;
        }
    }

    public boolean isComplete(){
        return  (numsPreenchidos == 5 && numSorte != 0);
    }

    public void preencheAposta(){
        while(numsPreenchidos < 5)
            addNumero((int)(Math.random()*50), true);

        while(numSorte == 0)
            addNumero((int)(Math.random()*14), false);
    }

    public void showAposta(){
        System.out.print("Numeros: ");
        for (int i = 0; i < aposta.length; i++){
            if (i != 0)
                System.out.print(", ");
            System.out.print(aposta[i]);
        }
        System.out.println("\nNumero da Sorte: " + numSorte);
    }

    public void comparaAposta(int []chave, int numeroSorte){
        int numCertos = 0;

        for (int i = 0; i < chave.length; i++){
            for (int j = 0; j < aposta.length; j++){
                if (chave[i] == aposta[j])
                    numCertos++;
            }
        }
        if (numCertos == 5 && numSorte == numeroSorte) {
            System.out.println("\nAposta certa");
        }
        System.out.println("\nAposta incorreta!");
        System.out.println("Numeros certos: " + numCertos + ", Numero da Sorte: " + (numeroSorte == numSorte? "Certo" : "Errado"));
    }

    public void reset(){
        for (int i = 0; i <  numsPreenchidos; i++)
            aposta[i] = 0;
        numSorte = 0;
        numsPreenchidos = 0;
    }

}
