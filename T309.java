import java.util.Arrays;

/**
 * Created by eric on 3/8/17.
 */
public class T309 {
    public static int maxProfit(int[] prices){
        if(prices==null || prices.length<2) return 0;
        int len = prices.length;
        int s1 = 0, s2 = 0, b1 = -prices[0];
        for(int i=1;i<=len;i++){
            int b0 = Math.max(b1,s2-prices[i-1]);
            int s0 = Math.max(s1,b1+prices[i-1]);
            b1 = b0;
            s2 = s1;
            s1 = s0;
        }
        return s1;
    }

    public static void main(String[] args) {
        int[] prices = {2,1,4};
        System.out.println(maxProfit(prices));
    }
}
