import java.util.Arrays;

/**
 * Created by eric on 3/3/17.
 */
public class T097 {
    public static boolean isInterleave(String s1, String s2, String s3){
        int l1 = s1.length(), l2 = s2.length(), l3 = s3.length();
        if(l1+l2!=l3) return false;
        boolean[][] dp = new boolean[l1+1][l2+1];
        char[] s1char = s1.toCharArray();
        char[] s2char = s2.toCharArray();
        char[] s3char = s3.toCharArray();
        dp[0][0] = true;
        for(int i=1;i<l1+1;i++){
            if(s1char[i-1]==s3char[i-1])
                dp[i][0] = dp[i-1][0];
        }
        for(int i=1;i<l2+1;i++){
            if(s2char[i-1]==s3char[i-1])
                dp[0][i] = dp[0][i-1];
        }
        for(int i1=1;i1<l1+1;i1++)
            for(int i2=1;i2<l2+1;i2++){
                char cur = s3char[i1+i2-1];
                if(cur==s1char[i1-1])
                    dp[i1][i2] = dp[i1][i2] || dp[i1-1][i2];
                if(cur==s2char[i2-1])
                    dp[i1][i2] = dp[i1][i2] || dp[i1][i2-1];
            }
        for(int i=0;i<l1+1;i++)
            System.out.println(Arrays.toString(dp[i]));
        return dp[l1][l2];
    }

    public static void main(String[] args) {
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        System.out.println(isInterleave(s1,s2,s3));
    }
}
