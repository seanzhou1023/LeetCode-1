import java.util.ArrayList;
import java.util.List;

/**
 * Created by eric on 3/15/17.
 */
public class T229 {
    public static List<Integer> majorityElement(int[] nums){
        List<Integer> res = new ArrayList<>();
        if(nums.length<1) return res;
        int cnt1 = 0, cnt2 = 0, candidate1=0, candidate2=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==candidate1) cnt1++;
            else if(nums[i]==candidate2) cnt2++;
            else if(cnt1==0){candidate1 = nums[i];cnt1++;}
            else if(cnt2==0){candidate2 = nums[i];cnt2++;}
            else{
                cnt1--;cnt2--;
            }
        }
        System.out.println(candidate1);
        System.out.println(candidate2);
        System.out.println(cnt1);
        System.out.println(cnt2);
        cnt1 = 0;cnt2 = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==candidate1) cnt1++;
            if(nums[i]==candidate2) cnt2++;
        }
        if(cnt1>nums.length/3) res.add(candidate1);
        if(cnt2>nums.length/3) res.add(candidate2);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3,0,3,4};
        System.out.println(majorityElement(nums));
    }
}
