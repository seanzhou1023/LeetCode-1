import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import methods.Trie;
import methods.Trie.Result;

/**
 * Created by eric on 4/5/17.
 * corner cases: how to deal with the ""(not shown in the Trie)
 * when put muiltiple boolean expression in the for loop terms,
 * be careful with the termination
 */
public class T336 {
    private static boolean checkPalindrome(String ori, String cur){
        if(ori.length()<cur.length()) {System.out.println("who");return checkPalindrome(cur,ori);}
        int s = cur.length(), e = ori.length()-1;
        while(s<e){
            if(ori.charAt(s++)!=ori.charAt(e--)) return false;
        }
        return true;
    }
    private static boolean checkPalindromeR(String ori, String cur){
        if(ori.length()<cur.length()) return checkPalindromeR(cur,ori);
        int s = 0, e = ori.length()-1-cur.length();
        while(s<e){
            if(ori.charAt(s++)!=ori.charAt(e--)) return false;
        }
        return true;
    }
    public static List<List<Integer>> palindromePairs(String[] words){
        List<List<Integer>> res = new ArrayList<>();
        Trie trie = new Trie();
        Trie trieR = new Trie();
        for(int i=0;i<words.length;i++){
            trie.insert(words[i],i);
            StringBuilder sb = new StringBuilder(words[i]);
            trieR.insert(sb.reverse().toString(),i);
        }
        for(int i=0;i<words.length;i++){
            if(words[i].length()==0){
                for(int j=0;j<words.length;j++){
                    if(j!=i && checkPalindrome(words[j],words[i])){
                        res.add(Arrays.asList(new Integer[]{j,i}));
                        if(words[j].length()!=0) res.add(Arrays.asList(new Integer[]{i,j}));
                    }
                }
            }
            Result cur = trie.startsWithRe(words[i]);
            Result curR = trieR.startsWith(words[i]);
            if(cur.isPrefix){
                for(int idx:cur.restIdx){
                    if(i!=idx && checkPalindrome(words[idx],words[i]))
                        res.add(Arrays.asList(new Integer[]{idx,i}));
                }
            }
            if(curR.isPrefix){
                for(int idx:curR.restIdx){
                    if(i!=idx && words[i].length()!=words[idx].length()
                            &&checkPalindromeR(words[i],words[idx]))
                        res.add(Arrays.asList(new Integer[]{i,idx}));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words = {"bb","bababab","baab","abaabaa","aaba","","bbaa","aba","baa","b"};
        System.out.println(palindromePairs(words));
    }
}
