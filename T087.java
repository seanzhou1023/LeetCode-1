/**
 * Created by eric on 3/26/17.
 * 1. recursion without anagram limit - 5ms O(4^n)
 * 2. DP - 31ms O(n^4)
 * the test cases are not complete
 */
public class T087 {
    static int level = 0;
    public static boolean isAnagram(String s1, String s2){
        int[] table = new int[26];
        for(char c:s1.toCharArray())
            table[c-'a']++;
        for(char c:s2.toCharArray())
            table[c-'a']--;
        for(int i:table)
            if(i!=0) return false;
        return true;
    }
    public static boolean isScramble(String s1, String s2){
        System.out.println(++level);
        if(s1.length()!=s2.length()) {level--;return false;}
        if(s1.equals(s2)) {level--;return true;}
        int len = s1.length();
        for(int i=1;i<s1.length();i++){
            String[] ss1 ={s1.substring(0,i),s1.substring(i,len)};
            String[] ss2 = {s2.substring(0,i),s2.substring(i,len)};
            String[] ss3 = {s2.substring(len-i,len),s2.substring(0,len-i)};
            if(isAnagram(ss1[0],ss2[0]) && isAnagram(ss1[1],ss2[1])
                    && isScramble(ss1[0],ss2[0]) && isScramble(ss1[1],ss2[1]))
            {level--;return true;}
            if(isAnagram(ss1[0],ss3[0]) && isAnagram(ss1[1],ss3[1])
                    && isScramble(ss1[0],ss3[0]) && isScramble(ss1[1],ss3[1]))
            {level--;return true;}
        }
        level--;
        return false;
    }
    public static boolean isScrambleDP(String s1, String s2){
        int len = s1.length();
        boolean[][][] dp = new boolean[len+1][len+1][len+1];
        for(int i=len-1;i>=0;i--)
            for(int j=len-1;j>=0;j--){
                dp[i][j][1] = (s1.charAt(i)==s2.charAt(j));
                for(int l=2;i+l<=len && j+l<=len;l++)
                    for(int k=1;k<l;k++){
                        dp[i][j][l] |= dp[i][j][k] && dp[i+k][j+k][l-k];
                        dp[i][j][l] |= dp[i][j+l-k][k] && dp[i+k][j][l-k];
                    }
            }
        return dp[0][0][len];
    }

    public static void main(String[] args) {
        String s1 = "bcdebcdebcdebcdebcdebcdebcdebcdebcdebcdebcdebcdebcdebcdebcdebcdebcdebcdebcdebcdebcdebcde",
                s2 = "cebdcebdcebdcebdcebdcebdcebdcebdcebdcebdcebdcebdcebdcebdcebdcebdcebdcebdcebdcebdcebdcebd";
        System.out.println(isScramble(s1,s2));
    }
}
