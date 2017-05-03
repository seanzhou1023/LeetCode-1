import java.util.*;

/**
 * Created by eric on 3/5/17.
 */
public class T017 {
    public static void helper(String digits, List<String> res, String[] panel){
        for(int i=0;i<digits.length();i++){
            int cur = digits.charAt(i)-'0';
            String curStr = panel[cur-2];
            if(res.size()==0){
                for(int j=0;j<curStr.length();j++){
                    res.add(Character.toString(curStr.charAt(j)));
                }
            }else{
                List<String> temp = new ArrayList<>();
                temp.addAll(res);
                res.clear();
                for(String str:temp)
                    for(int j=0;j<curStr.length();j++)
                        res.add(str+Character.toString(curStr.charAt(j)));
            }
        }
    }
    public static List<String> letterCombinations(String digits){
        String[] panel = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> res = new ArrayList<>();
        helper(digits,res,panel);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
