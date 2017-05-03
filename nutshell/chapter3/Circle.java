package nutshell.chapter3;

/**
 * Created by eric on 5/1/17.
 */
public class Circle {
    public static final double PI = Math.PI;
    protected double r;
    Circle(){
        this(1.0);
    }
    Circle(double r){
        this.r = r;
    }
    public double getArea(){
        return r*r*PI;
    }
}
