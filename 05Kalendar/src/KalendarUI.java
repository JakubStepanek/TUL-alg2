import java.util.Scanner;

public class KalendarUI {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Zadej datum: ");
        Kalendar kl = new Kalendar(sc.nextInt(), sc.nextInt(), sc.nextInt());
        // clear buffer
        sc.nextLine();

        boolean end = false;
        String key = "";
        while (!end) {
            System.out.println(kl);
            System.out.println("+ ...další měsíc");
            System.out.println("- ...předchozí měsíc");
            System.out.println("r ...návrat na původní datum měsíc");
            System.out.println("q ...zavřít kalendář");
            key = sc.nextLine();

            switch (key) {
                case "+":
                    kl.nextMonth();
                    break;
                case "-":
                    kl.previousMonth();
                    break;
                case "r":
                    // TODO: Kalendar.today();
                    break;
                case "q":
                    end = true;
                    break;
                default:
                    System.out.println("Neplatná volba!");
                    break;

            }

        }
        System.out.println("kalendář se ukončuje");
    }

}
