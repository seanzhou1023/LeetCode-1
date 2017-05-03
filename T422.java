import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by eric on 4/14/17.
 * corner cases
 */
public class T422 {
    public static boolean validWordSquare(List<String> words){
        int last = Integer.MAX_VALUE, len = words.size();
        for(int i=0;i<len;i++){
            char[] curW = words.get(i).toCharArray();
            if(curW.length>last) return false;
            last = curW.length;
            int j;
            for(j=0;j<curW.length && j<len;j++){
                String cur = words.get(j);
                if(i>=cur.length() || cur.charAt(i)!=curW[j]) break;
            }
            if(j<curW.length) return false;
            if(j<len){
                for(int k=j;k<len;k++)
                    if(words.get(k).length()>i) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<String> words = new ArrayList<>(Arrays.asList("abcd","bnrt","crm","dt"));
        System.out.println(validWordSquare(words));
    }
}
