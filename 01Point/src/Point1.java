import java.util.Objects;

public class Point1 {
    private double x;
    private double y;
    private double[] coord = new double[2];

    public Point1() {
    }

    public Point1(double x, double y) {
        this.coord[0] = x;
        this.coord[1] = y;
    }

    public double getX() {
        return this.coord[0];
    }

    public void setX(double x) {
        this.coord[0] = x;
    }

    public double getY() {
        return this.coord[1];
    }

    public void setY(double y) {
        this.coord[1] = y;
    }

    public Point1 x(double x) {
        setX(x);
        return this;
    }

    public Point1 y(double y) {
        setY(y);
        return this;
    }

    public double distanceFrom() {
        return Math.hypot(coord[0], coord[1]);
    }

    public static double distanceBetween(Point1 p1, Point1 p2) {
        return Math.hypot(p1.getX() - p2.getX(), p1.getY() - p2.getY());
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Point1)) {
            return false;
        }
        Point1 point1 = (Point1) o;
        return x == point1.x && y == point1.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "{" +
                " x='" + getX() + "'" +
                ", y='" + getY() + "'" +
                "}";
    }

}
