import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by eric on 3/22/17.
 */
public class T524 {
    public static String findLongestWord(String s, List<String> d){
        int max = 0;
        String res = "";
        for(String str:d){
            int i, start = -1, len=str.length();
            for(i = 0;i<len;i++){
                start = s.indexOf(str.charAt(i),start+1);
                if(start<0) break;
            }
            if(i==len){
                if(len>max){
                    max = len;
                    res = str;
                }else if(len==max){
                    res = str.compareTo(res)<0?str:res;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "aewfafwafjlwajflwajflwafj";
        String[] d = {"apple","ewaf","awefawfwaf","awef","awefe","ewafeffewafewf"};
        List<String> res = new ArrayList<>(Arrays.asList(d));
        long t0 = System.nanoTime();
        for(int i=0;i<10000;i++)
            findLongestWord(s,res);
        long t1 = System.nanoTime();
    }
}
