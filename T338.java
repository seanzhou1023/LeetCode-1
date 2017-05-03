import java.util.*;

/**
 * Created by eric on 2/11/17.
 * http://www.programcreek.com/2015/03/leetcode-counting-bits-java/
 */
public class T338 {
    public static int count(int n){
        int res = 0;
        while(n>0){
            res += n%2;
            n = n>>1;
        }
        return res;
    }
    public static int[] countBits(int num){
            int[] res = new int[num+1];
            for(int i=1;i<=num;i++){
                res[i] = count(i);
            }
            return res;
    }
    public static int[] countBitsDP(int num){
        int[] res = new int[num+1];
        int pow = 1, p = 1;
        for(int i=1;i<=num;i++){
            if(i==pow){
                res[i] = 1;
                pow<<=1;
                p = 1;
            }
            else{
                res[i] = res[p] + 1;
                p++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBitsDP(100)));
    }
}
