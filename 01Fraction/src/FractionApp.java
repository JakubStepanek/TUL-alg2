import java.util.Scanner;

/**
 * FractionApp
 */
public class FractionApp {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean end = false;
        String result;
        do {
            displayMenu();
            System.out.println("Přejete si pokračovat? [a/cokoli]");
            result = sc.nextLine().toLowerCase();
            if (result.equals("a")) {
                end = false;
            } else {
                end = true;
            }
        } while (!end);
    }

    public static void displayMenu() {
        System.out.println("Zadej výraz: ");
        String term = sc.nextLine();
        String[] parts = term.split(" ");
        Fraction firstArticle = new Fraction(parts[0]);
        Fraction secondArticle = new Fraction((parts[2]));
        switch (parts[1]) {
            case "+":
                System.out.println(FractionTools.sumOfFraction(firstArticle, secondArticle));
                break;
            case "-":
                System.out.println(FractionTools.difOfFraction(firstArticle, secondArticle));
                break;
            case "/":
                System.out.println(FractionTools.divisionOfFraction(firstArticle, secondArticle));
                break;
            case "*":
                System.out.println(FractionTools.multiplyOfFraction(firstArticle, secondArticle));
                break;

            default:
                System.out.println("Chybná volba!");
                break;
        }
    }

}