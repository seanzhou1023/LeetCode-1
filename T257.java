import java.util.*;

/**
 * Created by eric on 3/29/17.
 */
public class T257 {
    public static TreeNode build(){
        TreeNode root = new TreeNode(1);
        TreeNode rl = new TreeNode(2);
        TreeNode rr = new TreeNode(3);
        TreeNode rlr = new TreeNode(5);
        root.left = rl;
        root.right = rr;
        root.left.right = rlr;
        return root;
    }
    public static void generate(List<String> res, StringBuilder sb, TreeNode root){
        if(root.left==null && root.right==null){
            sb.append(root.val);
            res.add(sb.toString());
            return ;
        }
        int len = sb.length();
        if(root.left!=null){
            sb.append(root.val+"->");
            generate(res,sb,root.left);
            sb.setLength(len);
        }
        if(root.right!=null){
            sb.append(root.val+"->");
            generate(res,sb,root.right);
            sb.setLength(len);
        }
    }
    public static List<String> binaryTreePaths(TreeNode root){
        List<String> res = new ArrayList<>();
        if(root==null) return res;
        StringBuilder sb = new StringBuilder();
        generate(res,sb,root);
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = build();
        System.out.println(binaryTreePaths(root));
    }
}
