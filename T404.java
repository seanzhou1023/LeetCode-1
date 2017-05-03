/**
 * Created by eric on 4/16/17.
 */
public class T404 {
    static int sum;
    public static void findLeft(TreeNode root){
        if(root==null) return;
        if(root.left!=null){
            if(root.left.left==null && root.left.right==null){
                sum += root.left.val;
            }
            else findLeft(root.left);
        }
        if(root.right!=null){
            findLeft(root.right);
        }
    }
    public static int sumOfLeftLeaves(TreeNode root){
        sum = 0;
        findLeft(root);
        return sum;
    }
}
