import java.util.Arrays;
import java.util.Collections;

/**
 * Created by eric on 4/15/17.
 * https://discuss.leetcode.com/topic/86508/brute-force-solution-in-case-of-your-interviewer-forbid-tricky-solution
 * using recursion next time
 */
public class T553 {
    public static String optimalDivision(int[] nums){
        if(nums.length==1) return nums[0]+"";
        if(nums.length==2) return nums[0]+"/"+nums[1];
        StringBuilder sb = new StringBuilder();
        sb.append(nums[0]).append("/").append("(").append(nums[1]).append("/");
        for(int i=2;i<nums.length;i++){
            sb.append(nums[i]).append("/");
        }
        sb.setLength(sb.length()-1);
        sb.append(")");
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] nums = {5,4,3,2,6};
        System.out.println(optimalDivision(nums));
    }
}
