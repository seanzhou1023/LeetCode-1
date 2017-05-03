package sedgewick;

import java.util.Arrays;

/**
 * Created by eric on 4/11/17.
 */
public class LSD {
    public static void lsd(String[] strs, int width){
        int len = strs.length;
        for(int i=width-1;i>=0;i--){
            int[] count = new int[27];
            String[] aux = new String[len];
            for(int j=0;j<len;j++)
                count[strs[j].charAt(i)-'a'+1]++;
            for(int j=0;j<26;j++)
                count[j+1] += count[j];
            for(int j=0;j<len;j++)
                aux[count[strs[j].charAt(i)-'a']++] = strs[j];
            for(int j=0;j<len;j++)
                strs[j] = aux[j];
        }
    }

    public static void main(String[] args) {
        String[] strs = {"dab","add","cab","fab","fee","bad","dad","bee","fed"};
        lsd(strs,3);
        System.out.println(Arrays.toString(strs));
    }
}
