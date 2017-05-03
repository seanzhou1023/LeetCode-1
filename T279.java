import java.util.Arrays;

/**
 * Created by eric on 3/14/17.
 */
public class T279 {
    public static int numSquares(int n){
        int[] count = new int[n+1];
        Arrays.fill(count,Integer.MAX_VALUE);
        count[0] = 0;
        for(int i=1;i<=n;i++)
            for(int j=1;j*j<=i;j++){
                count[i] = Math.min(count[i],count[i-j*j]+1);
            }
        return count[n];
    }

    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }
}
