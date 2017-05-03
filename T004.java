/**
 * Created by eric on 2/15/17.
 * classic!
 */
public class T004 {
    public static int findKth(int[] nums1, int s1, int e1,
                              int[] nums2, int s2, int e2, int k){
        if(s1>e1) return nums2[s2+k-1];
        if(s2>e2) return nums1[s1+k-1];
        int mid1 = (e1+s1)/2;
        int mid2 = (e2+s2)/2;
        if(nums1[mid1]<=nums2[mid2]){
            if(k<=(mid1-s1)+(mid2-s2)+1)
                return findKth(nums1,s1,e1,nums2,s2,mid2-1,k);
            else
                return findKth(nums1,mid1+1,e1,nums2,s2,e2,k-(mid1-s1+1));
        }else{
            if(k<=(mid1-s1)+(mid2-s2)+1)
                return findKth(nums1,s1,mid1-1,nums2,s2,e2,k);
            else
                return findKth(nums1,s1,e1,nums2,mid2+1,e2,k-(mid2-s2+1));
        }
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2){
        int l1 = nums1.length, l2 = nums2.length;
        int len = l1+l2;
        int k = (l1 + l2 + 1)/2;
        if(len%2==1)
            return findKth(nums1,0,l1-1,nums2,0,l2-1,k);
        else
            return ((double)findKth(nums1,0,l1-1,nums2,0,l2-1,k)
                    +(double)findKth(nums1,0,l1-1,nums2,0,l2-1,k+1))/2;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
}
