import java.util.Arrays;

/**
 * Created by eric on 3/5/17.
 */
public class T088 {
    public static void merge(int[] nums1, int m, int[] nums2, int n){
        int s1 = m-1, s2 = n-1, k = m+n-1;
        while(s2>=0){
            nums1[k--] = (s1<0 || nums1[s1]<nums2[s2])?nums2[s2--]:nums1[s1--];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,9,27,34,0,0,0};
        int[] nums2 = {2,3,4};
        merge(nums1,4,nums2,3);
        System.out.println(Arrays.toString(nums1));
    }
}
