import java.util.ArrayList;
import java.util.List;

/**
 * Created by eric on 3/15/17.
 */
public class T039 {
    public static void addSum(List<List<Integer>> res, List<Integer> tmp,
                              int[] candidates, int start, int target){
        if(target<0){
            return ;
        }
        else if(target==0){
            List<Integer> result = new ArrayList<>(tmp);
            res.add(result);
            return ;
        }else{
            int i=start;
            while(i<candidates.length){
                tmp.add(candidates[i]);
                addSum(res,tmp,candidates,i,target-candidates[i]);
                tmp.remove(tmp.size()-1);
                i++;
            }
        }
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        addSum(res,tmp,candidates,0,target);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,6,7};
        System.out.println(combinationSum(nums,6));
    }
}
