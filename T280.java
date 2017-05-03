import java.util.Arrays;

/**
 * Created by eric on 3/4/17.
 */
public class T280 {
    public static void wiggleSort(int[] nums){
        if(nums==null || nums.length<2) return ;
        int cur = 0;
        while(cur < nums.length-1){
            if((cur%2==0 && nums[cur]>nums[cur+1])
                    || (cur%2!=0 && nums[cur]<nums[cur+1])){
                    int temp = nums[cur];
                    nums[cur] = nums[cur+1];
                    nums[cur+1] = temp;
            }
            cur++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 5, 2, 1, 6, 4};
        wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
