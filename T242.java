/**
 * Created by eric on 2/12/17.
 */
public class T242 {
    public static boolean isAnagram(String s, String t){
        if(s==null || t==null || s.length()!=t.length())
            return false;
        int[] table = new int[256];
        for(int i=0;i<s.length();i++)
            table[s.charAt(i)-(char)0]++;
        for(int j=0;j<t.length();j++)
            table[t.charAt(j)-(char)0]--;
        for(int i=0;i<256;i++){
            if(table[i]!=0)
                return false;
        }
        return true;
    }
}
