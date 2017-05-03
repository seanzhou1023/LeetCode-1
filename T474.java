import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by eric on 3/20/17.
 * if it's not a 0/1 knapsack problem, if we can split it, sort by val/weight
 */
public class T474 {
    static class ZeroOne{
        int zeroes, ones;
        ZeroOne(int zeroes, int ones){
            this.zeroes = zeroes;
            this.ones = ones;
        }
    }
    public static ZeroOne calW(String s){
        int cnt0 = 0, cnt1 = 0;
        for(char c: s.toCharArray()){
            if(c=='0') cnt0++;
            else cnt1++;
        }
        ZeroOne res = new ZeroOne(cnt0,cnt1);
        return res;
    }
    public static int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(String str: strs){
            int cnt0 = 0, cnt1 = 0;
            for(char c: str.toCharArray()){
                if(c=='0') cnt0++;
                else cnt1++;
            }
            ZeroOne zo = new ZeroOne(cnt0,cnt1);
            for(int i=m;i>=zo.zeroes;i--)
                for(int j=n;j>=zo.ones;j--){
                    dp[i][j] = Math.max(dp[i][j], dp[i-zo.zeroes][j-zo.ones]+1);
                }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String[] strs = {"10","1","0"};
        System.out.println(findMaxForm(strs,1,1));
    }
}
