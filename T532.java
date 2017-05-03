import java.util.*;

/**
 * Created by eric on 3/18/17.
 */
public class T532 {
    public static int findPairs(int[] nums, int k){
        if(nums.length<2) return 0;
        Arrays.sort(nums);
        int s = 0, mid = 1, e = nums.length, res = 0;
        while(s<mid && mid<e){
            if(nums[mid]-nums[s]<k) mid++;
            else{
                if(nums[mid]-nums[s]==k){
                    if(s==0 || nums[s]!=nums[s-1]) res++;
                }
                s++;
                if(s==mid) mid++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,4,1,5};
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
