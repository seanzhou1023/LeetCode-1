import java.util.Arrays;

/**
 * Created by eric on 4/16/17.
 * next time use non built-in functions
 */
public class T434 {
    public static int countSegments(String s){
        String[] res = s.split(" ");
        int cnt = 0;
        for(String str: res)
            if(str.length()>=1) cnt++;
        return cnt;
    }

    public static void main(String[] args) {
        String s = ", , , ,        a, eaefa";
        System.out.println(Arrays.toString(s.split(" ")));
        System.out.println(countSegments(s));
    }
}
