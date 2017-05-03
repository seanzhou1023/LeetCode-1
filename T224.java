import java.util.Stack;

/**
 * Created by eric on 4/10/17.
 * sum = sum*10 + c-'0'...wtf
 * next time try take * & / into account
 */
public class T224 {
    public static int calculate(String s){
        char[] sc = s.toCharArray(), stack = new char[sc.length];
        int num = 0, res = 0, pos = 0, reverse = 1;
        char sign = '+';
        stack[pos++] = sign;
        for(int i=0;i<=sc.length;i++){
            char c = i!=sc.length?sc[i]:'+';
            if(c==' ') continue;
            if(c=='(') {
                stack[pos++]=sign;
                if(stack[pos-1]=='-') reverse *= -1;
                sign='+';
                continue;
            }
            if(c>='0' && c<='9'){ num = num*10 + (c-'0'); continue; }
            res += reverse*(sign=='+'?num:-num);
            num = 0; sign = c;
            if(c==')') {
                if(stack[--pos]=='-') reverse *= -1;
                sign='+';
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "2-4-(8+2-6+(8+4-(1)+8-10))";
        System.out.println(calculate(s));
    }
}
