import java.util.*;

/**
 * Created by eric on 4/26/17.
 * 1: heap -> O(nlogk) slow 14ms
 * 2: linkedlist -> O(n) keep a window faster 3ms
 * 3: two stacks trace predecessor & successor
 * https://discuss.leetcode.com/topic/30597/java-5ms-iterative-following-hint-o-klogn-time-and-space
 */
public class T272 {
    public TreeNode build(){
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        root.left = left;
        return root;
    }
    public List<Integer> closestKValues1(TreeNode root, double target, int k){
        List<Integer> result = new ArrayList<>();
        if(root==null) return result;
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                double res = Math.abs((double)o2-target)-Math.abs((double)o1-target);
                return res<0?-1:(res==0?0:1);
            }
        });
        TreeNode cur = root;
        while(cur!=null){
            if(cur.left==null){
                pq.add(cur.val);
                if(pq.size()>k) pq.poll();
                cur = cur.right;
            }else{
                TreeNode pre = cur.left;
                while(pre.right!=null && pre.right!=cur)
                    pre = pre.right;
                if(pre.right==cur){
                    pq.add(cur.val);
                    if(pq.size()>k) pq.poll();
                    cur = cur.right;
                    pre.right = null;
                }else{
                    pre.right = cur;
                    cur = cur.left;
                }
            }
        }
        for(Integer i: pq)
            result.add(i);
        return result;
    }
    public boolean add(List<Integer> res, double target, int k, TreeNode cur){
        if(res.size()>=k){
            if(Math.abs((double)res.get(0)-target)>Math.abs((double)cur.val-target))
                res.remove(0);
            else return false;
        }
        res.add(cur.val);
        return true;
    }
    public List<Integer> closestKValues2(TreeNode root, double target, int k){
        List<Integer> res = new LinkedList<>();
        if(root==null) return res;
        TreeNode cur = root;
        while(cur!=null){
            if(cur.left==null){
                if(!add(res,target,k,cur)) break;//visit/add this node
                cur = cur.right;
            }else{
                TreeNode pre = cur.left;
                while(pre.right!=null && pre.right!=cur)
                    pre = pre.right;
                if(pre.right==cur){
                    if(!add(res,target,k,cur)) break;//visit/add this node
                    pre.right = null;
                    cur = cur.right;
                }else{
                    pre.right = cur;
                    cur = cur.left;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        double target = 2147483647.0;
        T272 t = new T272();
        TreeNode root = t.build();
        System.out.println(t.closestKValues2(root,target,1));
    }
}
