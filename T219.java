import java.util.*;

/**
 * Created by eric on 2/16/17.
 */
public class T219 {
    public static boolean containsNearbyDuplicateSlow(int[] nums, int k){
        if(nums==null || nums.length<2 || k<1)
            return false;
        Map<Integer,TreeSet<Integer>> res = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!res.containsKey(nums[i])){
                res.put(nums[i],new TreeSet<Integer>());
            }else{
                if(Math.abs(res.get(nums[i]).last()-i)<=k)
                    return true;
            }
            res.get(nums[i]).add(i);
        }
        return false;
    }
    public static boolean containsNearbyDuplicate(int[] nums, int k){
        if(nums==null || nums.length<2 || k<1)
            return false;
        Set<Integer> res = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(i>k) res.remove(nums[i-k-1]);
            if(!res.add(nums[i])) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,0,1,1,1};
        System.out.println(containsNearbyDuplicate(nums,2));
    }
}
