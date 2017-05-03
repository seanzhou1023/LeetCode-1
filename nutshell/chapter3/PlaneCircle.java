package nutshell.chapter3;
import static java.lang.Math.*;

/**
 * Created by eric on 5/1/17.
 */
public class PlaneCircle extends Circle{
    public final double x, y;
    PlaneCircle(){
        super();
        this.x = 0.0;
        this.y = 0.0;
    }
    PlaneCircle(double r){
        super(r);
        this.x = 0.0;
        this.y = 0.0;
    }
    PlaneCircle(double r, double x, double y){
        super(r);
        this.x = x;
        this.y = y;
    }
    public double distanceTo(PlaneCircle c1){
        return sqrt(pow(this.x-c1.x,2)+pow(this.y-c1.y,2));
    }
    public double getArea(){
        System.out.println("from planecircle");
        return 0.0;
    }
    public String toString(){
        return this.r+":"+this.x+":"+this.y;
    }

    public static void main(String[] args) {
        PlaneCircle c = new PlaneCircle(2,3,4);
        Circle c1 = new PlaneCircle(2,0,2);
        System.out.println(c.getArea());
    }
}
