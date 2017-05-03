import java.util.HashMap;

/**
 * Created by eric on 2/12/17.
 */
public class T001 {
    public static int[] twoSum(int[] nums, int target){
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        int[] res = {-1,-1};
        for(int i=0;i<nums.length;i++){
            if(hashmap.containsKey(target-nums[i])){
                res[0] = hashmap.get(target-nums[i]);
                res[1] = i;
                break;
            }
            else{
                hashmap.put(nums[i],i);
            }
        }
        return res;
    }
}
