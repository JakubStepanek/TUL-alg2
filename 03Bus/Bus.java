import java.util.Objects;

public class Bus {
    private int countOfSeats;
    private int lineNumber;
    private String company;
    private int onBoardPassengers;

    public Bus() {
        this.countOfSeats = 40;
    }

    public Bus(int countOfSeats, int lineNumber, String company) {
        this.countOfSeats = countOfSeats;
        this.lineNumber = lineNumber;
        this.company = company;
        this.onBoardPassengers = 0;
    }

    public int getCountOfSeats() {
        return this.countOfSeats;
    }

    public void setCountOfSeats(int countOfSeats) {
        this.countOfSeats = countOfSeats;
    }

    public int getLineNumber() {
        return this.lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getCompany() {
        return this.company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getOnBoardPassengers() {
        return this.onBoardPassengers;
    }

    public void setOnBoardPassengers(int onBoardPassengers) {
        this.onBoardPassengers = onBoardPassengers;
    }

    @Override
    public String toString() {
        return "Autobus číslo " + getLineNumber() + " společnosti " + getCompany() + " s počtem sedadel "
                + getCountOfSeats() + " veze " + getOnBoardPassengers() + " cestujících";
    }

    public void getAllOffBus() {
        this.onBoardPassengers = 0;
    }

    public void getOffBus(int nPassengers) {
        if (nPassengers < 0) {
            throw new IllegalArgumentException("Nástup možný pouze předními dveřmi.");
        }
        if (this.onBoardPassengers < nPassengers) {
            System.out.println("Vystoupit mohlo pouze: " + (this.onBoardPassengers));
            this.onBoardPassengers -= this.onBoardPassengers;
        } else {
            this.onBoardPassengers -= nPassengers;
        }
    }

    public void getOnBus(int nPassengers) {
        if (nPassengers < 0) {
            throw new IllegalArgumentException("Nástup možný od 0 osob.");
        }
        if ((nPassengers + this.onBoardPassengers) > this.countOfSeats) {
            System.out.println("Nastoupit mohlo pouze " + (this.countOfSeats - this.onBoardPassengers));
            this.onBoardPassengers += this.countOfSeats - this.onBoardPassengers;
        } else {
            this.onBoardPassengers += nPassengers;
        }
    }
}
