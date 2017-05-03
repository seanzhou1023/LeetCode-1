import java.util.*;

/**
 * Created by eric on 3/9/17.
 */
public class T350 {
    public static int[] intersect(int[] nums1, int[] nums2){
        List<Integer> res = new ArrayList<>();
        HashMap<Integer,Integer> hm = new HashMap<>();
        int[] n1, n2;
        n1 = nums1.length<nums2.length?nums1:nums2;
        n2 = nums1.length>=nums2.length?nums1:nums2;
        for(int i=0;i<n1.length;i++){
            if(hm.containsKey(n1[i]))
                hm.put(n1[i],hm.get(n1[i])+1);
            else hm.put(n1[i],1);
        }
        for(int i=0;i<n2.length;i++){
            if(hm.containsKey(n2[i])){
                res.add(n2[i]);
                if(hm.get(n2[i])==1) hm.remove(n2[i]);
                else hm.put(n2[i],hm.get(n2[i])-1);
            }
        }
        int[] result = new int[res.size()];
        for(int i=0;i<res.size();i++)
            result[i] = res.get(i);
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        System.out.println(Arrays.toString(intersect(nums1,nums2)));
    }
}
