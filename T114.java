import java.util.Stack;

/**
 * Created by eric on 4/8/17.
 */
public class T114 {
    public static void flattenItNoStack(TreeNode root){
        if(root==null) return;
        TreeNode cur = root;
        while(cur!=null){
            if(cur.left==null){
                cur = cur.right;
                continue;
            }
            TreeNode Left = cur.left;
            while(Left.right!=null) Left = Left.right;
            Left.right = cur.right;
            cur.right = Left;
            cur.left = null;
            cur = cur.right;
        }
    }
    public static void flattenItStack1(TreeNode root){
        if(root==null) return;
        TreeNode[] stack = new TreeNode[15];
        int i = 0; stack[i++] = root;
        TreeNode dummy = new TreeNode(0);
        TreeNode parent = dummy;
        while(i>0){
            TreeNode cur = stack[--i];
            if(cur.right!=null) stack[i++] = cur.right;
            if(cur.left!=null) stack[i++] = cur.left;
            parent.left = null;
            parent.right = cur;
            parent = cur;
        }
        root = dummy.right;
        dummy = null;
    }
    public void flattenItStack2(TreeNode root) {
        if(root==null) return ;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode dummy = new TreeNode(0);
        TreeNode last = dummy;
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if(cur.right!=null) stack.push(cur.right);
            if(cur.left!=null) stack.push(cur.left);
            last.left = null;
            last.right = cur;
            last = cur;
        }
        root = dummy.right;
    }
    public static void flattenRe(TreeNode root){
        if(root==null) return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        flattenRe(left);
        flattenRe(right);
        root.left = null;
        root.right = left;
        TreeNode cur = root;
        while(cur.right!=null) cur = cur.right;
        cur.right = right;
    }
}
