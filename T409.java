/**
 * Created by eric on 2/13/17.
 */
public class T409 {
    public static int longestPalindrome(String s){
        int[] table = new int[52];
        int res = 0, flag = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c-'a'>=0)
                table[c-'a']++;
            else
                table[c-'A'+26]++;
        }
        for(int i=0;i<table.length;i++){
            if(table[i]%2==1)
                flag = 1;
            res+=table[i]/2;
        }
        return res*2+flag;
    }
    public static int longestPalindrome1(String s) {
        int[] isOdd = new int[52];
        for(char c : s.toCharArray())
            if(c-'a'>=0) isOdd[c-'a'+26] ^= 1;
            else isOdd[c-'A'] ^= 1;
        int count = 0, len=s.length();
        for(int b : isOdd)
            if(b==1) count++;
        return Math.min(len, len - count + 1);
    }
    public static int longestPalindrome2(String s) {
        int[] isOdd = new int[52];
        for(char c : s.toCharArray()) isOdd[c-'a'>=0?c-'a'+26:c-'A'] ^= 1;
        int count = 0, len = s.length();
        for(int b : isOdd) if(b==1) count++;
        return count==0?len:len-count+1;
    }
    public static void main(String[] args) {
        for(int k=0;k<10;k++){
        long t0 = System.currentTimeMillis();
        for(int i=0;i<10000000;i++)
            longestPalindrome1("adfhaodfAhoahfadafjfffhffffafdhfadsoh");
        long t1 = System.currentTimeMillis();
        System.out.println(t1-t0);}
    }
}
