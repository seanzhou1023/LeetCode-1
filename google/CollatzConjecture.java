package google;

/**
 * Created by eric on 4/17/17.
 */
public class CollatzConjecture {
    public static int getLongest(int[] dp, int n){
        if(dp[n]>0) return dp[n];
        if(n%2==0) dp[n] = getLongest(dp, n/2) + 1;
        else dp[n] = getLongest(dp,3*n + 1) + 1;
        return dp[n];
    }
    public static int collatzConjecture(int top){
        int[] dp = new int[100000000];
        dp[2] = 1;
        int max = 0, maxNum = 1;
        for(int i=2;i<=top;i++){
            if(getLongest(dp,i)>max){
                max = getLongest(dp,i);
                maxNum = i;
            }
        }
        System.out.println(max);
        return maxNum;
    }

    public static void main(String[] args) {
        System.out.println(collatzConjecture(7));
    }
}
