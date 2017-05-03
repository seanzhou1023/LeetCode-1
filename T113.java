import java.util.ArrayList;
import java.util.List;

/**
 * Created by eric on 4/10/17.
 */
public class T113 {
    public static TreeNode build(){
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(3);
        t1.left = t2;t1.right = t3;
        t2.left = t4;t2.right = t5;
        t3.left = t6;t3.right = t7;
        return t1;
    }
    public static void dfs(List<Integer> tmp, List<List<Integer>> res,
                           TreeNode root, int sum){
        if(root==null) return;
        else if(root.left==null && root.right==null){//tricky part
            if(sum==root.val){
                res.add(new ArrayList<>(tmp));
                res.get(res.size()-1).add(root.val);
            }
        }else{
            for(int i=0;i<2;i++){
                tmp.add(root.val);
                dfs(tmp,res,i==0?root.left:root.right,sum-root.val);
                tmp.remove(tmp.size()-1);
            }
        }
    }
    public static List<List<Integer>> pathSum(TreeNode root, int sum){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        dfs(tmp,res,root,sum);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(pathSum(build(),7));
    }
}
