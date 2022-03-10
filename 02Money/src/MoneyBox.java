import java.util.Objects;

public class MoneyBox {
    private String name;
    private int oneCrown; // nOneCrowns
    private int twoCrowns; // nTwoCrowns

    public MoneyBox() {
    }

    public MoneyBox(String name, int oneCrown, int twoCrowns) {
        this.name = name;
        this.oneCrown = oneCrown;
        this.twoCrowns = twoCrowns;
    }

    public MoneyBox(String name) {
        this.name = name;
        this.oneCrown = 0;
        this.twoCrowns = 0;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOneCrown() {
        return this.oneCrown;
    }

    public void setOneCrown(int oneCrown) {
        this.oneCrown = oneCrown;
    }

    public int gettwoCrowns() {
        return this.twoCrowns;
    }

    public void settwoCrowns(int twoCrowns) {
        this.twoCrowns = twoCrowns;
    }

    public MoneyBox name(String name) {
        setName(name);
        return this;
    }

    public MoneyBox oneCrown(int oneCrown) {
        setOneCrown(oneCrown);
        return this;
    }

    public MoneyBox twoCrowns(int twoCrowns) {
        settwoCrowns(twoCrowns);
        return this;
    }

    public void insertOneCrown() {
        this.oneCrown += 1;
    }

    public void insertOneCrown(int sum) {
        this.oneCrown += 1 * sum;
    }

    public void insertTwoCrown() {
        this.twoCrowns += 1;
    }

    public void insertTwoCrown(int sum) {
        this.twoCrowns += 1 * sum;
    }

    public void insertCash(int oneCrownCount, int twoCrownsCount) {
        this.oneCrown += oneCrownCount;
        this.twoCrowns += twoCrownsCount;
    }

    public int getSum() {
        return this.oneCrown + this.twoCrowns * 2;
    }

    public boolean enoughCashFor(int price) {
        return (price <= getSum());
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof MoneyBox)) {
            return false;
        }
        MoneyBox moneyBox = (MoneyBox) o;
        return Objects.equals(name, moneyBox.name) && oneCrown == moneyBox.oneCrown && twoCrowns == moneyBox.twoCrowns;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, oneCrown, twoCrowns);
    }

    @Override
    public String toString() {
        return getName() + " má v pokladničce " + getSum() + "Kč - " + getOneCrown() + "x1Kč, " + gettwoCrowns()
                + "x2Kč.";
    }

    public void moneyTransfer(MoneyBox where, int oneCrown, int twoCrowns) {
        if (this.oneCrown < oneCrown || this.twoCrowns < twoCrowns) {
            throw new IllegalArgumentException("Nedostatek peněz v pokladničce!");
        }
        if (where == null) {
            throw new IllegalArgumentException("Účet neexistuje!");
        }
        where.insertOneCrown(oneCrown);
        where.insertTwoCrown(twoCrowns);
        this.insertCash(-oneCrown, -twoCrowns);
    }

    public static void moneyTransfer(MoneyBox from, MoneyBox to, int oneCrown, int twoCrowns) {
        if (to == null || from == null) {
            throw new IllegalArgumentException("Účet neexistuje!");
        }
        if (from.getOneCrown() < oneCrown || from.gettwoCrowns() < twoCrowns) {
            throw new IllegalArgumentException("Nedostatek peněz v pokladničce!");
        }
        to.insertOneCrown(oneCrown);
        to.insertTwoCrown(twoCrowns);
        from.insertCash(-oneCrown, -twoCrowns);
    }

}
