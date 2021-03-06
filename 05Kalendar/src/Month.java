

public enum Month {
    JANUARY(1, 31),
    FEBRUARY(2, 28),
    MARCH(3, 31),
    APRIL(4, 30),
    MAY(5, 31),
    JUNE(6, 30),
    JULY(7, 31),
    AUGUST(8, 31),
    SEPTEMBER(9, 30),
    OCTOBER(10, 31),
    NOVEMBER(11, 30),
    DECEMBER(12, 31);

    private int monthNumber;
    private int daysInMonth;

    private Month(int monthNumber, int daysInMonth) {
        this.monthNumber = monthNumber;
        this.daysInMonth = daysInMonth;
    }

    public int getMonthByNumber() {
        return this.monthNumber;
    }

    public int getDaysInMonth() {
        return this.daysInMonth;
    }

    public static Month of(int monthNumber) {
        for (Month m : Month.values()) {
            if (m.getMonthByNumber() == monthNumber) {
                return m;
            }
        }
        return null;
    }


}
