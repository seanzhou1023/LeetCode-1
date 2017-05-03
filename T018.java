import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by eric on 3/7/17.
 */
public class T018 {
    public static List<List<Integer>> fourSum(int[] nums, int target){
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length<4) return res;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;i++){
            if(i==0 || (i>0 && nums[i]!=nums[i-1])){
                for(int j=i+1;j<nums.length-2;j++){
                    if(nums[j]!=nums[j-1]){
                        int low = j+1, high = nums.length-1;
                        while(low<high){
                            int sum = nums[i] + nums[j] + nums[low] + nums[high];
                            if(sum==target){
                                List<Integer> newList = new ArrayList<>(Arrays.asList(
                                        nums[i],nums[j],nums[low],nums[high]
                                ));
                                res.add(newList);
                                while(low<high && nums[low]==nums[++low]);
                                while(low<high && nums[high]==nums[--high]);
                            }else if(sum<target) low++;
                            else high--;
                        }
                    }

                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        System.out.println(fourSum(nums,0));
    }
}
