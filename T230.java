/**
 * Created by eric on 4/26/17.
 * augmented tree structure: supporting the nodes number of subtree
 * https://discuss.leetcode.com/topic/17810/3-ways-implemented-in-java-python-binary-search-in-order-iterative-recursive
 */
public class T230 {
    public int count(TreeNode root){
        if(root==null) return 0;
        return 1+count(root.left)+count(root.right);
    }
    public int kthSmallest(TreeNode root, int k){
        int count = count(root.left);
        if(k<=count){
            return kthSmallest(root.left,k);
        }else if(k>count+1){
            return kthSmallest(root.right,k-count-1);
        }else return root.val;
    }
}
