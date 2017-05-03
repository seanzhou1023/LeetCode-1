package methods;

import java.util.Arrays;

/**
 * Created by eric on 4/1/17.
 * have bugs
 */
public class KMP {
    public static int[] createPrefix(String pattern){
        char[] sc = pattern.toCharArray();
        int[] table = new int[sc.length];
        int j=0,i=1;
        while(i<sc.length){
            if(sc[j]==sc[i]){
                table[i] = j+1;
                j++;i++;
            }else{
                if(table[i-1]==0) i++;
                else{
                    if(j==0 && i==sc.length-1) break;
                    else j = j>0?table[j-1]:0;
                }
            }
        }
        System.out.println(Arrays.toString(table));
        return table;
    }
    public static int kmp(String pattern, String str){
        int[] table = createPrefix(pattern);
        int i=0,j=0;
        while(j<str.length()){
            if(pattern.charAt(i)==str.charAt(j)){
                i++;j++;
                if(i==pattern.length()) return j-pattern.length();
            }else{
                if(i==0) j++;
                i = i>0?table[i-1]:0;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String pattern = "abcbayabcba";
        createPrefix(pattern);
//        System.out.println(kmp(pattern,"abxabcabcaby"));
    }
}
