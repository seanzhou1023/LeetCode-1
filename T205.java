import java.util.HashMap;

/**
 * Created by eric on 3/4/17.
 */
public class T205 {
    public static boolean isIsomorphicHM(String s, String t){
        if(s.length()!=t.length()) return false;
        HashMap<Character,Character> hm1 = new HashMap<>();
        HashMap<Character,Character> hm2 = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char sc = s.charAt(i), tc = t.charAt(i);
            if(hm1.containsKey(sc)){
                if(hm1.get(sc)!=tc) return false;
            }else{
                hm1.put(sc,tc);
            }
            if(hm2.containsKey(tc)){
                if(hm2.get(tc)!=sc) return false;
            }else{
                hm2.put(tc,sc);
            }
        }
        return true;
    }
    public static boolean isIsomorphic(String s, String t){
        if(s.length()!=t.length()) return false;
        int[] sarray = new int[256];
        int[] tarray = new int[256];
        for(int i=0;i<s.length();i++){
            if(sarray[s.charAt(i)]!=tarray[t.charAt(i)])
                return false;
            sarray[s.charAt(i)] = tarray[t.charAt(i)] = i+1;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "ab", t = "aa";
        System.out.println(isIsomorphic(s,t));
    }
}
