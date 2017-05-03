import java.util.*;

/**
 * Created by eric on 4/14/17.
 * without constraint bfs too slow - 93ms
 * difficult to understand - 3ms
 * https://discuss.leetcode.com/topic/34875/easy-short-concise-and-fast-java-dfs-3-ms-solution
 * easier to understand: - 8ms - next time try this one
 * https://discuss.leetcode.com/topic/30743/easiest-9ms-java-solution
 */
public class T301 {
    public static boolean isValid(String s){
        if(s.length()<1) return true;
        char[] stack = new char[s.length()];
        int top = 0;
        for(char c: s.toCharArray()){
            if(c!='(' && c!=')') continue;
            if(c=='(') stack[top++] = ')';
            else if(top==0 || stack[--top]!=c) return false;
        }
        return top==0;
    }
    public static List<String> removeInvalidParentheses(String s){
        List<String> res = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        int left = 0, right = 0;
        for(char c:s.toCharArray()){
            if(c=='(') left++;
            else if(c==')'){
                if(left>0) left--;
                else right++;
            }
        }
        int level = left + right;
        int curLevel = -1;
        queue.offer(s);
        while(true){
            int size = queue.size();
            Set<String> state = new HashSet<>();
            curLevel++;
            for(int i=0;i<size;i++){
                String curStr = queue.poll();
                if(curLevel==level){
                    if(isValid(curStr)){
                        if(!set.contains(curStr)){
                            res.add(curStr);
                            set.add(curStr);
                        }
                    }
                    continue;
                }
                for(int p=0;p<curStr.length();p++){
                    char curChar = curStr.charAt(p);
                    if(curChar!='(' && curChar!=')') continue;
                    String toAdd = curStr.substring(0,p) +
                            curStr.substring(p+1,curStr.length());
                    if(!state.contains(toAdd)){
                        queue.add(toAdd);
                        state.add(toAdd);
                    }
                }
            }
            if(res.size()!=0) return res;
        }
    }

    public static void main(String[] args) {
        String s = "()())()";
        System.out.println(isValid("("));
        System.out.println(removeInvalidParentheses(s));
    }
}
