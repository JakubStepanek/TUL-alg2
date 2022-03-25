public class Kalendar {
    private final int createdDay;
    private final int createdMonth;
    private final int createdYear;

    private int day;
    private int month;
    private int year;

    private int[] nDaysInMonth = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    private String[] DaysInWeek = { "", "PO", "ÚT", "ST", "ČT", "PÁ", "SO", "NE" };
    private String[] MonthsInYear = { "", "Leden", "Únor", "Březen", "Duben", "Květen", "Červen", "Červenec", "Srpen",
            "Září", "Říjen", "Listopad", "Prosinec" };

    private Kalendar(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.createdDay = day;
        this.createdMonth = month;
        this.createdYear = year;
    }

    public getInstance(int day, int month, int year){
        Kalendar(day, month, year);
    }

    public int findDayInWeek(int day, int month, int year) {
        return 0;
    }

    @Override
    public String toString() {
        return "";
    }

}
