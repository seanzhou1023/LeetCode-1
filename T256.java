/**
 * Created by eric on 3/19/17.
 */
public class T256 {
    public static int minCost(int[][] costs){
        if(costs==null || costs.length<1 || costs[0].length<1) return 0;
        int row = costs.length;
        int R = 0, B = 0, G = 0;
        for(int[] cost: costs){
            int r = R, b = B, g = G;
            R = Math.min(b,g)+cost[0];
            B = Math.min(g,r)+cost[1];
            G = Math.min(r,b)+cost[2];
        }
        return Math.min(Math.min(R,B),G);
    }

    public static void main(String[] args) {
        int[][] costs = {{7,6,2}};
        System.out.println(minCost(costs));
    }
}
