import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class App {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int type = 0;
        List<Shape> shapes = new ArrayList<>();
        while ((type =sc.nextInt()) != 0) { // type 1 circle 2 rectangle
            if (type == 1) {
                shapes.add(new Circle(sc.nextDouble()));
            } else {
                shapes.add(new Rectangle(sc.nextDouble(), sc.nextDouble()));
            }
        }

        double area = 0;
        for (Shape shape : shapes){
            area += shape.area();
        }
        System.out.println(area);
    }
}
