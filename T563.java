/**
 * Created by eric on 4/22/17.
 */
public class T563 {
    int sum;
    public void find(TreeNode root){
        if(root==null) return ;
        find(root.left);
        find(root.right);
        sum += root.val;
    }
    public int findTiltOne(TreeNode root){
        int res = 0;
        sum = 0;
        find(root.left);
        res += sum;sum=0;
        find(root.right);
        return Math.abs(res-sum);
    }
    public int findTilt(TreeNode root){
        int res = 0;
        res += findTiltOne(root);
        res += findTilt(root.left);
        res += findTilt(root.right);
        return res;
    }
}
