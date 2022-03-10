
public class Point {
    // data, členské proměnné, instanční proměnné, atributy, fields
    private double x;
    private double y;

    // metody

    // konstruktor defaultní
    public Point() {
        this(0.0, 0.0);// volání přetíženého konstruktora, musí být na prvním řádku
        // x = 0.0;
        // y = 0.0;
    }

    // přetížený konstruktor
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }
    public void setX(int x){
        if(x < 0){
            throw new IllegalArgumentException("nelze zadat záporné číslo!");
        }
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public double distanceFromOrigin() {
        // return Math.sqrt(Math.pow(x - 0, 2) + Math.pow(y - 0, 2));
        return distanceFromPoint(0, 0);
    }

    public double distanceFrom(Point p) {
        // return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
        return distanceFromPoint(p.x, p.y);
    }

    public double distanceFromPoint(double x, double y) {
        // return Math.sqrt(Math.pow(this.x-x, 2) + Math.pow(this.y-y, 2));
        return Math.hypot(this.x - x, this.y - y);
    }

    // [2.00,3.00]
    @Override // překrytí metody
    public String toString() {
        return String.format("[%.2f, %.2f]", x, y);
    }
}