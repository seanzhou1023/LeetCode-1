/**
 * Created by eric on 3/9/17.
 */
public class T035 {
    public static int searchInsert(int[] nums, int target){
        int start = 0, end = nums.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]>target){
                if(mid==start || nums[mid-1]<target) return mid;
                end = mid-1;
            }else{
                if(mid==end || nums[mid+1]>target) return mid+1;
                start = mid+1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int tgt = 2;
        System.out.println(searchInsert(nums,tgt));
    }
}
