import java.util.*;

/**
 * Created by eric on 3/19/17.
 * 1. stack method (with or without boolean done)
 * 2. morris traversal without stack
 */
public class T094 {
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while(cur!=null || !stack.isEmpty()){
            if(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }else{
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
    }
    public static boolean linkPreToCur(TreeNode cur){
        TreeNode left = cur.left;
        while(left.right!=null && left.right!=cur){
            left = left.right;
        }
        if(left.right==null){
            left.right = cur;
            return false;
        }else{
            left.right = null;
            return true;
        }
    }
    public static List<Integer> inorderMorrisAlpha(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;
        TreeNode cur = root;
        while(cur!=null){
            if(cur.left==null){
                res.add(cur.val);
                cur = cur.right;
            }else{
                if(!linkPreToCur(cur)){
                    cur = cur.left;
                }else{
                    res.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return res;
    }
    public static List<Integer> inorderMorris(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;
        TreeNode cur = root;
        while(cur!=null){
            if(cur.left==null){
                res.add(cur.val);
                cur = cur.right;
            }else{
                TreeNode pre = cur.left;
                while(pre.right!=null && pre.right!=cur)
                    pre = pre.right;
                if(pre.right==null){
                    pre.right = cur;
                    cur = cur.left;
                }else{
                    pre.right = null;
                    res.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return res;
    }

}
