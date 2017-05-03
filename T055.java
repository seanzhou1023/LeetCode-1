import java.util.Arrays;

/**
 * Created by eric on 3/14/17.
 * normal DP time exceeded
 */
public class T055 {
    public static boolean canJump(int[] nums){
        int n = nums.length, farest = 0;
        for(int i=0;i<n;i++){
            if(i>farest) return false;
            else farest = Math.max(i+nums[i],farest);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        int[] nums2 = {3,2,1,0,4};
        int[] nums3 = {3,0,0,0};
        System.out.println(canJump(nums3));
    }
}
