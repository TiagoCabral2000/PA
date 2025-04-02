package EN2324.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Stand {
    private Set<Carro> carros;
    private String nome;

    public Stand(String nome){
        this.nome = nome;
        carros = new HashSet<>();
    }

    public boolean adicionaCarro(String descricao, String matricula, tipoMotor motor, int nrKm, int potencia){
        for (Carro carro:carros){
            if (carro.matricula.equals(matricula))
                return false;
        }
        return carros.add(new Carro(descricao,matricula, motor, nrKm,potencia));
    }

    public boolean adicionaAnfibio(String descricao, String matricula, tipoMotor motor, int nrKm, int potencia, int milhasMaritimas){
        for (Carro carro:carros){
            if (carro.matricula.equals(matricula))
                return false;
        }
        return carros.add(new Anfibio(descricao,matricula, motor, nrKm,potencia, milhasMaritimas));
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder(String.format("Stand %s:\n---------------------------\n", nome));
        if (carros == null || carros.isEmpty())
            sb.append("Stand is empty!\n");
        else{
            List<Carro> orderList = new ArrayList<>(carros);
            orderList.sort(new CarroComparator());
            for (Carro carro : orderList)
                sb.append(String.format("- %s\n---------------------------\n", carro));
        }
        return sb.toString();
    }

}
