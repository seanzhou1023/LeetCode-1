/**
 * Created by eric on 4/13/17.
 */
public class T521 {
    public int findLUSlength(String a, String b){
        if(a.equals(b))
            return -1;
        else return Math.max(a.length(),b.length());
    }
}
