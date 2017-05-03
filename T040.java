import java.util.*;

/**
 * Created by eric on 3/15/17.
 */
public class T040 {
    public static void addSum(List<List<Integer>> res, List<Integer> tmp,
                              int[] candidates, int start, int target){
        if(target<0) ;
        else if(target==0){
            List<Integer> result = new ArrayList<>(tmp);
            res.add(result);
        }else{
            for(int i=start;i<candidates.length;i++){
                if(i>start && candidates[i]==candidates[i-1]) ;
                else{
                    tmp.add(candidates[i]);
                    addSum(res,tmp,candidates,i+1,target-candidates[i]);
                    tmp.remove(tmp.size()-1);
                }
            }
        }
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target){
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length<1) return res;
        List<Integer> tmp = new ArrayList<>();
        Arrays.sort(candidates);
        addSum(res,tmp,candidates,0,target);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {10,1,2,7,6,1,5};
        System.out.println(combinationSum2(nums,8));
    }
}
