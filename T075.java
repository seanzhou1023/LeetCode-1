import java.util.Arrays;

/**
 * Created by eric on 3/4/17.
 */
public class T075 {
    public static void sortColors(int[] nums){
        if(nums==null||nums.length<2) return;
        int start = 0, cur=0, end = nums.length-1;
        int pivot = 1, temp = 0;
        while(cur<=end){
            if(nums[cur]<pivot){
                temp = nums[cur];
                nums[cur] = nums[start];
                nums[start] = temp;
                start++;
                cur++;
            }else if(nums[cur]>pivot){
                temp = nums[cur];
                nums[cur] = nums[end];
                nums[end] = temp;
                end--;
            }else cur++;
            System.out.println("start: "+start+"cur: "+cur+"end: "+end);
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,2,1,1,1};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}