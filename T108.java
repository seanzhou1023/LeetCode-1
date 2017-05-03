/**
 * Created by eric on 3/16/17.
 */
public class T108 {
    public static TreeNode generateTree(int[] nums, int start, int end){
        if(start>end) return null;
        else{
            int mid = start + (end-start)/2;
            TreeNode head = new TreeNode(nums[mid]);
            head.left = generateTree(nums,start,mid-1);
            head.right = generateTree(nums,mid+1,end);
            return head;
        }
    }
    public static TreeNode sortedArrayToBST(int[] nums){
        if(nums.length<1) return null;
        return generateTree(nums,0,nums.length-1);
    }
}
