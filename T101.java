import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by eric on 4/25/17.
 * recursively and iteratively(BFS)
 * https://discuss.leetcode.com/topic/5941/recursive-and-non-recursive-solutions-in-java
 */
public class T101 {
    public boolean isMirror(TreeNode t1, TreeNode t2){
        if(t1==null && t2==null) return true;
        if(t1==null || t2==null) return false;
        return t1.val==t2.val && isMirror(t1.left,t2.right) && isMirror(t1.right,t2.left);
    }
    public boolean isSymmetricRe(TreeNode root){
        return root==null || isMirror(root.left,root.right);
    }
    public boolean isSymmetricIt(TreeNode root){
        if(root==null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            if(t1==null && t2==null) continue;
            if(t1==null || t2==null) return false;
            if(t1.val != t2.val) return false;
            queue.offer(t1.left);
            queue.offer(t2.right);
            queue.offer(t1.right);
            queue.offer(t2.left);
        }
        return true;
    }
}
