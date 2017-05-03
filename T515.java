import java.util.*;

/**
 * Created by eric on 3/17/17.
 * implement bfs next time, maintaining a level value
 */
public class T515 {
    public static TreeNode build(){
        TreeNode root = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);TreeNode t3 = new TreeNode(11);
        TreeNode t4 = new TreeNode(4);TreeNode t5 = new TreeNode(5);
//        TreeNode t6 = new TreeNode(6);TreeNode t7 = new TreeNode(7);
//        TreeNode t8 = new TreeNode(8);TreeNode t9 = new TreeNode(9);
//        TreeNode t10 = new TreeNode(10);
        root.left = t2;root.right = t3;
//        t2.left = t4;t2.right = t5;
//        t5.left = t7;t5.right = t8;
//        t3.right = t6;t6.right = t9;t9.left = t10;
        return root;
    }
    public static List<Integer> largestValues(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size(), maxVal = Integer.MIN_VALUE;
            for(int i=0;i<size;i++){
                TreeNode cur = q.poll();
                maxVal = maxVal>cur.val?maxVal:cur.val;
                if(cur.left!=null) q.offer(cur.left);
                if(cur.right!=null) q.offer(cur.right);
            }
            res.add(maxVal);
        }
        return res;
    }
    public static void main(String[] args) {
        TreeNode root = build();
        System.out.println(largestValues(root));
    }
}
