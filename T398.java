import java.util.Random;

/**
 * Created by eric on 3/20/17.
 */
public class T398 {
    static class Solution {
        int[] nums;
        Random random;
        public Solution(int[] nums) {
            this.nums = nums;
            random = new Random();
        }

        public int pick(int target) {
            int count = 0, result = -1;
            for(int i=0;i<nums.length;i++){
                if(nums[i]!=target) ;
                else if(random.nextInt(++count)==0) result = i;
            }
            return result;
        }
    }
}
