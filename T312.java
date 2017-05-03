import java.util.Arrays;

/**
 * Created by eric on 3/21/17.
 * https://discuss.leetcode.com/topic/84687/java-top-down-and-bottom-up-dp-solutions
 */
public class T312 {
    public static int maxCoins(int[] nums){
        int len = nums.length;
        int[][] dp = new int[len][len];
//        for(int i=0;i<len;i++){//update the one length array
//            int left = i==0?1:nums[i-1];
//            int right = i==len-1?1:nums[i+1];
//            dp[i][i] = left*nums[i]*right;
//        }
        for(int l=0;l<len;l++)//l is the length for each step
            for(int i=0;i+l<len;i++){
                int j = i+l;
                for(int k=i;k<=j;k++){//k is the last to burst
                    int leftPart = k==i?0:dp[i][k-1];
                    int rightPart = k==j?0:dp[k+1][j];
                    int left = i<1?1:nums[i-1];
                    int right = j+1>=len?1:nums[j+1];
                    int curPart = left*nums[k]*right;
                    dp[i][j] = Math.max(dp[i][j],leftPart+curPart+rightPart);
                }
            }
        return dp[0][len-1];
    }
    public static int calculate(int[] nums, int[][] dp, int left,
                                int i, int j, int right){
        if(i>j) return 0;
        if(i==j) return left*nums[i]*right;
        if(dp[i][j]>0) return dp[i][j];
        for(int k=i;k<=j;k++){
            dp[i][j] = Math.max(dp[i][j],
                    left*nums[k]*right + calculate(nums,dp,left,i,k-1,nums[k]) +
            calculate(nums,dp,nums[k],k+1,j,right));
        }
        return dp[i][j];
    }
    public static int maxCoinsM(int[] nums){
        int[][] dp = new int[nums.length][nums.length];
        return calculate(nums, dp, 1, 0, nums.length-1, 1);
    }

    public static void main(String[] args) {
        int[] nums = {3,1,5,8};
        System.out.println(maxCoinsM(nums));
    }
}
