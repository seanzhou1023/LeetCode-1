import java.util.Arrays;

/**
 * Created by eric on 4/13/17.
 */
public class T189 {
    public static void reverse(int[] nums, int i, int j){
        while(i<j){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++; j--;
        }
    }
    public static void rotate(int[] nums, int k){
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k%(nums.length)-1);
        reverse(nums,k%(nums.length),nums.length-1);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        rotate(nums,2);
        System.out.println(Arrays.toString(nums));
    }
}
