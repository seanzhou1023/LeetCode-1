/**
 * Created by eric on 2/28/17.
 */
public class T153 {
    public static int findMin(int[] nums, int start, int end){
        if(start>end) return Integer.MAX_VALUE;
        int mid = (start+end)/2;
        if(nums[mid]<nums[mid+1] && nums[mid]<nums[mid-1])
            return nums[mid];
        else if(nums[mid]<=nums[end] && nums[mid]<=nums[start])
            return findMin(nums,start,mid-1);
        else if(nums[mid]>=nums[end] && nums[mid]>=nums[start])
            return findMin(nums,mid+1,end);
        else
            return nums[start];
    }
    public static int findMin(int[] nums){
        int res = Math.min(nums[0],nums[nums.length-1]);
        return Math.min(res,findMin(nums,1,nums.length-2));
    }
    public static int findMinIterative(int[] nums){
        int start = 0, end = nums.length-1;
        if(nums[start]<=nums[end]) return nums[0];
        while(start+1<end){
            System.out.println(nums[start]+":"+nums[end]);
            int mid = (start+end)/2;
            if(nums[mid]<Math.min(nums[mid-1],nums[mid+1]))
                return nums[mid];
            else if(nums[start]<nums[mid]) start = mid;
            else end = mid;
        }
        return Math.min(nums[start],nums[end]);
    }
    public static int test(int[] nums){
        int len = nums.length;
        int low = 0, high = len - 1;
        if (nums[0] < nums[len - 1]) return nums[0];
        while (low + 1 < high){
            int mid = low + (high - low)/2;
            if (nums[low] > nums[mid]){
                high = mid;
            }else{
                low = mid;
            }
        }
        return Math.min(nums[low], nums[high]);
    }
    public static void main(String[] args) {
        int[] nums = {5};
        System.out.println(test(nums));
    }
}
