/**
 * Created by eric on 3/12/17.
 */
public class T161 {
    public static boolean isOneEditDistance(String s, String t){
        int len1 = s.length(), len2 = t.length();
        if(len1>len2) return isOneEditDistance(t,s);
        else if(len2-len1>1) return false;
        else{
            char[] sc = s.toCharArray(), tc = t.toCharArray();
            boolean sameLen = (len1==len2);
            int cnt = sameLen?0:1;
            boolean jumpone = false;
            for(int i=0;i<len1;i++){
                if(sameLen){
                    if(sc[i]!=tc[i]) cnt++;
                }else{
                    if(jumpone){
                        if(sc[i]!=tc[i+1]) return false;
                    }else{
                        if(sc[i]!=tc[i]){
                            jumpone = true;
                            if(sc[i]!=tc[i+1]) return false;
                        }
                    }
                }
            }
            return cnt==1;
        }
    }

    public static void main(String[] args) {
        String s = "", t = "a";
        System.out.println(isOneEditDistance(s,t));
    }
}
