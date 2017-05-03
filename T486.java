import java.util.Arrays;

/**
 * Created by eric on 3/3/17.
 */
public class T486 {
    public static boolean PredictTheWinner(int[] nums){
        int len = nums.length;
        int[][] first = new int[len][len];
        int[][] second = new int[len][len];
        int[] lSum = new int[len+1];
        for(int i=0;i<len;i++){
            first[i][i] = nums[i];
            lSum[i+1] = lSum[i]+nums[i];
        }
        for(int k=1;k<len;k++)
            for(int i=0;i+k<len;i++){
                int lRemv = nums[i]+second[i+1][i+k];
                int rRemv = nums[i+k]+second[i][i+k-1];
                first[i][i+k] = lRemv>rRemv?lRemv:rRemv;
                second[i][i+k] = lSum[i+k+1]-lSum[i]-first[i][i+k];
            }
//        for(int i=0;i<len;i++)
//            System.out.println(Arrays.toString(first[i]));
//        for(int i=0;i<len;i++)
//            System.out.println(Arrays.toString(second[i]));
        return first[0][len-1]>=second[0][len-1];
    }

    public static void main(String[] args) {
        int[] nums = {0,0,7,6,5,6,1};
        System.out.println(PredictTheWinner(nums));
    }
}
