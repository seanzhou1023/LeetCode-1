import java.util.*;

/**
 * Created by eric on 2/28/17.
 */
public class T050 {
    public static double myPow(double x, int n){
        if(n==0) return 1;
        if(n<0){
            if(n==Integer.MIN_VALUE) n += 1;
            x = 1/x;
            n *= -1;
        }
        return n%2==0?myPow(x*x,n/2):x*myPow(x*x,n/2);
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(-2147483648+1));
        System.out.println(Integer.toBinaryString(-2147483647*-1));
        System.out.println(myPow(2,-2147483648));
        System.out.println(Math.pow(2,-2147483648));
    }
}
