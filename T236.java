import java.util.*;

/**
 * Created by eric on 4/25/17.
 */
public class T236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root==null || p==root || q==root) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left!=null && right !=null) return root;
        else return left==null?right:left;
    }
    public TreeNode lca(TreeNode root, TreeNode p, TreeNode q){
        //assume p and q are in the same tree
        if(root==null) return root;
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        queue.offer(root);
        parent.put(root,null);
        while(!parent.containsKey(p) || !parent.containsKey(q)){
            TreeNode cur = queue.poll();
            if(cur.left!=null){
                parent.put(cur.left,cur);
                queue.offer(cur.left);
            }
            if(cur.right!=null){
                parent.put(cur.right,cur);
                queue.offer(cur.right);
            }
        }
        Set<TreeNode> ancestors = new HashSet<>();
        while(p!=null){
            ancestors.add(p);
            p = parent.get(p);
        }
        while(!ancestors.contains(q)){
            q = parent.get(q);
        }
        return q;
    }
}
