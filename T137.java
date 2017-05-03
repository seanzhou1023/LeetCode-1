/**
 * Created by eric on 2/12/17.
 * be careful with the left shift and right shift
 * the result may be different for negative number
 */
public class T137 {
    public static int singleNumber(int[] nums){
        int res = 0;
        for(int i=31;i>=0;i--){
            int cur = 0;
            for(int n=0;n<nums.length;n++){
                cur += (nums[n] >> i) & 1;
            }
            res |= (cur%3) << i;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-3,-4,-3,-4,-3,-4,-1,-5,-5,-5};
//        System.out.println(singleNumber(nums));
        System.out.println(Integer.toBinaryString(-1<<2));
    }
}
