import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by eric on 3/5/17.
 */
public class T290 {
    public static boolean wordPattern(String pattern, String str){
        if(pattern.length()<1 && str.length()<1) return true;
        String[] s = str.trim().split(" ");
        if(pattern.length()!=s.length) return false;
        else{
            Map<Object,Integer> to = new HashMap<>(s.length);
            for(int i=0;i<s.length;i++){
                if(!Objects.equals(to.put(pattern.charAt(i),i),to.put(s[i],i))){
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
//        The JVM is caching Integer values. == only works for numbers between -128 and 127
        String pattern = "ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdd";
        String str = "s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s t t";
        System.out.println(wordPattern(pattern,str));
    }
}
