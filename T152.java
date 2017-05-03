import java.util.Arrays;

/**
 * Created by eric on 2/10/17.
 */
public class T152 {
    public static int maxProduct(int[] nums){
        if(nums.length<0)
            return 0;
        if(nums.length==1)
            return nums[0];
        int len = nums.length;
        int res, curMax, curMin;
        res = curMax = curMin = nums[0];
        for(int i=1;i<len;i++){
            int temp = curMax;
            curMax = Math.max(Math.max(curMax*nums[i],curMin*nums[i]),nums[i]);
            curMin = Math.min(Math.min(temp*nums[i],curMin*nums[i]),nums[i]);
            if(res<curMax)
                res = curMax;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-3,0,1,-2};
        System.out.println(maxProduct(nums));
    }
}
