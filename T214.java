import java.util.Arrays;

/**
 * Created by eric on 4/1/17.
 * review KMP pattern matching
 * the new table would be out of bound if original string was already palindrome
 * the reason to add a "#" between the concat strings
 */
public class T214 {
    public static String shortestPalindrome(String s){
        if(s.length()<2) return s;
        int len = s.length();
        char[] strC = s.toCharArray();
        char[] newStrC = new char[2*len+1];
        System.arraycopy(strC,0,newStrC,0,len);
        newStrC[len] = '#';
        for(int i=2*len;i>len;i--) newStrC[i] = newStrC[2*len-i];
        int[] table = new int[2*len+1];
        int i = 1,j = 0;
        while(i<table.length){
            if(newStrC[i]==newStrC[j]){
                table[i] = j+1;
                i++;j++;
            }else{
                if(j==0) i++;
                else j=table[j-1];
            }
        }
        System.out.println(Arrays.toString(table));
        int addLen = len-table[2*len];
        char[] res = new char[addLen+len];
        System.arraycopy(newStrC,len+1,res,0,addLen);
        System.arraycopy(strC,0,res,addLen,len);
        return new String(res);
    }

    public static void main(String[] args) {
        String s = "abac";
        System.out.println(shortestPalindrome(s));
    }
}
