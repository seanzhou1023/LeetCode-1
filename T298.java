/**
 * Created by eric on 3/4/17.
 * next time be more concise
 */
public class T298 {
    static int max = 0;
    private int longest(TreeNode root){
        if(root==null) return 0;
        int res = 0;
        int left = longest(root.left);
        int right = longest(root.right);
        left = (root.left!=null && root.val==(root.left.val-1))?left+1:1;
        right = (root.right!=null && root.val==(root.right.val-1))?right+1:1;
        res = Math.max(left,right);
        max = Math.max(res,max);
        return res;
    }
    public int longestConsecutive(TreeNode root){
        longest(root);
        return max;
    }
}
