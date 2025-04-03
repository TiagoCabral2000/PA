package ER2324;

public record Local(double lat, double lon) {
    public static final int PROXIMO = 50; // em metros
    public static double distancia(Local l1, Local l2) throws IllegalArgumentException {
        // retorna distancia em metros ou gera excepção se dados inválidos
        //... (assuma que a função está devidamente implementada) ...
        return 0;
    }

   //a) Defina os métodos equals e hashCode no record Local de modo que dois locais sejam
    // considerados iguais se a distância entre estes for inferior a 50m (PROXIMO).
    @Override
    public boolean equals(Object other){
        if (other == this)
            return true;

        if (other == null || other.getClass() != this.getClass())
            return false;

        Local l = (Local) other;
        return distancia(this, l) < 50;
    }

    @Override
    public int hashCode(){
        return (int)(lat + lon);
    }

}
