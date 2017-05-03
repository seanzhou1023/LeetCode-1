import java.util.HashSet;
import java.util.Set;

/**
 * Created by eric on 3/29/17.
 */
public class T395 {
    public static int longestSubstring(String s, int k){
        if(s.length()==0 || k>s.length()) return 0;
        int[] table = new int[26];
        char[] sc = s.toCharArray();
        for(char c:sc) table[c-'a']++;
        boolean flag = false;
        for(int i=0;i<table.length;i++)
            if(table[i]>0 && table[i]<k) {flag = true;break;}
        if(!flag) return sc.length;
        int last = -1, max = 0;
        for(int i=0;i<sc.length;i++){
            if(table[sc[i]-'a']>0 && table[sc[i]-'a']<k){
                if(last!=-1){
                    if(i-last>max) max = Math.max(longestSubstring(s.substring(last,i),k),max);
                }
                else{
                    if(i>max) max = Math.max(longestSubstring(s.substring(0,i),k),max);
                }
                last = i+1;
            }
        }
        if(last!=-1 && sc.length-last>max)
            max = Math.max(longestSubstring(s.substring(last,sc.length),k),max);
        return max;
    }

    public static void main(String[] args) {
        String s = "ababbc";
        int k = 2;
        System.out.println(longestSubstring(s,k));
    }
}
