import java.util.*;

/**
 * Created by eric on 2/11/17.
 */
public class T139 {
    public static boolean wordBreak(String s, List<String> wordDict){
        if(s==null||s.length()<1||wordDict==null||wordDict.size()<1)
            return false;
        int len = s.length();
        boolean[] res = new boolean[len+1];
        res[0] = true;
        for(int i=1;i<len+1;i++){
            for(int j=0;j<i;j++){
                if(res[j] && wordDict.contains(s.substring(j,i))){
                    res[i] = true;
                    break;
                }
            }
        }
        return res[len];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<String>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(wordBreak(s,wordDict));
    }
}
