import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by eric on 4/27/17.
 * brute-force: TLE 18/29
 * generate half, then combine the reverse
 */
public class T267 {
    public void dfs(char[] sc, List<String> res, StringBuilder sb,
                    boolean[] skip, int odd, char oddChar){
        if(sb.length()==sc.length){
            String ori = sb.toString();
            StringBuilder rev = new StringBuilder(sb);
            if(odd==1){
                res.add(ori+oddChar+rev.reverse().toString());
            }else res.add(ori+rev.reverse().toString());
            return ;
        }
        for(int i=0;i<sc.length;i++){
            if(skip[i]) continue;
            if(i>0 && sc[i-1]==sc[i] && !skip[i-1]) continue;
            sb.append(sc[i]);
            skip[i] = true;
            dfs(sc,res,sb,skip,odd,oddChar);
            skip[i] = false;
            sb.setLength(sb.length()-1);
        }
    }
    public List<String> generatePalindromes(String s){
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int odd = 0;
        int[] table = new int[128];
        List<Character> clist = new ArrayList<>();
        char oddChar = 'a';
        for(char c: s.toCharArray()) table[c]++;
        for(int i=0;i<table.length;i++){
            if(table[i]==0) continue;
            if(table[i]%2==1){
                odd++;
                oddChar = (char)i;
            }
            for(int j=0;j<table[i]/2;j++)
                clist.add((char)i);
        }
        if(odd>1) return res;
        char[] sc = new char[clist.size()];
        for(int i=0;i<sc.length;i++)
            sc[i] = clist.get(i);
        boolean[] skip = new boolean[sc.length];
        System.out.println(Arrays.toString(sc));
        dfs(sc,res,sb,skip,odd,oddChar);
        return res;
    }

    public static void main(String[] args) {
        T267 t = new T267();
        System.out.println(t.generatePalindromes("aabbcc"));
        StringBuilder sb = new StringBuilder("abc");
        sb.reverse();
//        System.out.println(sb.toString());
    }
}
