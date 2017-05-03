import java.util.*;

/**
 * Created by eric on 2/16/17.
 */
public class T217 {
    public static boolean containsDuplicate(int[] nums){
        if(nums==null || nums.length<2)
            return false;
        Set<Integer> res = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(!res.add(nums[i]))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,5};
        System.out.println(containsDuplicate(nums));
    }
}
