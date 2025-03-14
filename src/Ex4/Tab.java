package Ex4;

public class Tab {
    private final int MAXELEMENTS = 20;
    int[] m;
    int nElements;
    int duplicates;

    Tab(){
        m = new int[MAXELEMENTS];
        nElements = 0;
        duplicates = 0;
    }

    public boolean contains(int number){
        for (int i = 0; i < nElements; i++){
            if (m[i] == number){
                duplicates++;
                return true;
            }
        }
        return false;
    }

    public boolean add(int number){
        if(!contains(number)){
            m[nElements++] = number;
            return true;
        }
        return false;
    }

    public void generate(){
        while (nElements < MAXELEMENTS){
            add((int)(Math.random()*101));
        }
    }

    public void show(){
        System.out.print("[");
        for(int i = 0; i < nElements;i++){
            if(i != 0){
                System.out.print(",");
            }
            System.out.print(m[i]);
        }
        System.out.println("]");
    }

    public void showDuplicates(){
        System.out.println("#Duplicates: " + duplicates);
    }

}
