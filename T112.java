/**
 * Created by eric on 3/14/17.
 */
public class T112 {
    public static TreeNode build(){
        TreeNode root = new TreeNode(5);
        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(8);
        TreeNode t3 = new TreeNode(11);
        TreeNode t4 = new TreeNode(13);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(7);
        TreeNode t7 = new TreeNode(2);
        TreeNode t8 = new TreeNode(1);
        root.left = t1;root.right = t2;
        t1.left = t3;t2.left = t4;t2.right=t5;
        t3.left=t6;t3.right=t7;t5.right=t8;
        return root;
    }
    public static boolean dfs(TreeNode root,int sum){
        if(root.left==null && root.right==null)
            return sum==root.val;
        else if(root.left!=null)
            return dfs(root.left,sum-root.val);
        else if(root.right!=null)
            return dfs(root.right,sum-root.val);
        else return dfs(root.left,sum-root.val) || dfs(root.right,sum-root.val);
    }
    public static boolean hasPathSum(TreeNode root, int sum){
        if(root==null) return false;
        else return dfs(root,sum);
    }

    public static void main(String[] args) {
        TreeNode root = null;
        System.out.println(hasPathSum(root,0));
    }
}
