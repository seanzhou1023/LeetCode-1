import java.util.Arrays;

/**
 * Created by eric on 2/26/17.
 */
public class T010 {
    public static boolean isMatch(String s, String p){
        int slen = s.length(), plen = p.length();
        boolean[][] res = new boolean[slen+1][plen+1];
        res[0][0] = true;
        for(int i=1;i<plen+1;i++){
            if(i==2){
                if(p.charAt(i-1)=='*'){
                    res[0][1] = res[0][2] = true;
                }
            }
            else if(i%2==0){
                if(p.charAt(i-1)=='*'){
                    res[0][i-1] = res[0][i] = res[0][i-2];
                }
            }
        }
        for(int i=1;i<slen+1;i++)
            for(int j=1;j<plen+1;j++){
                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='.')
                    res[i][j] = res[i-1][j-1];
                if(p.charAt(j-1)=='*'){
                    res[i][j] = res[i][j-2];
                    if(s.charAt(i-1)==p.charAt(j-2) || p.charAt(j-2)=='.')
                        res[i][j] = res[i][j] || res[i-1][j];
                }
            }
        return res[slen][plen];
    }

    public static void main(String[] args) {
        String s = "aa", p = "a*";
        System.out.println(isMatch(s,p));
    }
}
