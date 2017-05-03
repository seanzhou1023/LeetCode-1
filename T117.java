import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by eric on 4/22/17.
 * bfs is easy, try dfs
 */
public class T117 {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }
    public void connect(TreeLinkNode root){
        if(root==null) return ;
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            TreeLinkNode last = null;
            for(int i=0;i<size;i++){
                TreeLinkNode cur = queue.poll();
                if(last!=null) last.next = cur;
                last = cur;
                if(i==size-1) last.next = null;
                if(cur.left!=null) queue.offer(cur.left);
                if(cur.right!=null) queue.offer(cur.right);
            }
        }
    }
    public void connectN(TreeLinkNode root){
        TreeLinkNode cur, start;
        while(root!=null){
            cur = new TreeLinkNode(0);
            start = cur;
            while(root!=null){
                if(root.left!=null){
                    cur.next = root.left;
                    cur = root.left;
                }
                if(root.right!=null){
                    cur.next = root.right;
                    cur = root.right;
                }
                root = root.next;
            }
            root = start.next;
        }
    }
}
