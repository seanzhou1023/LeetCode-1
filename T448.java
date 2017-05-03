import java.util.*;

/**
 * Created by eric on 1/24/17.
 *
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

 Find all the elements of [1, n] inclusive that do not appear in this array.

 Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 */
public class T448 {
    public static List<Integer> findDisappearedNumbers(int[] nums){
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0;i<nums.length;i++){
            if(nums[Math.abs(nums[i])-1]>0)
                nums[Math.abs(nums[i])-1] *= -1;
        }
        for(int i = 0;i<nums.length;i++){
            if(nums[i]>0)
                res.add(i+1);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(nums));
    }
}
