import java.util.Arrays;

/**
 * Created by eric on 3/30/17.
 */
public class T034 {
    public static int[] searchRange(int[] nums, int target){
        int[] res = {-1,-1};
        if(nums.length<1) return res;
        int s = 0, e = nums.length-1;
        while(s<e){
           int m = s+(e-s)/2;
           if(nums[m]<target) s = m+1;
           else e = m;
        }
        if(nums[s]!=target) return res;
        else res[0] = s;
        e = nums.length-1;
        while(s<e){
           int m = s+(e-s)/2+1;
           if(nums[m]>target) e = m-1;
           else s = m;
        }
        res[1] = e;
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4};
        System.out.println(Arrays.toString(searchRange(nums,4)));
    }
}
