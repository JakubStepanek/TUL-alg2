public abstract class Shape {
    protected String name = "Geometric shape";

    public String getName(){
        return this.getClass().getSimpleName();
    }


    public double area(){
        return 0;
    }
}
