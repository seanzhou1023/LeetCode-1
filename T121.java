/**
 * Created by eric on 3/17/17.
 */
public class T121 {
    public static int maxProfit(int[] prices){
        if(prices.length<2) return 0;
        int minB = Integer.MAX_VALUE;
        int maxP = 0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<minB) minB = prices[i];
            maxP = prices[i]-minB>maxP?prices[i]-minB:maxP;
        }
        return maxP;
    }
}
