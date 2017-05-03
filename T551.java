/**
 * Created by eric on 4/15/17.
 */
public class T551 {
    public static boolean checkRecord(String s) {
        int cnt = 0;
        for(int i=0;i<s.length()-2;i++)
            if(s.charAt(i)==s.charAt(i+1) && s.charAt(i+1)==s.charAt(i+2)
                    && s.charAt(i)=='L') return false;
        for(int i=0;i<s.length();i++)
            if(s.charAt(i)=='A') cnt++;
        return cnt<2;
    }

    public static void main(String[] args) {
        String s = "PPALLL";
        System.out.println(checkRecord(s));
    }
}
