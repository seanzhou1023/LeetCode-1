/**
 * Created by eric on 3/20/17.
 */
public class T201 {
    public static int rangeBitwiseAnd(int m, int n){
        int x = m&n, cnt=0, y = m^n;

        while(y!=0){
            y = y >>> 1;
            cnt++;
        }
        int mm = m, nn = n;cnt--;
        while(mm!=0){
            mm >>= 1;
            nn >>= 1;
        }
        return nn==0?(x>>cnt<<cnt):0;
    }

    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(213123,243443));
    }
}
