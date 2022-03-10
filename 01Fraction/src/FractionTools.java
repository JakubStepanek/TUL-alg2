
public final class FractionTools {
    private FractionTools() {

    }

    public static Fraction sumOfFraction(Fraction first, Fraction second) {
        int resultNumerator;
        int resultDenominator;
        if (first.getDenominator() == second.getDenominator()) {
            resultNumerator = first.getNumerator() + second.getNumerator();
            resultDenominator = first.getDenominator();
        } else {
            resultDenominator = lcm(first.getDenominator(), second.getDenominator());
            resultNumerator = resultDenominator / first.getDenominator() * first.getNumerator()
                    + resultDenominator / second.getDenominator() * second.getNumerator();
        }
        return new Fraction(resultNumerator, resultDenominator);
    }

    public static Fraction difOfFraction(Fraction first, Fraction second) {
        int resultNumerator;
        int resultDenominator;
        if (first.getDenominator() == second.getDenominator()) {
            resultNumerator = first.getNumerator() - second.getNumerator();
            resultDenominator = first.getDenominator();
        } else {
            resultDenominator = lcm(first.getDenominator(), second.getDenominator());
            resultNumerator = resultDenominator / first.getDenominator() * first.getNumerator()
                    - resultDenominator / second.getDenominator() * second.getNumerator();
        }
        return new Fraction(resultNumerator, resultDenominator);
    }

    public static Fraction multiplyOfFraction(Fraction first, Fraction second) {
        int resultNumerator;
        int resultDenominator;
        resultNumerator = first.getNumerator() * second.getNumerator();
        resultDenominator = first.getDenominator() * second.getDenominator();
        return new Fraction(resultNumerator, resultDenominator);
    }

    public static Fraction divisionOfFraction(Fraction first, Fraction second) {
        int resultNumerator;
        int resultDenominator;
        resultNumerator = first.getNumerator() * second.getDenominator();
        resultDenominator = first.getDenominator() * second.getNumerator();
        return new Fraction(resultNumerator, resultDenominator);
    }

    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }
}
