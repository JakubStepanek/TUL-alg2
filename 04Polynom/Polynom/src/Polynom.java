import java.util.Arrays;

public class Polynom {
    private final int[] coeff;

    private Polynom(int[] coeff) { // jiz je obraceny, vhodny pro ulozeni
        this.coeff = Arrays.copyOf(coeff, coeff.length);
    }

    public static Polynom getInstanceFromReverted(int[] coeff) {
        return new Polynom(coeff);
    }

    public static Polynom getInstanceFromNonReverted(int[] coeff) {
        int[] temp = new int[coeff.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = coeff[coeff.length - 1 - i];
        }
        return new Polynom(temp);
    }

    public static Polynom getInstanceFromRevertedVararg(int... coeff) {
        return getInstanceFromReverted(coeff);
    }

    public static Polynom getInstanceFromNonRevertedVararg(int... coeff) {
        return getInstanceFromNonReverted(coeff);
    }

    public Polynom(int x0) {
        this.coeff = new int[1];
        this.coeff[0] = x0;
    }

    public Polynom(int x1, int x0) {
        this.coeff = new int[2];
        this.coeff[0] = x0;
        this.coeff[1] = x1;
    }

    public Polynom derivate() {
        int[] der = new int[coeff.length - 1];

        for (int i = 0; i < der.length; i++) {
            der[i] = coeff[i + 1] * (i + 1);
        }
        return Polynom.getInstanceFromReverted(der);
    }

    public int[] getCoeff() {
        return Arrays.copyOf(coeff, coeff.length);
    }

    public int getCoeffAt(int i) {
        return coeff[i];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        for (int i = this.coeff.length - 1; i >= 0; i--) {
            if (this.coeff[i] != 0) {
                sb.append(this.coeff[i]).append("x^").append(i).append(" ");
            }
        }
        return sb.toString();
    }

    public int getDegree() {
        return this.coeff.length - 1;
    }

    public int ValueOf(int x) {
        int temp = coeff[0] + x;
        for (int i = 1; i < coeff.length - 1; i++) {
            temp = temp * (coeff[i] + x);
        }
        return temp;
    }

    public static void main(String[] args) {
        int[] intArray = new int[] { 0, 0, -4, 0, 0, 2 };
        Polynom myPolynom = Polynom.getInstanceFromReverted(intArray);
        System.out.println(myPolynom);
        System.out.println(myPolynom.getDegree());

    }
}
