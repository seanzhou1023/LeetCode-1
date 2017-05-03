/**
 * Created by eric on 3/15/17.
 */
public class T420 {
    private static boolean check(char o, char s, char e){
        return o-s>=0 && o-e<=0;
    }
    private static boolean[] isStrong(String s){
        boolean[] res = new boolean[3];
        char[] sc = s.toCharArray();
        int len = sc.length;
        res[0] = len<=20 && len>=6;
        boolean hasUpper = false, hasLower = false, hasDigit = false;
        for(int i=0;i<len;i++){
            hasLower |= check(sc[i],'a','z');
            hasUpper |= check(sc[i],'A','Z');
            hasDigit |= check(sc[i],'0','9');
        }
        res[1] = hasLower && hasUpper && hasDigit;
        res[2] = true;
        for(int i=0;i<len-2;i++)
            if(sc[i]==sc[i+1] && sc[i+1]==sc[i+2]){
                res[2] = false;break;
            }
        return res;
    }
    public static int strongPasswordChecker(String s){
        boolean[] isStrong = isStrong(s);
        if(isStrong[0] && isStrong[1] && isStrong[2]) return 0;
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        System.out.println(strongPasswordChecker("1fhsssdIh43"));
    }
}
