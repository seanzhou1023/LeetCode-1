import java.util.*;

/**
 * Created by eric on 3/10/17.
 */
public class T150 {
    public static int calculate(int num1, int num2, String op){
        if(op.equals("+")) return num1+num2;
        else if(op.equals("-")) return num1-num2;
        else if(op.equals("*")) return num1*num2;
        else if(op.equals("/")) return num1/num2;
        else return 0;
    }
    public static int evalRPN(String[] tokens){
        if(tokens.length==0) return 0;
        Stack<Integer> Num = new Stack<>();
        List<String> operands = new ArrayList<>();
        operands.add("+");operands.add("-");
        operands.add("*");operands.add("/");
        int num1=0, num2=0, start = 0;
        while(start<tokens.length){
            while(!operands.contains(tokens[start])){
                Num.push(Integer.valueOf(tokens[start]));
                start++;
                if(start==tokens.length) return Num.pop();
            }
            while(operands.contains(tokens[start])){
                num2 = Num.pop();
                num1 = Num.pop();
                int val = calculate(num1,num2,tokens[start]);
                Num.push(val);
                start++;
                if(start==tokens.length) return Num.pop();
            }
        }
        return Num.pop();
    }
    public static int eval_RPN(String[] tokens){
        int[] stack = new int[tokens.length];
        int top = 0;
        for(String token: tokens){
            if(!"+-*/".contains(token)){
                stack[top++] = Integer.valueOf(token);
                continue;
            }
            int v2 = stack[--top], v1 = stack[--top];
            switch(token.charAt(0)){
                case '+': v1 += v2;break;
                case '-': v1 -= v2;break;
                case '*': v1 *= v2;break;
                case '/': v1 /= v2;break;
                default:;
            }
            stack[top++] = v1;
        }
        return top!=0?stack[--top]:0;
    }
    public static void main(String[] args) {
        String[] tokens = {"4","13","5","/","+"};
        System.out.println(eval_RPN(tokens));
    }
}
