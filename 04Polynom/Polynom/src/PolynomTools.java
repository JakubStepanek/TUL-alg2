public final class PolynomTools {

    private PolynomTools() {

    }

    public static Polynom sum(Polynom p1, Polynom p2) {
        return sumAll(p1, p2);
    }

    public static Polynom sumAll(Polynom... polynoms) {
        int newPolynomDegree = max(polynoms);
        int[] newCoefficients = new int[newPolynomDegree];

        int[] polynomCoefficients;
        for (Polynom polynom : polynoms) {
            polynomCoefficients = polynom.getCoeff();

            for (int i = polynom.getDegree() - 1; i >= 0; i--) {
                newCoefficients[i] += polynomCoefficients[i];
            }
        }
        return Polynom.getInstanceFromReverted(newCoefficients);
    }

    private static int max(Polynom... polynoms) {
        int max = Integer.MIN_VALUE;
        for (Polynom polynom : polynoms) {
            if (polynom.getDegree() > max) {
                max = polynom.getDegree();
            }
        }
        return max;
    }

}
