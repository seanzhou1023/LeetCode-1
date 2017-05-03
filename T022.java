import java.util.*;

/**
 * Created by eric on 3/15/17.
 * understand the recursion
 */
public class T022 {
    static int level = 0;
    public static void addParenthesis(List<String> res, StringBuilder sb,
                                      int open, int close, int n){
        level++;
        Thread.dumpStack();
        if(open==0 && close==0){
            res.add(sb.toString());
            return ;
        }
        else{
            if(open>0){
                sb.append("(");
                addParenthesis(res,sb,open-1,close,n);
                sb.setLength(sb.length()-1);
            }
            if(close>open){
                sb.append(")");
                addParenthesis(res,sb,open,close-1,n);
                sb.setLength(sb.length()-1);
            }
        }
    }
    public static List<String> generateParenthesis(int n){
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        addParenthesis(res,sb,n,n,n);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(2));
    }
}
