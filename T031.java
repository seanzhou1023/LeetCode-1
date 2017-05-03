import java.util.Arrays;

/**
 * Created by eric on 3/25/17.
 */
public class T031 {
    public static void swap(int[] nums, int i, int j){
        if(i==j) return;
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    public static void reverse(int[] nums, int s, int e){
        while(s<e) swap(nums,s++,e--);
    }
    public static void nextPermutation(int[] nums){
        int n = nums.length, first = -1;
        for(int i=n-1;i>0;i--){
            if(nums[i]>nums[i-1]){
                first = i-1;break;
            }
        }
        if(first==-1) reverse(nums,0,n-1);
        else{
            for(int i=n-1;i>first;i--){
                if(nums[i]>nums[first]){
                    swap(nums,i,first);break;
                }
            }
            System.out.println(Arrays.toString(nums));
            reverse(nums,first+1,n-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
