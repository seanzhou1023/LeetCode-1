import java.util.*;

/**
 * Created by eric on 3/24/17.
 * pure recursion, time limit exceeded for last test case
 * add palindrome boolean table first, second try - get through - 8ms
 * modified the palindrome table calculation - 6ms
 * faster calculation of palindrome table?
 */
public class T131 {
    private static boolean isPalindrome(char[] sc, int s, int e){
        while(s<e) if(sc[s++]!=sc[e--]) return false;
        return true;
    }
    private static void generate(List<String> tmp, List<List<String>> res,
                                 String s, int start, boolean[][] palindrome){
        if(start==palindrome.length){
            List<String> temp = new ArrayList<>(tmp);
            res.add(temp);
            return;
        }
        for(int j=start;j<palindrome.length;j++)
            if(palindrome[start][j]){
                tmp.add(s.substring(start,j+1));
                generate(tmp,res,s,j+1,palindrome);
                tmp.remove(tmp.size()-1);
            }
    }
    public static List<List<String>> partition(String s){
        List<List<String>> res = new ArrayList<>();
        List<String> tmp = new ArrayList<>();
        char[] sc = s.toCharArray();
        boolean[][] palindrome = new boolean[sc.length][sc.length];
        for(int d=0;d<sc.length;d++){
            for(int i=0;i+d<sc.length;i++){
                int j = i+d;
                if(sc[i]==sc[j]) palindrome[i][j] = i+1>=j-1?true:palindrome[i+1][j-1];
            }
        }
        generate(tmp,res,s,0,palindrome);
        return res;
    }

    public static void main(String[] args) {
        String s = "aaaabaaaa";
        System.out.println(partition(s).size());
    }
}
