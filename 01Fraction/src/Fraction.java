
public class Fraction {
    private int numerator; // čitatel
    private int denominator; // jmenovatel

    public Fraction(int numerator) {
        //this(numerator, 1);
        denominator = 1;
        this.numerator = numerator / FractionTools.gcd(numerator, denominator);
        this.denominator = 1;
    }

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Jmenovatel nesmí být nula!");
        }
        this.numerator = numerator / FractionTools.gcd(numerator, denominator);
        this.denominator = denominator / FractionTools.gcd(numerator, denominator);
    }

    public Fraction(String input) {
        int numerator; 
        int denominator;
        String delims = "[ /]";
        String[] tokens = input.split(delims);
        if (input.contains("/") || input.contains(" ")) {
            // TODO
            // tokens[0].replaceAll("\\s+", "");
            // tokens[2].replaceAll("\\s+", "");
            numerator = Integer.parseInt(tokens[0]);
            denominator = Integer.parseInt(tokens[1]);
        } else {
            numerator = Integer.parseInt(tokens[0]);
            denominator = 1;
        }
        if (denominator == 0) {
            throw new IllegalArgumentException("Jmenovatel nesmí být nula!");
        }
        this.numerator = numerator / FractionTools.gcd(numerator, denominator);
        this.denominator = denominator / FractionTools.gcd(numerator, denominator);
    }

    public double getValueOf() {
        return (double) numerator / denominator;
    }

    public int getNumerator() {
        return this.numerator;
    }

    public int getDenominator() {
        return this.denominator;
    }

    public String toString() {
        if (this.denominator < 0) {
            return String.format("%d/%d", -this.numerator, -this.denominator);
        }
        if (this.denominator == 1) {
            return String.valueOf(this.numerator);
        } else {
            return String.format("%d/%d", this.numerator, this.denominator);
        }
    }
}
