/**
 * Created by eric on 3/16/17.
 */
public class T109 {
    public TreeNode generateBST(int[] nums, int start, int end){
        if(start>end) return null;
        else{
            int mid = start + (end-start)/2;
            TreeNode head = new TreeNode(nums[mid]);
            head.left = generateBST(nums,start,mid-1);
            head.right = generateBST(nums,mid+1,end);
            return head;
        }
    }
    public TreeNode sortedListToBST(ListNode head){
        if(head==null) return null;
        ListNode cur = head;
        int cnt = 0;
        while(cur!=null){
            cur = cur.next;
            cnt++;
        }
        int[] nums = new int[cnt];
        return generateBST(nums,0,nums.length-1);
    }
}
