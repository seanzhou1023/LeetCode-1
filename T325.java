import java.util.HashMap;
import java.util.Map;

/**
 * Created by eric on 4/23/17.
 */
public class T325 {
    public int maxSubArrayLen(int[] nums, int k){
        for(int i=1;i<nums.length;i++)
            nums[i] += nums[i-1];
        Map<Integer,Integer> hm = new HashMap<>();
        int max = 0;
        hm.put(0,-1);
        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(nums[i]-k))
                max = Math.max(max, i-hm.get(nums[i]-k));
            if(!hm.containsKey(nums[i]))//keep the first appearance
                hm.put(nums[i],i);
        }
        return max;
    }

    public static void main(String[] args) {
        T325 t = new T325();
        System.out.println(t.maxSubArrayLen(new int[]{1, -1, 5, -2, 3},3));
    }
}
