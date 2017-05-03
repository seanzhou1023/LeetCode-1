import java.util.Arrays;
import java.util.Stack;

/**
 * Created by eric on 4/6/17.
 */
public class T227 {
    public static int calculate(String s){
        char[] sc = new char[s.length()];
        int len = 0,start = 0;
        while(start<sc.length){
            char cur = s.charAt(start++);
            if(cur !=' ') sc[len++] = cur;
        }
        Stack<Integer> num = new Stack<>();
        Stack<Character> op = new Stack<>();
        int i = 0;
        while(i<len){
            int sum = 0;
            while(i<len && sc[i]>='0' && sc[i]<='9'){
                sum = sum*10 + (sc[i++]-'0');
            }
            num.push(sum);//do not need a boolean flag
            if(!op.isEmpty() && (op.peek()=='*' || op.peek()=='/')){
                int n2 = num.pop();
                int n1 = num.pop();
                int res = op.pop()=='*'?n1*n2:n1/n2;
                num.push(res);
            }
            if(i==len) break;
            op.push(sc[i++]);
        }
        int result = 0;
        while(!op.isEmpty()){
            char curOp = op.pop();
            int n = num.pop();
            result += curOp=='+'?n:-n;
        }
        return result+num.pop();
    }
    public static int calculateNoStack(String s){
        char[] sc = s.toCharArray();
        int len = sc.length;
        int[] num = new int[len/2+1];
        char[] op = new char[len/2];
        int ndx = 0, odx = 0, sum = 0;
        for(int i=0;i<=len;i++){
            char cur = i==len?'-':sc[i];
            if(cur ==' ') continue;
            if(cur>='0' && cur<='9'){
                sum = sum*10 + (cur-'0');
                continue;
            }
            num[ndx++]=sum; sum = 0;
            if(odx>0 && (op[odx-1]=='*' || op[odx-1]=='/')){
                int n2 = num[--ndx];
                int n1 = num[--ndx];
                int res = op[--odx]=='*'?n1*n2:n1/n2;
                num[ndx++]=res;
            }
            if(i<len) op[odx++] = cur;
        }
        while(odx>0){
            int n = num[--ndx];
            sum += op[--odx]=='+'?n:-n;
        }
        return sum+(ndx==1?num[0]:0);
    }
    public int calculateElegant(String s) {
        int v1 = 0, v2 = 0, res = 0, len = s.length();
        char sign = '+';
        char[] arr = s.toCharArray();
        for (int i = 0; i <= len; i++) {
            char c = i == len ? '+' : arr[i];
            if (c == ' ') continue;
            if (c >= '0' && c <= '9') {
                v2 = v2 * 10 + c - '0';
                continue;
            }
            switch(sign){
                case '+' : res += v1; v1=v2; break;
                case '-' : res += v1; v1=-v2; break;
                case '*' : v1 *= v2; break;
                case '/' : v1 /= v2; break;
            }
            sign = c; v2 = 0;
        }
        res += v1;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(calculateNoStack("3+2*2"));
    }
}
