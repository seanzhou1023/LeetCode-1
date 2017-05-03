import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by eric on 3/21/17.
 * 1. with queue using level traversal
 * 2. without queue recursive
 * 3. without queue iterative
 */
public class T116 {
    static class TreeLinkNode{
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int val){ this.val = val;}
    }
    public static void connect(TreeLinkNode root){
        if(root == null) return;
        Queue<TreeLinkNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            TreeLinkNode dummy = new TreeLinkNode(0), pre = dummy;
            for(int i=0;i<size;i++){
                TreeLinkNode cur = q.poll();
                pre.next = cur;
                if(cur.left!=null) q.offer(cur.left);
                if(cur.right!=null) q.offer(cur.right);
                pre = cur;
            }
            pre.next = null;
            dummy.next = null;
        }
    }
    public static void connectRe(TreeLinkNode root){
        if(root==null) return;
        if(root.left!=null){
            root.left.next = root.right;
            if(root.next!=null) root.right.next = root.next.left;
        }
        connectRe(root.left);
        connectRe(root.right);
    }
    public static void connectIt(TreeLinkNode root){
        if(root==null) return;
        TreeLinkNode pre = root, cur;
        while(pre.left!=null){
            cur = pre;
            while(cur!=null){
                cur.left.next = cur.right;
                if(cur.next!=null) cur.right.next = cur.next.left;
                cur = cur.next;
            }
            pre = pre.next;
        }
    }
}
