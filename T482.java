import java.util.LinkedList;
import java.util.List;

/**
 * Created by eric on 4/3/17.
 * too slow! corner case: "-----"
 * solved: reverse stringbuilder, do not insert in front of it
 */
public class T482 {
    public static String licenseKeyFormatting(String s, int k){
        StringBuilder res = new StringBuilder();
        int cnt = 0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)!='-'){
                if(cnt!=0 && cnt%k==0) res.append('-');
                char cur = s.charAt(i);
                res.append((cur>=97 && cur<=122)?(char)(cur-32):cur);
                cnt++;
            }
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "2-4A0r7-4k";
        System.out.println(licenseKeyFormatting(s,3));
    }
}
