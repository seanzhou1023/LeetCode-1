import java.util.Arrays;

/**
 * Created by eric on 3/25/17.
 * next time using quickselecting the median and do the work
 */
public class T462 {
    public int minMoves2(int[] nums){
        Arrays.sort(nums);
        int s = 0, e = nums.length-1, sum=0;
        while(s<e) sum += nums[e--]-nums[s++];
        return sum;
    }
}
