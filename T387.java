/**
 * Created by eric on 2/16/17.
 */
public class T387 {
    public int firstUniqChar(String s){
        if(s==null || s.length()<1)
            return -1;
        if(s.length()==1)
            return 0;
        int[] table = new int[26];
        for(int i=0;i<s.length();i++)
            table[s.charAt(i)-'a']++;
        for(int i=0;i<s.length();i++)
            if(table[s.charAt(i)-'a']==1){
                return i;
            }
        return -1;
    }
}
