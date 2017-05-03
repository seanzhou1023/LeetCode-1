import java.util.Iterator;
import java.util.PrimitiveIterator;

/**
 * Created by eric on 2/14/17.
 */
public class T389 {
    public static char findTheDifference(String s, String t){
        int[] table = new int[26];
        char res = (char)0;
        for(int i=0;i<t.length();i++)
            table[t.charAt(i)-'a']++;
        for(int j=0;j<s.length();j++)
            table[s.charAt(j)-'a']--;
        for(int k=0;k<26;k++)
            if(table[k]==1)
                res = (char)(k+'a');
        return res;
    }
    public static char findTheDifferenceBit(String s, String t){
        char res = 0;
        for(int i=0;i<s.length();i++)
            res ^= s.charAt(i);
        for(int i=0;i<t.length();i++)
            res ^= t.charAt(i);
        return res;
    }

    public static void main(String[] args) {
        String s = "abcd",t="abcde";
        System.out.println(findTheDifference(s,t));
    }
}
