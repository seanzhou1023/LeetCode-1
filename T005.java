import java.util.Arrays;

/**
 * Created by eric on 2/26/17.
 */
public class T005 {
    public static String longestPalindrome(String s){
        if(s.length()==1) return s;
        if(s.length()==2){
            if(s.charAt(0)==s.charAt(1)) return s;
            else return s.substring(1);
        }
        int right = 0, c = 0, len = 2*s.length()+1;
        int[] P = new int[len];
        char[] T = new char[len];
        int maxC = 0, maxL = 0;
        for(int i=0;i<s.length();i++){
            T[2*i+1] = s.charAt(i);
        }
        for(int i=1;i<len;i++){
            int mirror = 2*c - i;
            if(i<right)
                P[i] = Integer.min(P[mirror], right-i);
            while((i+(1+P[i]))<len && (i-(1+P[i]))>=0 &&
                    T[i+(1+P[i])]==T[i-(1+P[i])]){
                P[i]++;
            }
            if(i+P[i]>right){
                c = i;
                right = i + P[i];
            }
            if(P[i]>maxL){
                maxC = i;
                maxL =P[i];
            }
            System.out.println("i:"+i+" c:"+c+" r:"+right+" m:"+mirror);
        }
        System.out.println(Arrays.toString(P));
        String res = "";
        for(int i=maxC-maxL;i<maxC+maxL;i++){
            res += Character.toString(T[i]);
        }
        return res.replace(Character.toString((char)0),"");
    }
    public static void main(String[] args) {
        String s = "abcda";
        System.out.println(longestPalindrome(s));
    }
}
