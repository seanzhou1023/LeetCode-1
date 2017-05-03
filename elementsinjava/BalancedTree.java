package elementsinjava;

/**
 * Created by eric on 4/25/17.
 */
public class BalancedTree {
    public class Balanced{
        public boolean balanced;
        public int height;
        Balanced(boolean balanced, int height){
            this.balanced = balanced;
            this.height = height;
        }
    }
    public Balanced isBalance(TreeNode<Integer> root){
        if(root==null) return new Balanced(true,-1);
        Balanced left = isBalance(root.left);
        if(!left.balanced) return left;
        Balanced right = isBalance(root.right);
        if(!right.balanced) return right;
        boolean balanced = Math.abs(left.height-right.height)<=1;
        int height = Math.max(left.height,right.height)+1;
        return new Balanced(balanced,height);
    }
    public boolean isBalanced(TreeNode<Integer> root){
        return isBalance(root).balanced;
    }
}
