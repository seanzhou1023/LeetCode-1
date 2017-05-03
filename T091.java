import java.util.Arrays;

/**
 * Created by eric on 3/23/17.
 * bottom up top down O(n) space O(1) space
 */
public class T091 {
    public static int numDecodingsRe(String s){
        int cnt = 0;
        if(s.length()<1) return cnt;
        else{
            char last = s.charAt(s.length()-1);
            if(last!='0')
                cnt += s.length()==1?1:numDecodingsRe(s.substring(0,s.length()-1));
            if(s.length()>1){
                char second = s.charAt(s.length()-2);
                int num = (last-'0')+10*(second-'0');
                if(num>=10 && num<=26)
                    cnt += s.length()==2?1:numDecodingsRe(s.substring(0,s.length()-2));
            }
        }
        return cnt;
    }
    public static int numDecodings1(String s){
        int n = s.length();
        if(n==0) return 0;
        int[] dp = new int[n+1];
        dp[n] = 1;
        dp[n-1] = s.charAt(n-1)=='0'?0:1;
        for(int i=n-2;i>=0;i--){
            if(s.charAt(i)!='0')
                dp[i] = ((s.charAt(i)-'0')*10+s.charAt(i+1)-'0')<=26
                        ?dp[i+1]+dp[i+2]:dp[i+1];
        }
        System.out.println(Arrays.toString(dp));
        return dp[0];
    }
    public static int numDecodings2(String s){
        int n = s.length();
        if(n==0) return 0;
        int[] dp = new int[n+1];
        dp[0] = 1; dp[1] = s.charAt(0)=='0'?0:1;
        for(int i=2;i<n;i++){
            if(s.charAt(i-1)!='0')
                dp[i] = ((s.charAt(i-1)-'0')*10+s.charAt(i)-'0')<=26
                        ?dp[i-1]+dp[i-2]:dp[i-1];
        }
        System.out.println(Arrays.toString(dp));
        return s.charAt(n-1)=='0'?dp[n-1]:dp[n]+dp[n-1];
    }
    public static void main(String[] args) {
        String s = "22625";
        System.out.println(numDecodings1(s));
        System.out.println(numDecodings2(s));
    }
}
