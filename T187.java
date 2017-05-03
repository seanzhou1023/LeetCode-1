import java.util.*;

/**
 * Created by eric on 2/15/17.
 * just for curiosity, encode the string as a integer and then hash;
 * or not using hashmap
 */
public class T187 {
    public static int getNum(char c){
        if(c=='A') return 0;
        else if(c=='C') return 1;
        else if(c=='G') return 2;
        else return 3;
    }
    public static String getStr(int num){
        if(num==0) return "A";
        else if(num==1) return "C";
        else if(num==2) return "G";
        else return "T";
    }
    public static int encode(String s){
        int res = 0, digit = 1;
        for(int i=s.length()-1;i>=0;i--){
            res+=digit*getNum(s.charAt(i));
            digit*=4;
        }
        return res;
    }
    public static String decode(int num){
        int n = num;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<10;i++){
            sb.insert(0,getStr(n%4));
            n/=4;
        }
        return sb.toString();
    }
    public static List<String> findRepeatedDnaSequences(String s){
        if(s==null || s.length()<10)
            return new ArrayList<String>();
        List<String> res = new ArrayList<>();
        int MAXINT = 1048575;
        int[] hm = new int[MAXINT];
        for(int i=0;i<=s.length()-10;i++){
            int t = encode(s.substring(i,i+10));
            hm[t]++;
        }
        for(int i=0;i<MAXINT;i++)
            if(hm[i]>1)
                res.add(decode(i));
        return res;
    }
    public static List<String> findRepeatedDnaSequences1(String s){
        if(s==null||s.length()<10)
            return new ArrayList<String>();
        int[] table = new int[26];
        table['C'-'A'] = 1;
        table['G'-'A'] = 2;
        table['T'-'A'] = 3;
        Set<Integer> once = new HashSet<>();
        Set<Integer> twice = new HashSet<>();
        List<String> res = new ArrayList<>();
        for(int i=0;i<=s.length()-10;i++){
            int val = 0;
            for(int j = i;j<i+10;j++){
                val <<= 2;
                val |= table[s.charAt(j)-'A'];
            }
            if(!once.add(val) && twice.add(val))
                res.add(s.substring(i,i+10));
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(findRepeatedDnaSequences1(s));
    }
}
