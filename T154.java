/**
 * Created by eric on 3/21/17.
 * correct value vs. correct idx
 */
public class T154 {
    public static int findMin(int[] nums){
        int s = 0, e = nums.length-1, mid;
        while(s<e){
            mid = s + (e-2)/2;
            if(nums[mid]>nums[e]) s = mid+1;
            else if(nums[mid]<nums[e]) e = mid;
            else e--;
        }
        return nums[s];
    }
}
