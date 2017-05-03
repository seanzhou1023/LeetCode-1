/**
 * Created by eric on 3/29/17.
 *
 */
public class T213 {
    public static int rob(int[] nums){
        if(nums.length<1) return 0;
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0],nums[1]);
        int[] in = new int[nums.length-1];
        in[0] = nums[0];
        int[] out = new int[nums.length-1];
        for(int i=1;i<nums.length-1;i++){
            in[i] = Math.max(out[i-1]+nums[i],in[i-1]);
            out[i] = Math.max(in[i-1],out[i-1]);
        }
        int max = Math.max(in[nums.length-2],out[nums.length-2]);
        in = new int[nums.length-1];
        in[0] = nums[1];
        out = new int[nums.length-1];
        for(int i=2;i<nums.length;i++){
            in[i-1] = Math.max(out[i-2]+nums[i],in[i-2]);
            out[i-1] = Math.max(in[i-2],out[i-2]);
        }
        int max1 = Math.max(in[nums.length-2],out[nums.length-2]);
        return Math.max(max,max1);
    }

    public static void main(String[] args) {
        int[] nums = {0,0,0};
        System.out.println(rob(nums));
    }
}
