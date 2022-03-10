/**
 * PointTest
 */
public class PointTest {
    public static void main(String[] args) {
        // Point myPoint = new Point();
        // System.out.println(myPoint);
        // Point yourPoint = new Point(2, 3);
        // Point pythPoint = new Point(3, 4);
        // pythPoint.setX(18);

        // System.out.println(yourPoint);

        // System.out.println(myPoint.distanceFromOrigin());
        // System.out.println(yourPoint.distanceFromOrigin());
        // System.out.println(pythPoint.distanceFromOrigin());
        // System.out.println(myPoint.distanceFrom(pythPoint));
        // System.out.println(pythPoint.getX());
        // System.out.println(pythPoint.getY());

        // Point1

        Point1 myPoint2 = new Point1(2, 3);
        Point1 myPoint1 = new Point1(1, 2);

        myPoint1.setX(16);// volání nestatických metod
        Point1.distanceBetween(myPoint1, myPoint2);// volání statických metod
    }

}
