package ER2324;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RuaTuristica extends Rua{
    private Set<String> ptsInteresse;

    public RuaTuristica(Local l1, Local l2, String... pontosInteresse){
        super(l1,l2);

        for (String ponto: pontosInteresse){
            adicionaPontoInteresse(ponto);
        }
    }

    public List<String> getPontosInteresse(){
        return List.copyOf(ptsInteresse);
    }

    public boolean adicionaPontoInteresse(String ponto){
        String novoPonto = ponto.toLowerCase();
        return ptsInteresse.add(ponto);
    }

}
