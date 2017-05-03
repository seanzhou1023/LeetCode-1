import java.util.*;

/**
 * Created by eric on 3/17/17.
 */
public class T536 {
    public static TreeNode str2tree(String s){
        if(s.length()<1) return null;
        Stack<TreeNode> stack = new Stack<>();
        int start = 0, len = s.length();
        while(start<len){
            int num = 0, sign = 1;
            boolean isNum = false;
            if(start<len && s.charAt(start)=='(') start++;
            if(s.charAt(start)=='-') {sign = -1;start++;}
            while(start<len && (s.charAt(start)>='0' && s.charAt(start)<='9')){//get the number
                num = 10*num + (s.charAt(start)-'0');
                start++;isNum = true;
            }
            if(isNum) stack.push(new TreeNode(num*sign));//push the node into stack
            while(start<len && s.charAt(start)==')'){//connect the nodes
                TreeNode top = null;
                top = stack.pop();
                if(stack.peek().left==null) stack.peek().left = top;
                else stack.peek().right = top;
                start++;
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String str = "4(2(3)(1))(6(5))";
        System.out.println(str2tree(str).right.left.val);
    }
}
