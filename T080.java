import java.util.Arrays;

/**
 * Created by eric on 3/14/17.
 */
public class T080 {
    public static int removeDuplicates(int[] nums){
        int last = nums[0];
        int lastcnt = 1, cnt = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==last){
                if(lastcnt++<2) nums[cnt++]=nums[i];
            }else{
                last = nums[i];
                nums[cnt++]=nums[i];
                lastcnt = 1;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}
