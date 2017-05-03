import java.util.*;
/**
 * Created by eric on 2/12/17.
 * simulate a stack - added
 */
public class T020 {
    public static boolean isValid(String s) {
        if(s.length()<2)
            return false;
        Deque<Character> stack = new ArrayDeque<Character>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='[' || c=='{' || c=='(')
                stack.push(c);
            else{
                if(stack.isEmpty())
                    return false;
                else{
                    char p = stack.pop();
//                    this is smartass
                    if(c-p>2 || c-p<0)
                        return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public static boolean isValidSim(String s){
        char[] array = s.toCharArray();
        int top = 0;
        char[] stack = new char[array.length];
        for(char c:array){
            switch(c){
                case '(':stack[top++]=')';break;
                case '[':stack[top++]=']';break;
                case '{':stack[top++]='}';break;
                default:if(top==0 || stack[--top]!=c) return false;
            }
        }
        return top==0;
    }

    public static void main(String[] args) {
        String s = "[";
        System.out.println(isValidSim(s));
    }
}
