import java.util.Arrays;

/**
 * Created by eric on 4/22/17.
 */
public class T564 {
    public boolean isPalin(char[] nc){
        int i=0, j = nc.length-1;
        while(i<j){
            if(nc[i++]!=nc[j--]) return false;
        }
        return true;
    }
    public String findSmaller(char[] nc, String n){
        String str = new String(nc);
        long n1 = Long.valueOf(str);
        long n0 = Long.valueOf(n);
        if(n1>n0){
            long n2 = n0-(n1-n0);
            String n2Str = n2+"";
            if(isPalin(n2Str.toCharArray())) return n2Str;
        }
        return str;
    }
    public String nearestPalindromic(String n){
        char[] nc = n.toCharArray();
        if(isPalin(nc)){
            if(nc.length==2){
                int num = Integer.valueOf(n)-1;
                nc = (num+"").toCharArray();
                while(!isPalin(nc)){
                    num = Integer.valueOf(new String(nc));
                    num--;
                    nc = (num+"").toCharArray();
                }
            }else{
                if(nc.length%2==1){
                    nc[nc.length/2] = nc[nc.length/2]>'0'?(char)(nc[nc.length/2]-1):'9';
                }else{
                    nc[nc.length/2] = nc[nc.length/2]>'0'?(char)(nc[nc.length/2]-1):'9';
                    nc[nc.length/2-1] = nc[nc.length/2];
                }
            }
        }else{
            int i = 0, j = nc.length-1;
            while(!isPalin(nc)){
                if(nc[i]!=nc[j]) nc[j] = nc[i];
                i++;j--;
            }
        }
        String smaller = findSmaller(nc,n);
        return smaller;
    }

    public static void main(String[] args) {
        T564 t = new T564();
        System.out.println(t.nearestPalindromic("11"));
    }

}
