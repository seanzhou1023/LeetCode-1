/**
 * Created by eric on 2/26/17.
 */
public class T162 {
    public static int findPeakElement(int[] nums){
        if(nums.length==1) return 0;
        int start = 0, end = nums.length-1;
        if(nums[start]>nums[start+1]) return start;
        if(nums[end]>nums[end-1]) return end;
        return findPeak(nums,start+1,end-1);
    }
    public static int findPeak(int[] nums, int start, int end){
        int mid = (start + end)/2;
        if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1])
            return mid;
        else if(nums[mid]<nums[mid-1])
            return findPeak(nums,start,mid-1);
        else
            return findPeak(nums,mid+1,start);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(findPeakElement(nums));
    }
}
