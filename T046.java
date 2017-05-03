import java.util.*;

/**
 * Created by eric on 1/23/17.
 */
public class T046 {
    public static List<List<Integer>> permute(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length==0) return res;
        for(int i=0;i<nums.length;i++){
            int cur = nums[i];
            if(res.size()==0){
                List<Integer> first = new ArrayList<>(cur);
                res.add(first);
            }else{
                List<List<Integer>> tmpRes = new ArrayList<>(res);
                res.clear();
                for(int j=0;j<tmpRes.size();j++){
                    List<Integer> tmpList = tmpRes.get(j);
                    for(int k=0;k<tmpList.size()+1;k++){
                        List<Integer> tmp = new ArrayList<>(tmpList);
                        tmp.add(k,cur);
                        res.add(tmp);
                    }
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {-1,2,3,6};
        System.out.println(permute(nums));
    }
}
