import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by eric on 3/24/17.
 * simple dp TLE O(n^3) time, O(n^2) space
 * update the value when updating palindrome matrix
 * https://discuss.leetcode.com/topic/32575/easiest-java-dp-solution-97-36
 * another one https://discuss.leetcode.com/topic/2840/my-solution-does-not-need-a-table-for-palindrome-is-it-right-it-uses-only-o-n-space/52
 */
public class T132 {
    public static int minCutN3toN2(String s){
        int len = s.length();
        int[] cut = new int[len];
        for(int i=0;i<len;i++) cut[i] = i-1;
        char[] sc = s.toCharArray();
        boolean[][] palindrome = new boolean[len][len];
        for(int i=0;i<len;i++){
            int min = i;
            for(int j=0;j<=i;j++){
                if(sc[i]==sc[j] && (j+1>i-1 || palindrome[j+1][i-1])){
                    palindrome[j][i] = true;
                    min = j==0?0:Math.min(min,cut[j-1]+1);
                }
            }
            cut[i] = min;
        }
        System.out.println(Arrays.toString(cut));
        return cut[len-1];
    }
    public static int minCutN3(String s){
        int len = s.length();
        int[][] dp = new int[len][len];
        char[] sc = s.toCharArray();
        boolean[][] palindrome = new boolean[len][len];
        for(int d=0;d<len;d++){
            for(int i=0;i+d<len;i++){
                int j = i+d;
                if(sc[i]==sc[j]) palindrome[i][j] = i+1>=j-1?true:palindrome[i+1][j-1];
            }
        }
        for(int d=1;d<len;d++)
            for(int i=0;i+d<len;i++){
                int j = i+d;
                if(!palindrome[i][j]){
                    for(int k=i;k<j;k++){
                        int tmp = 1+dp[i][k]+dp[k+1][j];
                        dp[i][j] = (dp[i][j]==0 || dp[i][j]>tmp)?tmp:dp[i][j];
                    }
                }
            }
        for(int i=0;i<len;i++)
            System.out.println(Arrays.toString(dp[i]));
        return dp[0][len-1];
    }
    public static int minCut(String s){
        int n = s.length();
        int[] cut = new int[n+1];
        char[] c = s.toCharArray();
        for(int i=0;i<n+1;i++) cut[i] = i-1;
        for(int i=0;i<n;i++){
            for(int j=0;i-j>=0 && i+j<n && c[i-j]==c[i+j];j++)
                cut[i+j+1] = Math.min(cut[i+j+1],cut[i-j]+1);
            for(int j=1;i-j+1>=0 && i+j<n && c[i-j+1]==c[i+j];j++)
                cut[i+j+1] = Math.min(cut[i+j+1],cut[i-j+1]+1);
        }
        return cut[n];
    }

    public static void main(String[] args) {
        String s = "aaaacaaabbaaaaaaaa";
        System.out.println(minCutN3toN2(s));
    }
}
