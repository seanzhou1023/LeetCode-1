/**
 * Created by eric on 3/29/17.
 */
public class T198 {
    public static int rob(int[] nums){
        int[] in = new int[nums.length];
        in[0] = nums[0];
        int[] out = new int[nums.length];
        for(int i=1;i<nums.length;i++){
            in[i] = Math.max(out[i-1]+nums[i],in[i-1]);
            out[i] = Math.max(out[i-1],in[i-1]);
        }
        return Math.max(in[nums.length-1],out[nums.length-1]);
    }
}
