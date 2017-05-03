import java.util.Arrays;

/**
 * Created by eric on 3/29/17.
 * first dp by myself from thoughts to implementation, hooray!
 */
public class T403 {
    public static boolean canCross(int[] stones){
        if(stones.length==1) return true;
        int len = stones.length;
        boolean[][] dp = new boolean[len][len];
        dp[0][0] = true;
        for(int i=1;i<len;i++)
            for(int j=0;j<i;j++){
                int jump = stones[i]-stones[j];
                if(jump<len){
                    dp[i][jump] |= dp[j][jump-1] | dp[j][jump];
                    if(jump+1<len) dp[i][jump] |= dp[j][jump+1];
                }
            }
        for(int k=0;k<len;k++)
            if(dp[len-1][k]) return true;
        return false;
    }

    public static void main(String[] args) {
        int[] stones = {0,1,2,3,4,8,9,11};
        System.out.println(canCross(stones));
    }
}
