package ER2324;

public class Rua {
    Local l1, l2;

    public Rua(Local l1, Local l2) {
        if (l1.equals(l2)) {
            throw new IllegalArgumentException("The two locations cannot be equal");
        }
        this.l1 = l1;
        this.l2 = l2;
    }

    @Override
    public boolean equals(Object other){
        if (other == this)
            return true;

        if(!(other instanceof Rua rua))
            return false;

        return (this.l1.equals(rua.l1) && this.l2.equals(rua.l2)) ||
                (this.l1.equals(rua.l2) && this.l2.equals(rua.l1));
    }

    @Override
    public int hashCode(){
        return l1.hashCode() + l2.hashCode();
    }

    public Local getL1() { return l1; }
    public void setL1(Local l1) { this.l1 = l1; }
    public Local getL2() { return l2; }
    public void setL2(Local l2) { this.l2 = l2; }
    @Override
    public String toString() {return "Rua{L1=" + l1 + ", L2=" + l2 + '}';}
}
