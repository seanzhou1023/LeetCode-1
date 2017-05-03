/**
 * Created by eric on 3/9/17.
 */
public class T033 {
    public static int findMin(int[] nums) {
        int start = 0, end = nums.length-1;
        if(nums[start]<=nums[end]) return 0;
        while(start+1<end){
            int mid = (start+end)>>1;
            if(nums[mid]<Math.min(nums[mid-1],nums[mid+1]))
                return mid;
            if(nums[start]<nums[mid]) start = mid;
            else end = mid;
        }
        return nums[start]<nums[end]?start:end;
    }
    public static int search(int[] nums, int target){
        if(nums.length<1) return -1;
        if(nums.length==1) return nums[0]==target?0:-1;
        int min = findMin(nums);
        int s=0,e=nums.length-1;
        if(min!=0){
            if(target>nums[min-1] || target<nums[min]) return -1;
            else if(target>=nums[0]){e = min-1;}
            else if(target<=nums[nums.length-1]){s = min;}
        }
        while(s<=e){
            int mid = s + (e-s)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]>target){
                if(mid==s) return -1;
                else e = mid-1;
            }else{
                if(mid==e) return -1;
                else s = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(search(nums,5));
    }
}
