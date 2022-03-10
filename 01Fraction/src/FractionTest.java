public class FractionTest {
    public static void main(String[] args) {
        Fraction oneNumbeFraction = new Fraction(12);
        Fraction stringFraction = new Fraction("0");
        Fraction string2Fraction = new Fraction("-3 5");
        Fraction string3Fraction = new Fraction("-169/435");
        Fraction bothNumbersFraction = new Fraction(12, 24);

        System.out.println("Výpis zlomků v základním tvaru:");
        System.out.println(oneNumbeFraction.toString());
        System.out.println(stringFraction.toString());
        System.out.println(string2Fraction.toString());
        System.out.println(string3Fraction.toString());
        System.out.println(bothNumbersFraction.toString());
        System.out.println();
        System.out.println("Výpis hodnot v double:");
        System.out.println(string2Fraction.getValueOf());
        System.out.println();

        System.out.println(FractionTools.sumOfFraction(stringFraction,string2Fraction));
        System.out.println(FractionTools.difOfFraction(stringFraction,string2Fraction));

        System.out.println(FractionTools.multiplyOfFraction(stringFraction, string2Fraction));
        System.out.println(FractionTools.divisionOfFraction(stringFraction, string2Fraction));

        System.out.println(string3Fraction.getValueOf());
        
    }

}
