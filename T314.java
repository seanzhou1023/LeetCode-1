import java.util.*;

/**
 * Created by eric on 4/8/17.
 * next time try different traversal
 */
public class T314 {
    public void addNode(TreeNode cur, Queue<TreeNode> queue, int pos, int[] idx,
                        Map<TreeNode, Integer> hm, List<List<Integer>> res){
        hm.put(cur,pos); queue.offer(cur);
        if(pos>=idx[0] && pos<=idx[1])//current node's label is within the range
            res.get(pos-idx[0]).add(cur.val);
        else if(pos<idx[0]){//current node's label L out of range
            res.add(0,new ArrayList<>());
            res.get(0).add(cur.val);
            idx[0] = pos;
        }else{//current node's label L out of range
            res.add(new ArrayList<>());
            res.get(res.size()-1).add(cur.val);
            idx[1] = pos;
        }
    }
    public List<List<Integer>> verticalOrder(TreeNode root){
        List<List<Integer>> res = new LinkedList<>();
        if(root == null) return res;
        Map<TreeNode, Integer> hm = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); hm.put(root,0);
        res.add(new ArrayList<>());
        res.get(0).add(root.val);
        int[] idx = {0,0};//record the range of the labels: {min, max}
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode cur = queue.poll();
                if(cur.left!=null){//update the left child
                    addNode(cur.left, queue, hm.get(cur)-1, idx, hm, res);
                }
                if(cur.right!=null){//update the right child
                    addNode(cur.right, queue, hm.get(cur)+1, idx, hm, res);
                }
            }
        }
        return res;
    }
}
