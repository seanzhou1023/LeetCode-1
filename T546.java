import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by eric on 3/26/17.
 * brute force - O(n!)
 */
public class T546 {
    public static int remove(int[] boxes){
        if(boxes.length==0) return 0;
        int res = 0;
        for(int i=0, j=i+1;i<boxes.length;i++){
            while(j<boxes.length && boxes[i]==boxes[j]) j++;
            int[] newBoxes = new int[boxes.length-(j-i)];
            for(int k=0, p=0;k<boxes.length;k++){
                if(k==i) k=j;
                if(k<boxes.length) newBoxes[p++] = boxes[k];
            }
            res = Math.max(res,remove(newBoxes)+(j-i)*(j-i));
        }
        return res;
    }
    public static int removeBoxes(int[] boxes){
        return remove(boxes);
    }
    public static int calculate(int[] boxes, int[][][] dp, int l, int r, int k){
        if(l>r) return 0;
        if(dp[l][r][k]!=0) return dp[l][r][k];
        dp[l][r][k] = calculate(boxes, dp, l, r-1, 0) + (k+1)*(k+1);
        for(int i=l;i<r;i++){
            if(boxes[i]==boxes[r]){
                dp[l][r][k] = Math.max(dp[l][r][k], calculate(boxes, dp, i+1, r-1, 0) +
                        calculate(boxes, dp, l, i, k+1));
            }
        }
        return dp[l][r][k];
    }
    public static int removeBoxesDP(int[] boxes){
        int[][][] dp = new int[100][100][100];
        return calculate(boxes,dp,0,boxes.length-1,0);
    }

    public static void main(String[] args) {
        int[] boxes = {1,3,2,2,2,3,4,3,1};
        System.out.println(removeBoxesDP(boxes));
    }
}
