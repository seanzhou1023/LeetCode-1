import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by eric on 2/12/17.
 */
public class T349 {
    public static int[] intersection(int[] nums1, int[] nums2){
        HashSet<Integer> hash = new HashSet<>();
        HashSet<Integer> res = new HashSet<>();
        for(int i=0;i<nums1.length;i++)
            hash.add(nums1[i]);
        for(int i=0;i<nums2.length;i++){
            if(hash.contains(nums2[i]))
                res.add(nums2[i]);
        }
        int[] result = new int[res.size()];
        int idx = 0;
        for(Integer i:res)
            result[idx++] = i;
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(Arrays.toString(intersection(nums1,nums2)));
    }
}
