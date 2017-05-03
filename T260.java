import java.util.Arrays;

/**
 * Created by eric on 2/12/17.
 */
public class T260 {
    public static int[] singleNumber(int[] nums){
        if(nums.length==2 && nums[0]!=nums[1])
            return nums;
        int res = 0;
        for(int i=0;i<nums.length;i++)
            res ^= nums[i];
        int lastOne = res & ~(res-1);
        int num1 = 0, num2 = 0;
        for(int i=0;i<nums.length;i++){
            if((nums[i]&lastOne)>0)
                num1^=nums[i];
            else
                num2^=nums[i];
        }
        int[] result = {num1,num2};
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2,1,2,3,4,1};
        System.out.println(Arrays.toString(singleNumber(nums)));
    }
}
