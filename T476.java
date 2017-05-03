/**
 * Created by eric on 4/15/17.
 */
public class T476 {
    public static int findComplement(int num){
        int n = num, shift = 0, res = 0;
        while(n>0){
            if((n&1)==0) res += (1 << shift);
            shift++;
            n >>= 1;
        }
        return num==0?1:res;
    }

    public static void main(String[] args) {
        System.out.println(findComplement(5));
    }
}
