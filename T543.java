/**
 * Created by eric on 4/3/17.
 * easy to implement the recursive version
 * next time do it iteratively
 */
public class T543 {
    static int max;
    public static int maxD(TreeNode root){
        if(root==null) return 0;
        int left = maxD(root.left);
        int right = maxD(root.right);
        max = Math.max(max,left + right);
        return Math.max(left,right)+1;
    }
    public static int diameterOfBinaryTree(TreeNode root){
        maxD(root);
        return max;
    }
}
