/**
 * Created by eric on 1/30/17.
 */
public class T461 {
    public static int hammingDistance(int x, int y){
        int xor = x^y;
        int res = 0;
        while(xor>0){
            if(xor%2==1)
                res+=1;
            xor>>=1;
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(hammingDistance(4,1));
    }
}
