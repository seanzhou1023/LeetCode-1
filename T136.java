/**
 * Created by eric on 2/12/17.
 */
public class T136 {
    public static int singleNumber(int[] nums){
        int res = 0;
        for(int i=0;i<nums.length;i++)
            res ^= nums[i];
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,3,4,3,4,5};
        System.out.println(singleNumber(nums));
    }
}
