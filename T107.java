import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by eric on 3/14/17.
 */
public class T107 {
    public static TreeNode build(){
        TreeNode root = new TreeNode(3);
        TreeNode t1 = new TreeNode(9);
        TreeNode t2 = new TreeNode(20);
        TreeNode t3 = new TreeNode(15);
        TreeNode t4 = new TreeNode(7);
        root.left = t1;root.right = t2;
        t2.left = t3;t2.right = t4;
        return root;
    }
    public static List<List<Integer>> levelOrderBottom(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int cnt = 1;
        while(!q.isEmpty()){
            List<Integer> tmp = new ArrayList<>();
            int len = cnt;
            for(int i=0;i<len;i++){
                TreeNode pop = q.poll();cnt--;
                tmp.add(pop.val);
                if(pop.left!=null){
                    q.add(pop.left);cnt++;
                }
                if(pop.right!=null){
                    q.add(pop.right);cnt++;
                }
            }
            res.add(0,tmp);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = build();
        System.out.println(levelOrderBottom(root));
    }
}
