import java.util.Arrays;

/**
 * Created by eric on 3/21/17.
 */
public class T455 {
    public static int findContentChildren(int[] g, int[] s){
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0;
        for(int j=0;i<g.length && j<s.length;j++)
            if(g[i]<s[j]) i++;
        return i;
    }
}
