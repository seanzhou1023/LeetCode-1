package geeksforgeeks;

/**
 * Created by eric on 4/19/17.
 */
public class EggDrop {
    private int calculate(int[][] dp, int n, int k){
        if(n==0 || k==0 || dp[n][k]>0) return dp[n][k];
        int res = Integer.MAX_VALUE;
        for(int i=1;i<=k;i++){
            res = Math.min(res, 1 + Math.max(calculate(dp,n-1,i-1), calculate(dp,n,k-i)));
        }
        dp[n][k] = res;
        return dp[n][k] = res;
    }
    public int eggDrop(int n, int k){
        int[][] dp = new int[n+1][k+1];
        for(int i=1;i<=k;i++) dp[1][i] = i;
        for(int i=1;i<=n;i++) dp[i][1] = 1;
        return calculate(dp, n, k);
    }

    public static void main(String[] args) {
//        System.out.println(EggDrop.eggDrop(2,6));
    }
}
