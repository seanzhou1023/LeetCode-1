/**
 * Created by eric on 1/24/17.
 */
public class T268 {
    public static int missingNumber(int[] nums){
        int res = 0;
        for(int i=0;i<nums.length;i++){
            res^=i;
            res^=nums[i];
        }
        return res^nums.length;
    }
}
