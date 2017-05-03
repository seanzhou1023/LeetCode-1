package sedgewick;

import java.util.Arrays;

/**
 * Created by eric on 4/22/17.
 * difference between qs and mergesort: recursion after/before manipulation
 * shuffling, three way partition(duplicate)
 */
public class QuickSort {
    public void swap(int[] nums, int i, int j){
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }
    public void quicksort(int[] nums, int lo, int hi){
//        suffling first
        if(lo>=hi) return;
        int i = lo, j = hi+1;
        while(true){
            while(nums[lo]>nums[++i])
                if(i==hi) break;
            while(nums[lo]<nums[--j]) ;
            if(i>=j) break;
            swap(nums,i,j);
        }
        swap(nums,lo,j);
        quicksort(nums,lo,j-1);
        quicksort(nums,j+1,hi);
    }
    public void quicksort(int[] nums){
        quicksort(nums,0,nums.length-1);
    }

    public static void main(String[] args) {
        int[] nums = {2,55,1,23,77,16,0};
        QuickSort qs = new QuickSort();
        qs.quicksort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
