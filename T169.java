/**
 * Created by eric on 2/28/17.
 */
public class T169 {
    public static int majorityElement(int[] nums){
        int cnt = 1, candidate = nums[0];
        for(int i=1;i<nums.length;i++){
            if(cnt==0){
                candidate = nums[i];
                cnt++;
            }else{
                if (candidate == nums[i]) cnt++;
                else cnt--;
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        int[] nums = {2};
        System.out.println(majorityElement(nums));
    }
}
