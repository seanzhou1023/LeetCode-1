import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by eric on 3/11/17.
 */
public class T346 {
    public static class MovingAverage{
        Queue<Double> stream;
        int size, cnt;
        double curAvr;
        public MovingAverage(int size){
            stream = new LinkedList<>();
            this.size = size;
            curAvr = 0;
            cnt = 0;
        }
        public double next(int val){
            if(stream.size()<size){
                curAvr = (cnt*curAvr + val)/(++cnt);
            }else{
                double drop = stream.poll();
                curAvr = (curAvr*size-drop+val)/size;
            }
            stream.add((double)val);
            return curAvr;
        }
    }

    public static void main(String[] args) {
        MovingAverage ma = new MovingAverage(5);
        for(int i=0;i<10;i++)
            System.out.println(i+":"+ma.next(i));
    }
}
