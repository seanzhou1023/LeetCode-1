import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by eric on 3/13/17.
 */
public class T438 {
    public static boolean isValid(String s, String p){
        int[] table = new int[26];
        for(int i=0;i<s.length();i++){
            table[s.charAt(i)-'a']++;
        }
        for(int i=0;i<p.length();i++){
            if(table[p.charAt(i)-'a']==0) return false;
            table[p.charAt(i)-'a']--;
        }
        for(int i=0;i<26;i++)
            if(table[i]!=0) return false;
        return true;
    }
    public static List<Integer> findAnagrams(String s, String p){
        List<Integer> res = new ArrayList<>();
        int slen = s.length(), plen = p.length();
        for(int i=0;i<slen-plen+1;i++){
            if(isValid(s.substring(i,i+plen),p)) res.add(i);
        }
        return res;
    }
    public static List<Integer> fastFindAnagrams(String s, String p){
        List<Integer> res = new ArrayList<>();
        int slen = s.length(), plen = p.length();
        char[] sc = s.toCharArray(), pc = p.toCharArray();
        int[] table = new int[26];
        for(int i=0;i<plen;i++) table[pc[i]-'a']++;
        int left = 0, right = 0, cnt = plen;
        while(right<slen){
            if(table[sc[right++]-'a']-->0) cnt--;
            if(cnt==0) res.add(left);
            if(right-left==plen && table[sc[left++]-'a']++ >=0) cnt++;
        }
        System.out.println(Arrays.toString(table));
        return res;
    }

    public static void main(String[] args) {
        String s = "bpaa", p = "aa";
        System.out.println(fastFindAnagrams(s,p));
    }
}
