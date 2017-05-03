import java.util.Arrays;

/**
 * Created by eric on 4/12/17.
 * O(n^3) is general, but can't pass the OJ
 * general: https://www.youtube.com/watch?v=oDhu5uGq_ic
 * O(n) solution:
 * https://discuss.leetcode.com/topic/39751/my-explanation-for-o-n-solution
 */
public class T123 {
    public static int maxProfit(int[] prices) {
        int[][] dp = new int[3][prices.length];
        for(int i=1;i<3;i++){
            for(int j=1;j<prices.length;j++){
                dp[i][j] = dp[i][j-1];
                for(int k=0;k<j;k++){
                    dp[i][j] = Math.max(dp[i][j],dp[i-1][k]+prices[j]-prices[k]);
                }
            }
        }
        return dp[2][prices.length-1];
    }
    public static int maxProfitFast(int[] prices){
        int revenue1 = Integer.MIN_VALUE, revenue2 = Integer.MAX_VALUE;
        int profit1 = 0, profit2 = 0;
        for(int price: prices){
            revenue1 = Math.max(revenue1, -price);
            profit1 = Math.max(profit1, revenue1 + price);
            revenue2 = Math.max(revenue2, profit1 - price);
            profit2 = Math.max(profit2, revenue2 + price);
        }
        return profit2;
    }

    public static void main(String[] args) {
        int[] prices = {1,2};
        System.out.println(maxProfit(prices));
    }
}
