/**
 * Created by eric on 3/21/17.
 */
public class T392 {
    public static boolean isSubsequence(String s, String t){
        int sLow = 0, tLow = 0, sLen = s.length(), tLen = t.length();
        while(tLow<tLen){
            if(t.charAt(tLow)==s.charAt(sLow)){
                if(sLow==sLen-1) return true;
                sLow++;
            }
            tLow++;
        }
        return false;
    }
    public static boolean isSub(String s, String t){
         if ((s == null || s.length() == 0 ) && t != null) return true;
         if ((s == null || s.length() == 0) && (t == null || t.length() == 0)) return true;
        int len1 = s.length(), len2 = t.length(), start = 0;
        for (int i = 0; i < len1; i++) {
            char cur = s.charAt(i);
            int idx = t.indexOf(cur,start);
            if(idx!=-1) start = idx + 1;
            else return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "acb", t = "ahbgdc";
        System.out.println(isSub(s,t));
    }
}
