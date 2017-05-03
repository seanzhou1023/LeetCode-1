import java.util.Arrays;
import java.util.Stack;

/**
 * Created by eric on 3/15/17.
 */
public class T316 {
    public static String removeDuplicateLetters(String s){
        if(s==null || s.length()<2) return s;
        int[] cnt;
        StringBuilder sb = new StringBuilder();
        StringBuilder tmp = new StringBuilder();
        int len = s.length();
        while(len!=0){
            cnt = new int[26];
            char[] arr = s.toCharArray();
            for(char c:arr) cnt[c-'a']++;
            int pos = 0;
            for(int i=0;i<len;i++){
                if(arr[i]<arr[pos]) pos=i;
                if(--cnt[arr[i]-'a']==0) break;
            }
            sb.append(arr[pos]);
            for(int i=pos+1;i<arr.length;i++)
                if(arr[i]!=arr[pos]) tmp.append(arr[i]);
            s = tmp.toString();
            tmp.setLength(0);
            len = s.length();
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "cbacdcbc";
        System.out.println(removeDuplicateLetters(s));
    }
}
