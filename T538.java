import java.util.Stack;

/**
 * Created by eric on 3/19/17.
 * very nice - inorder traversal
 */
public class T538 {
    public static TreeNode build(){
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        t1.left = t2;t1.right = t3;
        t2.left = t4;t2.right = t5;
        t3.left = t6;t3.right = t7;
        return t1;
    }
    public static int convert(TreeNode root, int val){
        if(root==null) return val;
        System.out.println(root.val);
        int right = convert(root.right,val);
        int left = convert(root.left,root.val+right);
        root.val += right;
        return left;
    }
    public static TreeNode convertBST(TreeNode root){
        convert(root,0);
        return root;
    }
    public static TreeNode convertBSTIt(TreeNode root){
        if(root==null) return root;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        boolean done = false;
        int sum = 0;
        while(!done){
            if(cur!=null){
                stack.push(cur);
                cur = cur.right;
            }else{
                if(stack.isEmpty()) done=true;
                else{
                    cur = stack.pop();
                    cur.val += sum;
                    sum = cur.val;
                    cur = cur.left;
                }
            }
        }
        return root;
    }
    public static void main(String[] args) {
        TreeNode root = build();
        System.out.println(convertBSTIt(root).val);
    }
}
