import java.util.*;
/**
 * Created by eric on 1/30/17.
 * 1.build maxHeap from nums
 * 2.extract maximum
 * 3.maxheapify the tree
 * 3.repeat 2-3 k times
 */
public class T215 {
    public static int quickSelect(List<Integer> list,int k){
//        http://www.cs.yale.edu/homes/aspnes/pinewiki/QuickSelect.html
        int idx = (int)(Math.random()*list.size());
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            if(list.get(i)>list.get(idx))
                left.add(list.get(i));
            if(list.get(i)<list.get(idx))
                right.add(list.get(i));
        }
        if(k<=left.size())
            return quickSelect(left,k);
        else if(k>list.size()-right.size())
            return quickSelect(right,k-(list.size()-right.size()));
            // be careful that the numbers may not be distinct
        else
            return list.get(idx);
    }
    public static int findKthLargest1(int[] nums, int k){
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++)
            list.add(nums[i]);
        return quickSelect(list,k);
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 9;
        System.out.println(findKthLargest1(nums,k));
    }
}
