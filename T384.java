import java.util.Arrays;
import java.util.Random;

/**
 * Created by eric on 3/16/17.
 * Yates Shuffle
 */
public class T384 {
    public static class Solution {
        private int[] nums,output;
        private Random random;
        public Solution(int[] nums) {
            this.nums = nums;
            output = new int[nums.length];
            for(int i=0;i<nums.length;i++)
                output[i] = nums[i];
            this.random = new Random();
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return nums;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            for(int i=0;i<output.length;i++){
                int idx = random.nextInt(output.length-i);
                int temp = output[i];
                output[i] = output[i+idx];
                output[i+idx] = temp;
            }
            return output;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        Solution s = new Solution(nums);
        Random r = new Random();
        for(int i=0;i<10;i++)
            System.out.println(r.nextFloat());
    }
}
