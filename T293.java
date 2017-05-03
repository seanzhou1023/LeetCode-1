import java.util.ArrayList;
import java.util.List;

/**
 * Created by eric on 2/14/17.
 */
public class T293 {
    public static List<String> generatePossibleNextMoves(String s){
        List<String> res = new ArrayList<>();
        if(s==null || s.length()<2)
            return res;
        int len = s.length();
        char[] ch = s.toCharArray();
        for(int i=0;i<len-1;i++){
            if(ch[i]=='+' && ch[i+1]=='+'){
                ch[i]=ch[i+1]='-';
                res.add(new String(ch));
                ch[i]=ch[i+1]='+';
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "++++";
        System.out.println(generatePossibleNextMoves(s));
    }
}
