import java.util.Arrays;

/**
 * Created by eric on 3/21/17.
 * dp is too slow
 */
public class T045 {
    public static int jumpDP(int[] nums){
        int len = nums.length;
        int[] jumps = new int[len];
        Arrays.fill(jumps,Integer.MAX_VALUE);jumps[0] = 0;
        int[] idx = new int[len];idx[0] = -1;
        for(int i=1;i<len;i++)
            for(int j=0;j<i;j++){
                if(nums[j]+j>=i){
                    if(jumps[j]+1<jumps[i]) jumps[i] = jumps[j]+1;
                }
            }
        return jumps[len-1];
    }
    public static int jumpGreedy(int[] nums){
        int len = nums.length, curLongest = 0, lastLongest = 0;
        int jumps = 0;
        for(int i=0;i<len-2;i++){
            curLongest = Math.max(curLongest,i+nums[i]);
            if(lastLongest==i){
                jumps++;
                lastLongest = curLongest;
            }
        }
        return jumps;
    }
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(jumpGreedy(nums));
    }
}
