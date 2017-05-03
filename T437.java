import java.util.HashMap;
import java.util.Map;

/**
 * Created by eric on 4/10/17.
 * great question
 */
public class T437 {
    public static int pathSum(TreeNode root, int curSum, int target,
                              Map<Integer, Integer> hm){
        if(root==null) return 0;
        curSum += root.val;
        int ways = hm.getOrDefault(curSum-target,0);
        hm.put(curSum,hm.getOrDefault(curSum,0)+1);
        ways += pathSum(root.left, curSum, target, hm) +
                pathSum(root.right, curSum, target, hm);
        hm.put(curSum,hm.get(curSum)-1);
        return ways;
    }
    public static int pathSum(TreeNode root, int sum){
        Map<Integer,Integer> hm = new HashMap<>();
        hm.put(0,1);
        return pathSum(root,0,sum,hm);
    }
}
