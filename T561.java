import java.util.Arrays;

/**
 * Created by eric on 4/22/17.
 */
public class T561 {
    public int arrayPairSum(int[] nums){
        Arrays.sort(nums);
        int res = 0;
        for(int i=0;i<nums.length;i = i+2)
            res += nums[i];
        return res;
    }
}
