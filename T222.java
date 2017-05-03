import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by eric on 3/15/17.
 * traversal cost too much, smart solution needed
 */
public class T222 {
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
    public static int height(TreeNode root){
        return root==null?-1:1+height(root.left);
    }
    public static int countNodes(TreeNode root){
        int cnt = 0, h = height(root);
        while(root!=null){
            if(height(root.right)==h-1){
                cnt += 1 << h;
                root = root.right;
            }else{
                cnt += 1 << (h-1);
                root = root.left;
            }
            h--;
        }
        return cnt;
    }

    public static void main(String[] args) {
        TreeNode head = build();
        System.out.println(countNodes(head));
    }
}
