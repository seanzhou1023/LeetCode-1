import java.util.ArrayList;
import java.util.List;

/**
 * Created by eric on 3/5/17.
 */
public class T163 {
    public static List<String> findMissingRanges(int[] nums, int lower, int upper){
        List<String> res = new ArrayList<>();
        if(lower>upper) return res;
        if(nums.length==0){
            String s1 = ""+lower;
            String s2= ""+lower+"->"+upper;
            res.add(lower==upper?s1:s2);
            return res;
        }
        int start, end;
        for(int i=-1;i<nums.length;i++){
            System.out.println(res+":"+i);
            if(i==-1){
                start = lower;
                end = nums[0];
                if(end-start==0) continue;
                else if(end-start==1) res.add(""+(start));
                else res.add((start)+"->"+(end-1));
            }else if(i==nums.length-1){
                start = nums[i];
                end = upper;
                if(end-start==0) continue;
                else if(end-start==1) res.add(""+(end));
                else res.add((start+1)+"->"+(end));
            }else{
                start = nums[i];
                end = nums[i+1];
                if(end-start==1 || end-start==0) continue;
                else if(end-start==2) res.add(""+(start+1));
                else res.add((start+1)+"->"+(end-1));
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 3, 50, 75};
        int lower = 0, upper = 99;
//        int nums1 = -2147483648;
//        int nums2 = 2147483647;
//        System.out.println(nums2-nums1);
        System.out.println(findMissingRanges(nums,lower,upper));
    }
}
