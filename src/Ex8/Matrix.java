package Ex8;

public class Matrix {
    private int[][] m;
    private final int MAX = 9;
    private final int MIN = -9;

    public Matrix(int r, int c){
        m = new int[r][c];

        //Let's generate the matrix already with number between -9 and 9
        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                m[i][j] = (int)(Math.random()* (MAX - MIN + 1)) + MIN;
            }
        }
    }

    public void show(){
        for (int i = 0; i < m.length; i++){
            for (int j = 0; j < m[i].length; j++){
                System.out.printf("%3d", m[i][j]);
            }
            System.out.println();
        }
    }

    public void set(int r, int c, int value){
        m[r][c] = value;
    }

    public void getRowSum(){
        StringBuilder buffer = new StringBuilder("Sum of the rows: ");
        int sum;

        for (int i = 0; i < m.length; i++) {
            sum = 0;
            for (int j = 0; j < m[i].length; j++) {
                sum += m[i][j];
            }
            buffer.append(sum);

            if (i != (m.length - 1)) {
                buffer.append(", ");
            }
        }

        System.out.println(buffer);
    }
    public void getColSum(){
        StringBuilder buffer = new StringBuilder("Sum of the columns: ");
        int sum;

        for (int i = 0; i < m[0].length; i++) {
            sum = 0;
            for (int j = 0; j < m.length; j++) {
                sum += m[j][i];
            }
            buffer.append(sum);

            if (i != (m[0].length - 1)) {
                buffer.append(", ");
            }
        }

        System.out.println(buffer);
    }
    public void getTotalSum(){
        int sum = 0;
        for (int i = 0; i < m.length; i++){
            for (int j = 0; j < m[0].length; j++){
                sum += m[i][j];
            }
        }
        System.out.println("Sum of the entire matrix: " + sum);
    }
}

