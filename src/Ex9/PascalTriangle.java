package Ex9;

public class PascalTriangle {
    //The numbers which we get in each step are the addition of the above two numbers
    int pt[][];

    //pt[x][y] = pt[x-1][y] + pt[x-1][y-1];
    //each row has rowNumber+1 elements

    public PascalTriangle(int depth){
        pt = new int[depth][];

        for (int i = 0; i < depth; i++){
            pt[i] = new int[i + 1];
            for (int j = 0; j <= i; j++){
                if (j == 0 || j == i)
                    pt[i][j] = 1;
                else{
                    pt[i][j] = pt[i-1][j] + pt[i-1][j-1];
                }
            }
        }
    }

    public void show(boolean val){
        if (val == false){
            for(int i = 0; i < pt.length; i++){
                for (int j = 0; j < pt[i].length; j++)
                    System.out.print(pt[i][j] + " ");
                System.out.println();
            }
        }
        else {
            int lastRow = pt.length - 1;
            int middleIndex = pt[lastRow].length / 2;
            int maxNumber = pt[lastRow][middleIndex]; // Largest number in the triangle
            int maxDigits = String.valueOf(maxNumber).length(); // Number of digits in the largest number

            // Print the triangle centered
            for (int i = 0; i < pt.length; i++) {
                int leadingSpaces = (pt[lastRow].length - pt[i].length) * (maxDigits + 1) / 2;

                // Print leading spaces
                for (int s = 0; s < leadingSpaces; s++) {
                    System.out.print(" ");
                }

                // Print numbers in the current row
                for (int j = 0; j < pt[i].length; j++) {
                    System.out.printf("%" + (maxDigits + 1) + "d", pt[i][j]);
                }
                System.out.println();
            }
        }
    }

}

