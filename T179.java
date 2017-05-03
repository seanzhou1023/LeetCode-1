import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by eric on 3/8/17.
 */
public class T179 {
    public static boolean isSmaller(int n1, int n2){
        String num1 = Integer.toString(n1);
        String num2 = Integer.toString(n2);
        if((num2+num1).compareTo(num1+num2)>0) return true;
        else return false;
    }
    public static void mergeSort(int[] nums, int start, int end){
        if(start>=end) return;
        int mid = start + (end-start)/2;
        mergeSort(nums,start,mid);
        mergeSort(nums,mid+1,end);
        int[] copy = new int[end-mid];
        for(int i=0;i<end-mid;i++)
            copy[i] = nums[i+mid+1];
        int idx1 = mid, idx2 = end-mid-1, k = end;
//        be careful with the merge sort boundaries when applying the technique
        while(idx2>=0){
            nums[k--] = (idx1<start||isSmaller(copy[idx2],nums[idx1]))?copy[idx2--]:nums[idx1--];
        }
    }
    public static String largestNumber(int[] nums){
        if(nums==null||nums.length<1||(nums.length==1&&nums[0]==0)) return "";
        mergeSort(nums,0,nums.length-1);
        StringBuilder sb = new StringBuilder();
        int flag = 0;
        for(int i=0;i<nums.length;i++){
            if(i==0 && nums[i]==0) flag = 1;
            if(flag==1){
                if(nums[i]==0);
                else{
                    flag=0;
                    sb.append(nums[i]);
                }
            }else{
                sb.append(nums[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] nums = {12,121};
        System.out.println(isSmaller(20,1));
        System.out.println(largestNumber(nums));
    }
}
