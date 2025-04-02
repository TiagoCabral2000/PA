package EN2324.model;

public class Anfibio extends Carro {
    private int milhasMaritimas;

    public Anfibio(String descricao, String matricula, tipoMotor motor, int nrKm, int potencia, int milhasMaritimas) {
        super(descricao, matricula, motor, nrKm, potencia);
        this.milhasMaritimas = milhasMaritimas;
    }

    private double milhasToKm() {
        return milhasMaritimas * 1.852;
    }

    private double getTotalDistance() {
        return nrKm + milhasToKm();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;

        Anfibio o = (Anfibio) other;

        if (!this.motor.equals(o.motor))
            return false;

        double totalDistanceThis = this.getTotalDistance();
        double totalDistanceOther = o.getTotalDistance();
        double maxDistance = Math.max(totalDistanceThis, totalDistanceOther);
        double diffDistance = Math.abs(totalDistanceThis - totalDistanceOther);

        if (diffDistance > 0.2 * maxDistance) return false;

        int maxPotencia = Math.max(this.potencia, o.potencia);
        int diffPotencia = Math.abs(this.potencia - o.potencia);
        if (diffPotencia > 0.2 * maxPotencia) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + milhasMaritimas;
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + "\nMilhas Maritimas: " + milhasMaritimas;
    }
}