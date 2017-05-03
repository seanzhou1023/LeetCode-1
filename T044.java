/**
 * Created by eric on 2/26/17.
 */
public class T044 {
    public static boolean isMatch(String s, String p){
        int slen = s.length(), plen = p.length();
        if(plen==0)
            return slen==0;
        else if(p=="*")
            return true;
        boolean[][] res = new boolean[slen+1][plen+1];
        res[0][0] = true;
        for(int i=0;i<slen+1;i++){
            if(p.charAt(0)=='*') res[i][0] = true;
        }
        for(int i=1;i<plen+1;i++){
            if(p.charAt(i-1)=='*') res[0][i] = res[0][i-1];
        }
        for(int i=1;i<slen+1;i++)
            for(int j=1;j<plen+1;j++){
                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?'){
                    res[i][j] = res[i-1][j-1];
                }else if(p.charAt(j-1)=='*'){
                    res[i][j] = res[i-1][j] || res[i][j-1];
                }
            }
        return res[slen][plen];
    }

    public static void main(String[] args) {
        String s = "", p = "*";
        System.out.println(isMatch(s,p));
    }
}
