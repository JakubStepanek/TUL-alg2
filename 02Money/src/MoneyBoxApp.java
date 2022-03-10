public class MoneyBoxApp {
    public static void main(String[] args) {
        MoneyBox alice = new MoneyBox("Alice", 100, 10);
        MoneyBox bob = new MoneyBox("Bob");
        bob.insertOneCrown(2);
        bob.insertTwoCrown(3);
        bob.insertCash(5, 10);

        System.out.println(alice.getName() + " má v pokladničce: " + alice.getSum());
        System.out.println(bob.getName() + " má v pokladničce: " + bob.getSum());

        System.out.println(alice.enoughCashFor(39));
        System.out.println("Bob si " + (bob.enoughCashFor(39) ? "" : "ne") + "koupí hambáč.");
        System.out.println("Alice si " + (alice.enoughCashFor(39) ? "" : "ne") + "koupí hambáč.");

        System.out.println((alice.getSum() < bob.getSum() ? "Bob" : "Alice") + " má více peněz");

        System.out.println();
        System.out.println("Přepis penízků na ALICI!");
        // bob.setName("Alice");
        // System.out.println(alice);
        // System.out.println(bob);

        MoneyBox.moneyTransfer(alice, bob, 5, 2);
        System.out.println(alice);
        System.out.println(bob);

    }

}
