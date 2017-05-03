/**
 * Created by eric on 3/9/17.
 */
public class T111 {
    public static int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        else if(root.left!=null && root.right!=null)
            return Math.min(minDepth(root.left),minDepth(root.right))+1;
        else
            return (root.left==null?minDepth(root.right):minDepth(root.left))+1;
    }

    public static void main(String[] args) {
        System.out.println(1>2?5:6 + 1);
    }
}
