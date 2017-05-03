/**
 * Created by eric on 4/16/17.
 * https://ratchapong.com/algorithm-practice/leetcode/arranging-coins
 */
public class T441 {
    public static int arrangeCoins(int n){
        int s = 0, e = n, m = 0;
        while(s<=e){
            m = s + (e-s)/2;
            if((0.5*m*m+0.5*m)<=n){
                s = m + 1;
            }else{
                e = m - 1;
            }
        }
        return s - 1;
    }
}
