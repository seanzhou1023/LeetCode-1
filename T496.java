import java.util.*;

/**
 * Created by eric on 3/23/17.
 */
public class T496 {
    public static int[] nextGreaterElement1(int[] findNums, int[] nums){
        Stack<Integer> stack = new Stack<>();
        Map<Integer,Integer> hm = new HashMap<>();
        for(int num:nums){
            while(!stack.isEmpty() && stack.peek()<num)
                hm.put(stack.pop(),num);
            stack.push(num);
        }
        for(int i=0;i<findNums.length;i++){
            findNums[i] = hm.getOrDefault(findNums[i],-1);
        }
        return findNums;
    }
    public static int[] nextGreaterElement2(int[] findNums, int[] nums){
        Stack<Integer> stack = new Stack<>();
        Map<Integer,Integer> hm = new HashMap<>();
        for(int i=nums.length-1;i>=0;i--){
            while(!stack.isEmpty() && nums[i]>stack.peek()) stack.pop();
            hm.put(nums[i],stack.isEmpty()?-1:stack.peek());
            stack.push(nums[i]);
        }
        for(int i=0;i<findNums.length;i++){
            findNums[i] = hm.putIfAbsent(findNums[i],-1);
        }
        return findNums;
    }
    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        System.out.println(Arrays.toString(nextGreaterElement2(nums1, nums2)));
    }
}
