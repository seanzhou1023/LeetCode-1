import java.util.Arrays;

/**
 * Created by eric on 3/19/17.
 * maintain a two min array (we only need two min)
 */
public class T265 {
    public static void getTwoMins(int[] twoMins, int[] curCost){
        Arrays.fill(twoMins,Integer.MAX_VALUE);
        for(int i=0;i<curCost.length;i++){
            if(curCost[i]<twoMins[3]){
                twoMins[2] = i;
                twoMins[3] = curCost[i];
                if(twoMins[1]>twoMins[3]){
                    int idx = twoMins[0], val = twoMins[1];
                    twoMins[0] = twoMins[2];
                    twoMins[1] = twoMins[3];
                    twoMins[2] = idx;
                    twoMins[3] = val;
                }
            }
        }
    }
    public static int minCostII(int[][] costs){
        if(costs==null || costs.length<1 || costs[0].length<1) return 0;
        int k = costs[0].length;
        int n = costs.length;
        int[] twoMins = new int[4];
        int[] curCost = new int[k];
        for(int i=0;i<n;i++){
            for(int j=0;j<k;j++){
                curCost[j] = (j!=twoMins[0]?twoMins[1]:twoMins[3])+costs[i][j];
            }
            getTwoMins(twoMins,curCost);
        }
        int res = Integer.MAX_VALUE;
        for(int cost: curCost) res = res<cost?res:cost;
        return res;
    }

    public static void main(String[] args) {
        int[][] costs = {{1,5,3},{2,9,4}};
        System.out.println(minCostII(costs));
    }
}
