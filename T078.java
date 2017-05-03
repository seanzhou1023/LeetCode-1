import java.util.ArrayList;
import java.util.List;

/**
 * Created by eric on 3/14/17.
 */
public class T078 {
    public static List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> init = new ArrayList<>();
        res.add(init);
        for(int i=0;i<nums.length;i++){
            int size = res.size();
            for(int j=0;j<size;j++){
                List<Integer> tmp = new ArrayList<>();
                tmp.addAll(res.get(j));
                tmp.add(nums[i]);
                res.add(tmp);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2};
        System.out.println(subsets(nums));
    }
}
