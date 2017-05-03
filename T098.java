/**
 * Created by eric on 3/21/17.
 */
public class T098 {
    public static boolean isValid(TreeNode root, int leftMin, int rightMax){
        if(root==null) return true;
        if(root.val <= leftMin || root.val >= rightMax) return false;
        return isValid(root.left, leftMin, root.val) &&
                isValid(root.right, root.val, rightMax);
    }
    public static boolean isValidBST(TreeNode root){
        if(root == null || (root.left==null && root.right==null))
            return true;
        return isValid(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
}
