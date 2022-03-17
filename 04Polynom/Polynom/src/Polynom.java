import java.util.Objects;

public class Polynom {
    private int[] coefficients;

    public Polynom() {
    }

    public Polynom(int[] coefficients) {
        this.coefficients = coefficients;
    }

    public int[] getCoefficients() {
        return this.coefficients;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Polynom)) {
            return false;
        }
        Polynom polynom = (Polynom) o;
        return Objects.equals(coefficients, polynom.coefficients);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(coefficients);
    }

    @Override
    public String toString() {
        return "{" +
                " coefficients='" + getCoefficients() + "'" +
                "}";
    }

}
