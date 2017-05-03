package javapuzzlers;
import java.math.BigDecimal;
/**
 * Created by eric on 5/2/17.
 *
 */
public class Ch01 {
    public static boolean isOdd(int i){
        return i%2==1;//negative odd number may return false;
        //best methods: return (i&1!=0)
    }
    public static void change(){
        System.out.println(2.00-1.10);
    }
    public static void change1(){
        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.10")));
    }
    public static void longDiv(){
        final long MICROS_PER_DAY = 24 * 60 * 60 * 1000 * 1000;
//        final long MICROS_PER_DAY = 24L * 60 * 60 * 1000 * 1000;
        final long MILLIS_PER_DAY = 24 * 60 * 60 * 1000;
        System.out.println(MICROS_PER_DAY / MILLIS_PER_DAY);//5
    }
    public static void elementary(){
        System.out.println(12345+5432l);
    }
    public static void main(String[] args) {
        elementary();
    }
}
