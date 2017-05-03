/**
 * Created by eric on 2/13/17.
 */
public class T266 {
    public static boolean canPermutePalindrome(String s){
        if(s==null || s.length()<1)
            return false;
        if(s.length()==1)
            return true;
        int[] table = new int[128];
        int flag = 0;
        for(int i=0;i<s.length();i++)
            table[s.charAt(i)-(char)0]++;
        for(int i=0;i<table.length;i++){
            if(table[i]%2==1)
                flag++;
        }
        return flag<=1;
    }

    public static void main(String[] args) {
        String s = "code";
        boolean res = canPermutePalindrome(s);
    }
}
