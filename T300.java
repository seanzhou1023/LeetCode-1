import java.util.Arrays;

/**
 * Created by eric on 2/9/17.
 * faster version added;
 * O(n^2) vs. O(nlogn)
 */
public class T300 {
    public static int lengthOfLISSlow(int[] nums){
        if(nums.length<=0)
            return 0;
        int[] res = new int[nums.length];
        int maxRes = 0;
        for(int i=0;i<nums.length;i++){
            res[i] = 1;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    res[i] = res[i] > res[j] + 1?res[i] : res[j] + 1;
                }
            }
            if(res[i]>maxRes)
                maxRes = res[i];
        }
        return maxRes;
    }
    public static int lengthOfLIS(int[] nums){
        int[] dp = new int[nums.length];
        int[] index = new int[nums.length];
        int[] from = new int[nums.length];
        Arrays.fill(from,-1);
        int len = 0;
        for(int i=0;i<nums.length;i++){
            int idx = Arrays.binarySearch(dp,0,len,nums[i]);
            if(idx<0) idx = -(idx+1);
            dp[idx] = nums[i];
            index[idx] = i;
            from[i] = idx>0?index[idx-1]:-1;
            if(idx==len){
                len++;
            }
        }
        int end = index[len-1];
        int[] res = new int[len];
        for(int i=res.length-1;i>=0;i--){
            res[i] = nums[end];
            end = from[end];
        }
        System.out.println(Arrays.toString(res));
        return len;
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        int[] nums1 = {1,3,6,7,9,4,10,5,6};
        System.out.println(lengthOfLIS(nums1));
    }
}
