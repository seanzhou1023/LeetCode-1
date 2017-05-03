import java.util.Arrays;

/**
 * Created by eric on 3/15/17.
 */
public class T541 {
    public static String reverseStr(String s, int k) {
        if (s == null || s.length() < 2 || k == 1) return s;
        char[] c = s.toCharArray();
        int start, end;
        for (int i=0;i<c.length;i+=2*k) {
            start=i; end=Math.min(i+k-1,c.length-1);
            while (start < end) {
                char tmp = c[start];
                c[start++] = c[end];
                c[end--] = tmp;
            }
        }
        return new String(c);
    }

    public static void main(String[] args) {
        String s = "abcdefg"; int k = 2;
        System.out.println(reverseStr(s,k));
    }
}
