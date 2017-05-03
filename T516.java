import java.util.Arrays;

/**
 * Created by eric on 2/27/17.
 * don't confuse with T005
 * faster version : https://discuss.leetcode.com/topic/78625/python-dp-o-n-space-o-n-2-time/4
 *
 */
public class T516 {
    public static void printResult(int[][] res, String s, int len){
//       reconstruct the subsequence
         char[] c = new char[len];
         int start = 0, end = s.length()-1;
         int pos = 0;//position of subsequence
         while(start<=end){
             if(s.charAt(start)==s.charAt(end)){
                 c[pos] = c[len-1-pos] = s.charAt(start);
                 start++;end--;pos++;
             }else{
                 if(res[start][end-1]>=res[start+1][end]) end--;
                 else start++;
             }
         }
        System.out.println(new String(c));
    }
    public static int longestPalindromeSubseq(String s) {
        if(s.length()<2) return s.length();
        int length = s.length();
        int[][] res = new int[length][length];
        for(int i=0;i<length;i++){
            res[i][i] = 1;
        }
        for(int k=1;k<length;k++)
            for(int i=0;i+k<length;i++){
                if(s.charAt(i)!=s.charAt(i+k))
                    res[i][i+k] = Math.max(res[i][i+k-1],res[i+1][i+k]);
                else res[i][i+k] = 2 + res[i+1][i+k-1];
            }
        int len = res[0][length-1];
        printResult(res,s,len);//reconstruct the subsequence
        return len;
    }

    public static void main(String[] args) {
        String s = "acdgagfgfsggerbdba";
        System.out.println(longestPalindromeSubseq(s));//adggfgfggda,11
    }
}
