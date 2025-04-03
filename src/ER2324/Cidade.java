package ER2324;

import java.util.HashSet;
import java.util.Set;

public class Cidade {
    Set<Local> locais;
    Set<Rua> ruas;
    public Cidade() {
        ruas = new HashSet<>();
        locais = new HashSet<>();
    }
/*
    i. Se a rua a adicionar for definida por algum local considerado igual a outro já
    existente no conjunto locais, então deverá ser alterada para usar as coordenadas já armazenadas;

    ii. Se os locais de definem a nova rua não estiverem ainda no conjunto locais
    então deverão ser adicionados a esse conjunto;

    iii. Se a rua a inserir já existir no conjunto de ruas então não deverá ser adicionada, mas se
    for do tipo RuaTuristica, então os eventuais novos pontos de interesse que existem na nova
    definição de rua deverão ser adicionados aos pontos de interesse já existentes na rua armazenada.
*/
    public boolean addRua(Rua rua) {
       Local l1 = checkLocal(rua.l1);
       Local l2 = checkLocal(rua.l2);

       Rua ruaNormalized = normalizaRua(rua, l1, l2);

       for (Rua existente:ruas){
           if (existente.equals(rua)){
               if (existente instanceof RuaTuristica ruaTuristica && ruaNormalized instanceof RuaTuristica ruaTuristicaExistente) {
                   for (String ptsInt : ruaTuristica.getPontosInteresse())
                       ruaTuristicaExistente.adicionaPontoInteresse(ptsInt);
               }
               return false;
           }
       }
       ruas.add(ruaNormalized);
       return true;
    }

    public Local checkLocal(Local l){
        for (Local local:locais) {
            if (local.equals(l))
                return local;
        }
        locais.add(l);
        return l;
    }

    public Rua normalizaRua(Rua rua, Local l1, Local l2){
        if (rua instanceof RuaTuristica rt)
            return new RuaTuristica(rt.l1, rt.l2, rt.getPontosInteresse().toArray(new String[0]));
        return new Rua(l1,l2);
    }

}
