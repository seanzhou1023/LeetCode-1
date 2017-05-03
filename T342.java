/**
 * Created by eric on 2/12/17.
 */
public class T342 {
    public static boolean isPowerOfFour(int num) {
        return num>0 && (num&(num-1))==0 && (num & 0x55555555)!=0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfFour(16));
    }
}
