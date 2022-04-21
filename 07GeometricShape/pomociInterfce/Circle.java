package pomociInterfce;
public class Circle implements Computable {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }

    @Override
    public String toString() {
        return "{" +
                " radius='" + getRadius() + "'" +
                "}";
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public static void main(String[] args) {
        Circle c = new Circle(20);
        System.out.println(c.area());
    }

}