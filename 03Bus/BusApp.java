import java.util.Scanner;

public class BusApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nStops = 5;
        Bus firstBus = new Bus(41, 15, "DPMLJ");

        for (int i = 1; i < nStops; i++) {
            System.out.println(i + ". zastávka" + (i == nStops ? " konečná." : ""));
            System.out.println(firstBus);
            System.out.println("Zadej kolik lidí chce vystoupit a kolik nastoupit:");
            firstBus.getOffBus(sc.nextInt());
            firstBus.getOnBus(sc.nextInt());
            System.out.println(firstBus);
            System.out.println();
        }
        System.out.println(nStops + ". zastávka. konečná.");
        System.out.println(firstBus);
        System.out.println();
        firstBus.getAllOffBus();
        System.out.println(firstBus);
    }

}
