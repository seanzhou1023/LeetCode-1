import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by eric on 4/3/17.
 */
public class T173 {
    static class BSTIterator {
        private Stack<TreeNode> stack;
        public BSTIterator(TreeNode root) {
            stack = new Stack<>();
            TreeNode cur = root;
            while(cur!=null){
                stack.push(cur);
                if(cur.left!=null)
                    cur = cur.left;
                else break;
            }
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        /** @return the next smallest number */
        public int next() {
            TreeNode cur = stack.pop();
            int val = cur.val;
            if(cur.right!=null){
                cur = cur.right;
                while(cur!=null){
                    stack.push(cur);
                    if(cur.left!=null)
                        cur = cur.left;
                    else break;
                }
            }
            return val;
        }
    }
}
