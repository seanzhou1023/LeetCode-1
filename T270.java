/**
 * Created by eric on 4/16/17.
 */
public class T270 {
    public static int closestValue(TreeNode root, double target){
        int res = root.val;
        while(root!=null){
            if(Math.abs(root.val-target)<Math.abs(res-target))
                res = root.val;
            root = root.val>target?root.left:root.right;
        }
        return res;
    }
}
