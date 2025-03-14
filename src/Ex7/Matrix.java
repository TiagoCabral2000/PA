package Ex7;

public class Matrix {
    private float[][] m;

    public Matrix(int r, int c){
        m = new float[r][c];
    }

    public Matrix(Matrix other){
        this(other.m.length, other.m[0].length);
        for (int i = 0; i < m.length; i++){
            for (int j = 0; j < m[0].length; j++){
                m[i][j] = other.m[i][j];
            }
        }
        /*
        2.
        this(other.m.length, other.m[0].length);
        for (int r = 0; r < m.length; r++) {
            System.arraycopy(other.m[r], 0, //origem
                    m[r], 0, //destino
                    other.m[r].length //qtd de elementos
            );
        }
        3.
        m = new float[other.m.length][]; //criar um array de suporte a cada uma das linhas. o copyof e q me vai copiar o numero de elementos do original
        for (int r = 0; r < m.length; r++) {
            m[r] = Arrays.copyOf(other.m[r], other.m[r].length);
        }
        */
    }

    public void generate(){
        for (int i = 0; i < m.length; i++){
            for (int j = 0; j < m[0].length; j++){
                m[i][j] = (float) Math.random()*101;
            }
        }
    }

    public void show(){
        for (int i = 0; i < m.length; i++){
            for (int j = 0; j < m[0].length; j++){
                System.out.printf("%10.5f ", m[i][j]);
            }
            System.out.println();
        }
    }

    public float get(int r, int c){
        return m[r][c];
    }
    public boolean set(int r, int c, float value){
        if (r < 0 || c < 0)
            return false;
        m[r][c] = value;
        return true;
    }

    public boolean add(Matrix other){
        if(m.length != other.m.length || m[0].length != other.m[0].length)
            return false;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                m[i][j] += other.m[i][j];
            }
        }
        return true;
    }

    public static Matrix add(Matrix m1, Matrix m2){
        Matrix m3 = new Matrix(m1);
        if (!m3.add(m2))
            return null;
        return m3;
    }

}
