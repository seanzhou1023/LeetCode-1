import java.util.Stack;

/**
 * Created by eric on 4/3/17.
 * iteratively
 * next time recursively
 * -https://discuss.leetcode.com/topic/25076/share-my-java-recursive-solution
 */
public class T285 {
    public static TreeNode build(){
        TreeNode root = new TreeNode(0);
        return root;
    }
    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p){
        if(root==null || p==null) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        boolean isNext = false;
        while(cur!=null || !stack.isEmpty()){
            if(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }else{
                cur = stack.pop();
                if(isNext) return cur;
                if(cur.val==p.val) isNext = true;
                cur = cur.right;
            }
        }
        return null;
    }
    public static TreeNode inorderSuccessorRe(TreeNode root, TreeNode p){
        if(root==null || p==null) return null;
        if(root.val<=p.val)
            return inorderSuccessor(root.right,p);
        else{
            TreeNode left = inorderSuccessor(root.left,p);
            return left!=null?left:root;
        }
//        another version:
//        while (root != null && root.val <= p.val)
//            root = root.right;
//        if (root == null) return null;
//        TreeNode left = inorderSuccessor(root.left, p);
//        return left!=null?left:root;
    }

    public static void main(String[] args) {
        TreeNode root = build();
        TreeNode p = root;
        System.out.println(inorderSuccessor(root,p).val);
    }
}
