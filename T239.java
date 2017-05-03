import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Created by eric on 2/12/17.
 */
public class T239 {
    public static int[] maxSlidingWindow(int[] nums, int k){
        if(nums==null || nums.length<1)
            return new int[0];
        Deque<Integer> queue = new ArrayDeque<>();
        int l = nums.length;
        int[] res = new int[l-k+1];
        for(int i=0;i<l;i++){
            if(!queue.isEmpty() && queue.peek()==i-k)
                queue.poll();
            while(!queue.isEmpty() && nums[queue.peekLast()]<=nums[i])
                queue.pollLast();
            queue.offer(i);
            if(i>=k-1)
                res[i-k+1] = nums[queue.peek()];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {7,2,4};
        int k = 2;
        System.out.println(Arrays.toString(maxSlidingWindow(nums,k)));
    }
}
