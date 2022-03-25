import javax.swing.plaf.synth.SynthSeparatorUI;

public class Kalendar {
    private final int createdDay;
    private final int createdMonth;
    private final int createdYear;

    private int day;
    private int month;
    private int year;

    private int[] nDaysInMonth = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    private static String[] daysInWeek = { "PO", "ÚT", "ST", "ČT", "PÁ", "SO", "NE" };
    private String[] monthsInYear = { "", "Leden", "Únor", "Březen", "Duben", "Květen", "Červen", "Červenec", "Srpen",
            "Září", "Říjen", "Listopad", "Prosinec", "Leden", "Únor" };

    private Kalendar(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.createdDay = day;
        this.createdMonth = month;
        this.createdYear = year;
        nDaysInMonth[2] = isLeap(year) ? 29 : 28;
    }

    public Kalendar getInstance(int day, int month, int year) {
        return new Kalendar(day, month, year);
    }

    public int getDayInWeek() {
        return getDayInWeek(1, this.month, this.year);
    }

    public static int getDayInWeek(int day, int month, int year) {
        int K = year % 100;
        int J = year / 100;
        int h = (day + (13 * (month + 1)) / 5 + K + (K / 4) + (J / 4) - 2 * J) % 7;
        return ((h + 5) % 7) + 1;
    }

    public void nextMonth() {
        if (this.month == 12) {
            this.year++;
            this.month = 1;
            this.nDaysInMonth[2] = isLeap(this.year) ? 29 : 28;
        } else {
            this.month++;
        }
    }

    public void previousMonth() {
        if (this.month == 1) {
            this.year--;
            this.month = 12;
            this.nDaysInMonth[2] = isLeap(this.year) ? 29 : 28;
        } else {
            this.month--;
        }

    }

    public boolean isLeap(int year) {
        return (year % 4 == 0) ? (year % 400 == 0) ? true : (year % 100 != 0) : false;
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0) ? (year % 400 == 0) ? true : (year % 100 != 0) : false;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        // display header
        sb.append(String.format("%s %d%n", monthsInYear[month], year));

        // display days of week
        for (String weekDay : daysInWeek) {
            sb.append(String.format("%s  ", weekDay));
        }
        sb.append(System.getProperty("line.separator"));

        // Display the days

        // empty fields
        int beginDayInWeek = getDayInWeek();
        for (int day = 1; day < beginDayInWeek; day++) {
            sb.append("    ");
        }

        // day number fields
        for (int day = 1; day <= nDaysInMonth[month]; day++) {

            boolean isToday = (month == this.createdMonth && day == this.day);
            if (isToday) { // Colorize the field if today
                sb.append(ConsoleColors.WHITE);
                sb.append(ConsoleColors.RED_BACKGROUND);
                sb.append(String.format("%2d", day));
                sb.append(ConsoleColors.RESET);
                sb.append("  ");
            } else { // or print it without colorizing
                sb.append(String.format("%2d  ", day));
            }

            // add newline if the week ends
            if ((day + beginDayInWeek - 1) % 7 == 0) {
                sb.append(System.getProperty("line.separator"));
            }
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        Kalendar kl = new Kalendar(25, 5, 2022);
        System.out.println(kl);
    }
}
