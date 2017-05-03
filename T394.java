import java.util.Arrays;
import java.util.Stack;

/**
 * Created by eric on 3/12/17.
 * next time do it recursively
 * https://discuss.leetcode.com/topic/57228/0ms-simple-c-solution
 * or finite state machine
 */
public class T394 {
    public static String decodeString(String s){
        if(s==null) return "";
        s = "1[" + s + "]";
        int n = 0, ndx = 0, rdx = 0, len = s.length();
        int[] num = new int[len];
        String[] res = new String[len];
        StringBuilder sb = new StringBuilder(), rep = new StringBuilder();
        for(int i=0;i<len;i++){
            char cur = s.charAt(i);
            if(cur>='a' && cur<='z'){//continue with the substring
                sb.append(cur); continue;
            }
            if(cur>='0' && cur<='9'){//extract the number
                if(sb.length()>0) res[rdx++] = sb.toString();
                n = n*10 + cur-'0';
            }else if(cur=='[') {
                num[ndx++] = n; n = 0;
                res[rdx++] = "[";
            }else{//s.charAt(i)==']'
                String tmpStr = sb.toString();
                while(res[(rdx--)-1]!="[")
                    tmpStr = res[rdx] + tmpStr;
                int curNum = num[--ndx];//pop the number
                rep.setLength(0);
                for(int k=0;k<curNum;k++){
                    rep.append(tmpStr);
                }
                res[rdx++] = rep.toString();
            }
            sb.setLength(0);
        }
        return res[--rdx];
    }

    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
    }
}
