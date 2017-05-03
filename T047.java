import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by eric on 4/27/17.
 * https://discuss.leetcode.com/topic/31445/really-easy-java-solution-much-easier-than-the-solutions-with-very-high-vote
 */
public class T047 {
    public void dfs(List<List<Integer>> res, List<Integer> tmp, int[] nums, boolean[] skip){
        if(tmp.size()==nums.length){
            res.add(new ArrayList<Integer>(tmp));
            return ;
        }
        for(int i=0;i<nums.length;i++){
            if(skip[i]) continue;
            if(i>0 && nums[i-1]==nums[i] && !skip[i-1]) continue;
            tmp.add(nums[i]);
            skip[i] = true;
            dfs(res,tmp,nums,skip);
            skip[i] = false;
            tmp.remove(tmp.size()-1);
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        if(nums==null || nums.length<1) return res;
        Arrays.sort(nums);
        List<Integer> tmp = new ArrayList<>();
        boolean[] skip = new boolean[nums.length];
        dfs(res,tmp,nums,skip);
        return res;
    }
}
