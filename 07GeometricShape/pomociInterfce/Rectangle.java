package pomociInterfce;
public class Rectangle implements Computable {
    private double height;
    private double width;

    public Rectangle(double height, double width) {
        this.width = width;
        this.height = height;
    }

    public double getHeight() {
        return this.height;
    }

    public double getWidth() {
        return this.width;
    }

    @Override
    public String toString() {
        return "{" +
                " height='" + getHeight() + "'" +
                ", width='" + getWidth() + "'" +
                "}";
    }

    public double calculateArea() {
        return this.width * this.height;
    }

    public static void main(String[] args) {
        Rectangle r = new Rectangle(20, 60);
        System.out.println(r.calculateArea());
    }

    @Override
    public double area() {
        return calculateArea();
    }

}
