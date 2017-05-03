/**
 * Created by eric on 3/16/17.
 */
public class T540 {
    public static int singleNonDuplicate(int[] nums){
        int start = 0, end = nums.length-1;
        if(nums[start]!=nums[start+1]) return nums[start];
        if(nums[end]!=nums[end-1]) return nums[end];
        while(start<=end){
            int mid = start + (end-start)/2;
            if(nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1]) return nums[mid];
            else if(nums[mid-1] == nums[mid]){
                if(mid%2==0) end=mid-2;
                else start=mid+1;
            }else{
                if(mid%2==0) start=mid+2;
                else end = mid-1;
            }
        }
        return -1;
    }
    public static int singleNonDuplicate1(int[] nums){
        int lo = 0, hi = nums.length/2;
        while(lo<hi){
            int mid = lo + (hi-lo)/2;
            if(nums[2*mid]!=nums[2*mid+1]) hi = mid-1;
            else lo = mid+1;
        }
        return nums[2*lo];
    }
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println(singleNonDuplicate1(nums));
    }
}
