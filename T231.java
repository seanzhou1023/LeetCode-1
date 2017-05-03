/**
 * Created by eric on 2/12/17.
 */
public class T231 {
    public static boolean isPowerOfTwo(int n) {
        return n>0 && n == (n & ~(n-1));
    }
}
