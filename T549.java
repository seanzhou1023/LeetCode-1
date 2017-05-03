/**
 * Created by eric on 4/9/17.
 * be more concise next time
 */
public class T549 {
    static int max;
    private int findIncreasing(TreeNode root){
        if(root==null) return 0;
        int left = findIncreasing(root.left);
        int right = findIncreasing(root.right);
        left = (root.left!=null && root.val == root.left.val+1)?left+1:1;
        right = (root.right!=null && root.val == root.right.val+1)?right+1:1;
        return Math.max(left,right);
    }
    private int findDecreasing(TreeNode root){
        if(root==null) return 0;
        int left = findDecreasing(root.left);
        int right = findDecreasing(root.right);
        left = (root.left!=null && root.val == root.left.val-1)?left+1:1;
        right = (root.right!=null && root.val == root.right.val-1)?right+1:1;
        return Math.max(left,right);
    }
    private int longest(TreeNode root){
        if(root==null) return 0;
        int leftUp = findIncreasing(root.left);
        int rightDown = findDecreasing(root.right);
        int leftDown = findDecreasing(root.left);
        int rightUp = findIncreasing(root.right);
        int one = 1, two = 1;
        one += (root.left!=null && (root.left.val+1)==root.val?leftUp:0) +
                (root.right!=null && (root.right.val-1)==root.val?rightDown:0);
        two += (root.left!=null && (root.left.val-1)==root.val?leftDown:0) +
                (root.right!=null && (root.right.val+1)==root.val?rightUp:0);
        int res= Math.max(one,two);
        max = Math.max(max,res);
        int tmp = Math.max(longest(root.left),longest(root.right));
        max = Math.max(max,tmp);
        return res;
    }
    public int longestConsecutive(TreeNode root){
        max = 0;
        longest(root);
        return max;
    }
}
