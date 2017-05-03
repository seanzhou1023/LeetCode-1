import java.util.Iterator;
import java.lang.*;
import java.util.TreeSet;

/**
 * Created by eric on 2/16/17.
 * using treeset time limit exceeded 39/40 test
 */
public class T220 {
    public static boolean testDis(TreeSet<Integer> ts, int t){
        Iterator<Integer> it = ts.iterator();
        int pre = it.next();
        while(it.hasNext()){
            int cur = it.next();
            if(cur==Integer.MAX_VALUE || pre==Integer.MAX_VALUE){
                if(cur*pre>=0 && t==Integer.MAX_VALUE)
                    return true;
            }
            else if(Math.abs(cur-pre)>=0 && Math.abs(cur-pre)<=t)
                return true;
            pre = cur;
        }
        return false;
    }
    public static boolean containsNearbyAlmostDuplicate0(int[] nums, int k, int t){
        if(nums==null||nums.length<2||k<0||t<0)
            return false;
        TreeSet<Integer> ts = new TreeSet<>();
        for(int i=0;i<nums.length;i++){
            if(i>k) ts.remove(nums[i-k-1]);
            if(ts.add(nums[i])){
                if(testDis(ts,t)) return true;
            }else
                return true;
        }
        return false;
    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t){
        if(nums==null||nums.length<2||k<0||t<0)
            return false;
        TreeSet<Integer> ts = new TreeSet<>();
        for(int i=0;i<nums.length;i++){
            if(i>k) ts.remove(nums[i-k-1]);
            long upper = ts.floor(nums[i]);
            long lower = ts.ceiling(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {0,2147483647};
        System.out.println(containsNearbyAlmostDuplicate(nums,1,2147483647));
    }
}
