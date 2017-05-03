import java.util.ArrayList;
import java.util.*;

/**
 * Created by eric on 4/22/17.
 * next time reduce the memory space to O(n)
 * https://discuss.leetcode.com/topic/6465/a-dp-solution-with-clarification-and-explanation
 * count distinct subsequences: http://www.geeksforgeeks.org/count-distinct-subsequences/
 */
public class T115 {
    int cnt;
    private void generate(StringBuilder sb, char[] tc, int start, String t){
        if(sb.length()==t.length()){
            if(sb.toString().equals(t)){
                cnt++;
            }
            return ;
        }
        cnt++;
        for(int i=start;i<tc.length;i++){
            sb.append(tc[i]);
            generate(sb,tc,i+1,t);
            sb.setLength(sb.length()-1);
        }
    }
    public int numDistinct(String s, String t){
        cnt = 0;
        StringBuilder sb = new StringBuilder();
        generate(sb,s.toCharArray(),0,t);
        return cnt;
    }
    public int numDistinctDP(String s, String t){
        char[] tc = t.toCharArray(), sc = s.toCharArray();
        int[][] dp = new int[tc.length+1][sc.length+1];
        for(int i=0;i<dp[0].length;i++) dp[0][i] = 1;
        for(int i=1;i<dp.length;i++)
            for(int j=1;j<dp[0].length;j++){
                dp[i][j] = (tc[i-1]==sc[j-1]?dp[i-1][j-1]:0) + dp[i][j-1];
            }
        return dp[t.length()][s.length()];
    }
    public int countDis(String str){//count different subseq
        int len = str.length();
        int[] dp = new int[len+1];
        dp[0] = 1;
        char[] idx = new char[128];
        Arrays.fill(idx,'*');
        for(int i=1;i<=len;i++){
            dp[i] = dp[i-1]*2;
            if(idx[str.charAt(i-1)]!='*'){
                dp[i] -= dp[idx[str.charAt(i-1)]];
            }
            idx[str.charAt(i-1)] = (char)(i-1);
        }
        return dp[len];
    }
    public static void main(String[] args) {
        T115 t = new T115();
//        System.out.println(t.numDistinct("gfg",""));
    }
}
