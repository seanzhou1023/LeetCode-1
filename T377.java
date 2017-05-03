import java.util.*;

/**
 * Created by eric on 3/15/17.
 * traditional recursion is too slow!
 */
public class T377 {
    public static void addSum(int[] res,List<Integer> tmp, int start,
                              int[] nums, int target){//slow!!!
        if(target<0);
        else if(target==0){
            res[0]++;
        }else{
            for(int i=start;i<nums.length;i++){
                tmp.add(nums[i]);
                addSum(res,tmp,start,nums,target-nums[i]);
                tmp.remove(tmp.size()-1);
            }
        }
    }
    public static int combinationSum4(int[] nums, int target){
        List<Integer> tmp = new ArrayList<>();
        if(nums.length<1) return 0;
        int[] res = new int[1];
        addSum(res,tmp,0,nums,target);
        return res[0];
    }
    public static int combinationsSum4Fast(int[] nums, int target){
        Arrays.sort(nums);
        int[] res = new int[target+1];
        for(int i=1;i<=target;i++)
            for(int num:nums){
                if(num>i) break;
                else if(num==i) res[i]+=1;
                else res[i] += res[i-num];
            }
        return res[target];
    }

    public static void main(String[] args) {
        int[] nums = {1,2,4};
        System.out.println(combinationsSum4Fast(nums,32));
    }
}
