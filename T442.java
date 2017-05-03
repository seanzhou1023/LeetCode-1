import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by eric on 3/10/17.
 */
public class T442 {
    public static List<Integer> findDuplicates(int[] nums){
        List<Integer> res = new ArrayList<>();
        if(nums.length<1) return res;
        for(int i=0;i<nums.length;i++){
            if(nums[Math.abs(nums[i])-1]<0) res.add(Math.abs(nums[i]));
            nums[Math.abs(nums[i])-1]*=-1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates(nums));
    }
}
