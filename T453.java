/**
 * Created by eric on 3/25/17.
 */
public class T453 {
    public int minMoves(int[] nums){
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for(int num:nums) {
            min = min<num?min:num;
            sum += num;
        }
        return sum-nums.length*min;
    }
}
