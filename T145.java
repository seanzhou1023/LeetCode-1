import java.util.*;

/**
 * Created by eric on 3/17/17.
 * two stack version - easier
 * one stack version - harder
 */
public class T145 {
    public static TreeNode build(){
        TreeNode root = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);TreeNode t9 = new TreeNode(9);
        TreeNode t10 = new TreeNode(10);
        root.left = t2;root.right = t3;
        t2.left = t4;t2.right = t5;
        t5.left = t7;t5.right = t8;
        t3.right = t6;t6.right = t9;t9.left = t10;
        return root;
    }
    public static List<Integer> postorderTraversal(TreeNode root){//two stack
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if(cur.left!=null) stack.add(cur.left);
            if(cur.right!=null) stack.add(cur.right);
            res.add(0,cur.val);
        }
        return res;
    }
    public static List<Integer> postorderTraversal1(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root, pre;
        while(cur!=null || !stack.isEmpty()){
            System.out.println(stack);
            System.out.println(res);
            if(stack.isEmpty()) stack.push(cur);
            while(cur.left!=null){
                stack.push(cur.left);
                cur = cur.left;
            }
            if(cur.right==null){//a leaf
                pre = stack.pop();
                res.add(pre.val);
                cur = null;
                if(stack.isEmpty()) return res;
                else{
                    TreeNode tmp = stack.peek();
                    if(tmp.left == pre){
                        if(tmp.right!=null){
                            stack.push(tmp.right);
                            cur = tmp.right;
                        }else cur = null;
                    }else if(tmp.right == pre){
                        pre = stack.pop();
                        res.add(pre.val);
                        cur = null;
                    }
                }
            }else{
                stack.add(cur.right);
                cur = cur.right;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = build();
        System.out.println(postorderTraversal1(root));
    }
}
