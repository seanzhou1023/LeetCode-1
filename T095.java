import java.util.*;

/**
 * Created by eric on 3/29/17.
 * how to do it iteratively?
 * yes - 3ms
 */
public class T095 {
    public static List<TreeNode> generateTrees(int start, int end){
        if(start>end) return Arrays.asList(new TreeNode[]{null});
        List<TreeNode> res = new ArrayList<>();
        for(int i=start;i<end;i++)
            for(TreeNode left:generateTrees(start,i-1))
                for(TreeNode right:generateTrees(i+1,end)){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
        return res;
    }
    public static List<TreeNode> generateTrees(int n){
        if(n<=0) return new ArrayList<>();
        return generateTrees(1,n);
    }
    public static List<TreeNode> generateTreesIT(int n){
        List<TreeNode>[] res = new List[n+1];
        res[0] = new ArrayList<>();
        if(n==0) return res[0];
        res[0].add(null);// remove?
        res[1] = new ArrayList<>();
        res[1].add(new TreeNode(1));
        if(n==1) return res[1];
        for(int i=2;i<=n;i++){
            res[i] = new ArrayList<>();
            for(int j=1;j<=i;j++){
                for(TreeNode left:res[j-1])
                    for(TreeNode right:res[i-j]){
                        TreeNode root = new TreeNode(j);
                        root.left = left;
                        root.right = clone(right, j);
                        res[i].add(root);
                    }
            }
        }
        return res[n];
    }
    public static TreeNode clone(TreeNode cur,int offset){
        if(cur==null) return null;
        TreeNode newCur = new TreeNode(cur.val+offset);
        newCur.left = clone(cur.left, offset);
        newCur.right = clone(cur.right,offset);
        return newCur;
    }
}
