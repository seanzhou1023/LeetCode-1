import java.util.ArrayList;
import java.util.List;

/**
 * Created by eric on 3/9/17.
 */
public class T320 {
    public static void dfs(List<String> res,StringBuilder sb,
                                   char[] abbr, int i, int cnt){
        int len = sb.length();
        if(i==abbr.length){
            if(cnt>0) sb.append(cnt);
            res.add(sb.toString());
        }else{
            dfs(res,sb,abbr,i+1,cnt+1);
            if(cnt!=0) sb.append(cnt);
            sb.append(abbr[i]);
            dfs(res,sb,abbr,i+1,0);
        }
        sb.setLength(len);
    }
    public static List<String> generateAbbreviations(String word){
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(res,sb,word.toCharArray(),0,0);
        return res;
    }

    public static void main(String[] args) {
        String word = "word";
        System.out.println(generateAbbreviations(word));
    }
}
