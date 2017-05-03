import java.util.*;

/**
 * Created by eric on 4/13/17.
 */
public class T522 {
    public static boolean isSub(String s1, String s2){
        int j = 0;
        for(int i=0;i<s2.length() && j<s1.length();i++){
            if(s1.charAt(j)==s2.charAt(i)) j++;
        }
        return j==s1.length();
    }
    public static int findLUSlength(String[] strs){
        int max = -1, j;
        for(int i=0;i<strs.length;i++){
            for(j=0;j<strs.length;j++){
                if(i==j) continue;
                if(isSub(strs[i],strs[j])) break;
            }
            if(j==strs.length) max = Math.max(max,strs[i].length());
        }
        return max;
    }

    public static void main(String[] args) {
        String[] strs = {"aaa","aaa","aa"};
        System.out.println(findLUSlength(strs));
    }
}
