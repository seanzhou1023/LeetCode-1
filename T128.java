import java.util.*;

/**
 * Created by eric on 3/3/17.
 */
public class T128 {
    public static int longestConsecutive(int[] nums){
        if(nums==null||nums.length<1) return 0;
        if(nums.length==1) return 1;
        HashSet<Integer> numSet = new HashSet<>();
        HashSet<Integer> used = new HashSet<>();
        for(int i=0;i<nums.length;i++)
            numSet.add(nums[i]);
        int maxLen = 0, ptr = 0;
        boolean done = false;
        while(!done){
            List<Integer> res = new ArrayList<>();
            res.add(nums[ptr]);
            used.add(nums[ptr]);
            int cur = nums[ptr];
            while(numSet.contains(cur-1)){
                res.add(cur-1);
                used.add(cur-1);
                cur--;
            }
            cur = nums[ptr];
            while(numSet.contains(cur+1)){
                res.add(cur+1);
                used.add(cur+1);
                cur++;
            }
            maxLen = maxLen>res.size()?maxLen:res.size();
            done = true;
            for(int i=ptr;i<nums.length;i++){
                if(!used.contains(nums[i])){
                    ptr = i;
                    done = false;
                    break;
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2,101,102,-1,103,104};
        System.out.println(longestConsecutive(nums));
    }
}
