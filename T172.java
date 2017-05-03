/**
 * Created by eric on 2/12/17.
 */
public class T172 {
    public static int trailingZeroes(int n){
        int res = 0, start = 5;
        while(n/start>0){
            res+=n/start;
            start*=5;
        }
        return res;
    }
    public static long fact(int n){
        long res = 1;
        for(int i=2;i<n+1;i++)
            res*=i;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(trailingZeroes(1808548329));
        System.out.println(fact(10));
    }
}
