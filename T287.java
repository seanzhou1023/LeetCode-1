/**
 * Created by eric on 2/16/17.
 */
public class T287 {
    public static int findDuplicate(int[] nums){
        if(nums==null || nums.length<2)
            return -1;
        int fast = 0, slow = 0;
        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow==fast)
                break;
        }
        slow = 0;
        while(slow!=fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        System.out.println(findDuplicate(nums));
    }
}
