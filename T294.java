import java.util.HashMap;

/**
 * Created by eric on 2/15/17.
 */
public class T294 {
    public static boolean canWin(String s, HashMap<String, Boolean> hm){
        if(hm.containsKey(s))
            return hm.get(s);
        for(int i=0;i<s.length()-1;i++){
            if(s.startsWith("++",i)){
                String t = s.substring(0,i)+"--"+s.substring(i+2);
                if(!canWin(t,hm)){
                    hm.put(s,true);
                    return true;
                }
            }
        }
        hm.put(s,false);
        return false;
    }
    public static boolean canWin(String s){
        if(s==null||s.length()<2)
            return false;
        HashMap<String, Boolean> hm = new HashMap<>();
        return canWin(s, hm);
    }

    public static void main(String[] args) {
        String s = "++";
        System.out.println(canWin(s));
    }
}
