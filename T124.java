/**
 * Created by eric on 4/7/17.
 * update the max value when calculating the max path down
 * next time iterative version:
 * https://discuss.leetcode.com/topic/7512/iterative-java-solution
 */
public class T124 {
    static int maxVal;
    public static int maxPath(TreeNode root){
        if(root==null) return 0;
        int left = root.left!=null?maxPath(root.left):0;
        int right = root.right!=null?maxPath(root.right):0;
        left = Math.max(left,0);
        right = Math.max(right,0);
        maxVal = Math.max(maxVal,left+right+root.val);
        return Math.max(left,right)+root.val;
    }
    public static int maxPathSum(TreeNode root){
        if(root==null) return 0;
        maxVal = Integer.MIN_VALUE;
        maxPath(root);
        return maxVal;
    }
}
