package EN2324.model;

import java.util.Comparator;

public class Carro {
    protected String descricao;
    protected String matricula;
    protected tipoMotor motor;
    protected int nrKm;
    protected int potencia;

    public Carro(String descricao, String matricula, tipoMotor motor, int nrKm, int potencia) {
        if (!validarMatricula(matricula)) {
            throw new IllegalArgumentException("Matrícula inválida. O formato deve ser 'PAdddd', onde 'dddd' é um número de até 4 dígitos.");
        }
        this.descricao = descricao;
        this.matricula = matricula;
        this.motor = motor;
        this.nrKm = nrKm;
        this.potencia = potencia;
    }

    //validarMatricula - Done by Deepseek
    private boolean validarMatricula(String matricula) {
        // Verifica se a matrícula tem exatamente 6 caracteres
        if (matricula == null || matricula.length() != 6) {
            return false;
        }

        // Verifica se os dois primeiros caracteres são "PA"
        if (!matricula.startsWith("PA")) {
            return false;
        }

        // Verifica se os últimos 4 caracteres são dígitos
        String parteNumerica = matricula.substring(2);
        try {
            Integer.parseInt(parteNumerica);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return String.format("%s\nMatricula: %s\nMotor: %s\nNumero Km: %d\nPotencia: %d",
                descricao, matricula, motor, nrKm, potencia);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (other == null || other.getClass() != this.getClass())
            return false;

        Carro o = (Carro) other;

        if (!this.motor.equals(o.motor))
            return false;

        int maxKm = Math.max(this.nrKm, o.nrKm);
        int diffKm = Math.abs(this.nrKm - o.nrKm);
        if (diffKm > 0.2 * maxKm)
            return false;

        int maxPotencia = Math.max(this.potencia, o.potencia);
        int diffPotencia = Math.abs(this.potencia - o.potencia);
        if (diffPotencia > 0.2 * maxPotencia)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = motor != null ? motor.hashCode() : 0;
        result = 31 * result + nrKm;
        result = 31 * result + potencia;
        return result;
    }
}

class CarroComparator implements Comparator<Carro> {

    @Override
    public int compare(Carro o1, Carro o2) {
        return Integer.compare(o1.potencia, o2.potencia);
    }
}