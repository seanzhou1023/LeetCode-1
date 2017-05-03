import java.util.*;

/**
 * Created by eric on 3/5/17.
 * next time using kmp
 */
public class T459 {
    public static boolean repeatedSubstringPattern(String s){
        if(s==null||s.length()<2) return false;
        int len = s.length();
        List<Integer> divs = new ArrayList<>();
        divs.add(1);
        for(int i=2;i*i<=len;i++){
            if(len%i==0){
                divs.add(i,len/i);
                if(i*i==len)
                    divs.remove(i);
            }
        }
        for(int i=0;i<divs.size();i++){
            int subLen = divs.get(i);
            String temp = s.substring(0,subLen);
            boolean cur = true;
            for(int k=1;k<len/subLen;k++){
                if(!temp.equals(s.substring(k*subLen,(k+1)*subLen))){
                    cur = false;
                    break;
                }
            }
            if(cur) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        String s = "bb";
        System.out.println(repeatedSubstringPattern(s));
    }
}
