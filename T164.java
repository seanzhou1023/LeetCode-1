import java.util.*;

/**
 * Created by eric on 3/5/17.
 * bucket sort
 * 1. bucket size and idx generating (always a 1 difference) 0~len-1
 * 2. bucket size versus maxGap between nums
 */
public class T164 {
    public static int[] getMinMax(List<Integer> bckt){
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for(int i=0;i<bckt.size();i++){
            max = max>bckt.get(i)?max:bckt.get(i);
            min=  min<bckt.get(i)?min:bckt.get(i);
        }
        return new int[] {min,max};
    }
    public static int maximumGap(int[] nums){
        if(nums.length<2) return 0;
        int len = nums.length, res = 0;
        List<List<Integer>> bucket = new ArrayList<>();
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for(int i=0;i<len;i++){
            max = max>nums[i]?max:nums[i];
            min=  min<nums[i]?min:nums[i];
            bucket.add(new ArrayList<Integer>());
        }
        if(max==min) return 0;
        double div = (double)(max-min)/(len-1);
        for(int i=0;i<len;i++){
            int idx = (int)((double)(nums[i]-min)/div);
            bucket.get(idx).add(nums[i]);
        }
        int cur = 0;
        for(int i=0;i<len;i++){
            List<Integer> curBucket = bucket.get(i);
            if(curBucket.size()<1) continue;
            else if(curBucket.size()==1){
                if(i==0) cur = curBucket.get(0);
                else{
                    int gap = curBucket.get(0)-cur;
                    res = res>gap?res:gap;
                    cur += gap;
                }
            }else{
                if(i!=0){
                    int gap = getMinMax(curBucket)[0]-cur;
                    res = res>gap?res:gap;
                }
                cur = getMinMax(curBucket)[1];
                }
            }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {100,2,3,1};
        System.out.println(maximumGap(nums));
    }
}
