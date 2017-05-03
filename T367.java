/**
 * Created by eric on 4/16/17.
 */
public class T367 {
    public static boolean isPerfectSquare(int num){
        if(num==1 || num==4) return true;
        for(int i=3;i<num/2;i++)
            if(i*i==num) return true;
        return false;
    }
    public static boolean isPerfectSquareNewton(int num) {
        //https://en.wikipedia.org/wiki/Integer_square_root
        long x = num;
        while (x * x > num) {
            x = (x + num / x) >> 1;
        }
        return x * x == num;
    }
}
