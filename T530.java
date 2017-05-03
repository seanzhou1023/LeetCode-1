import java.util.Stack;

/**
 * Created by eric on 4/15/17.
 * iterative: inorder
 * recursive: lower & upper bound
 */
public class T530 {
    static long min;
    public static void getMin(TreeNode root, Long left, Long right){
        if(root==null) return;
        if(left!=Long.MIN_VALUE) min = Math.min(min, root.val - left);
        if(right!=Long.MAX_VALUE) min = Math.min(min, right - root.val);
        getMin(root.left,left,(long)root.val);
        getMin(root.right,(long)root.val,right);
    }
    public static int getMinimumDifference(TreeNode root){
        int min = Integer.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        Integer last = null;
        while(!stack.isEmpty() || cur!=null){
            if(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }else{
                cur = stack.pop();
                if(last!=null){
                    min = Math.min(cur.val-last,min);
                }
                last = cur.val;
                cur = cur.right;
            }
        }
        return min;
    }
    public static int getMinimumDifferenceRe(TreeNode root){
        min = Long.MAX_VALUE;
        getMin(root,Long.MIN_VALUE,Long.MAX_VALUE);
        return (int)min;
    }

}
