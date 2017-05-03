/**
 * Created by eric on 3/17/17.
 */
public class T122 {
    public static int maxProfit(int[] prices){
        if(prices.length<2) return 0;
        int start = prices[0], sum = 0, maxP = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]) sum += prices[i]-prices[i-1];
            else{
                maxP += sum;
                sum = 0;
                start = prices[i];
            }
        }
        return maxP + sum;
    }

    public static void main(String[] args) {
        int[] p = {1,2,5,3,7};
        System.out.println(maxProfit(p));
    }
}
