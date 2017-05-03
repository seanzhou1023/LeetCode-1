import java.util.Arrays;

/**
 * Created by eric on 3/10/17.
 */
public class T303 {
    public static class NumArray{
        private int[] res;
        public NumArray(int[] nums){
            res = new int[nums.length];
            res[0] = nums[0];
            for(int i=1;i<nums.length;i++)
                res[i] = res[i-1]+nums[i];
        }
        public int sumRange(int i, int j){
            return i==0?res[j]:(res[j]-res[i-1]);
        }
    }

    public static void main(String[] args) {
        int[] nums = {-2,0,3,-5,2,-1};
        NumArray arr = new NumArray(nums);
        System.out.println(Arrays.toString(arr.res));
        System.out.println(arr.sumRange(0,2));
        System.out.println(arr.sumRange(2,5));
        System.out.println(arr.sumRange(0,5));
    }
}
