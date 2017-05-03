import java.util.*;

/**
 * Created by eric on 3/18/17.
 */
public class T103 {
    public static TreeNode build(){
        TreeNode root = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);TreeNode t3 = new TreeNode(11);
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
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        int level = 0;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            level++;
            List<Integer> tmp = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode cur = queue.poll();
                if(level%2==0) tmp.add(0,cur.val);
                else tmp.add(cur.val);
                if(cur.left!=null) queue.offer(cur.left);
                if(cur.right!=null) queue.offer(cur.right);
            }
            res.add(tmp);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = build();
        System.out.println(zigzagLevelOrder(root));
    }
}
