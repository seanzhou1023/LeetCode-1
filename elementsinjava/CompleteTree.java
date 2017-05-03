package elementsinjava;

/**
 * Created by eric on 4/25/17.
 * postorder check the max size of complete tree
 */
public class CompleteTree {
    int max;
    public TreeNode<Integer> build(){
        TreeNode<Integer> root = new TreeNode<>(0);
        TreeNode<Integer> l11 = new TreeNode<>(1);
        TreeNode<Integer> l12 = new TreeNode<>(2);
        TreeNode<Integer> l21 = new TreeNode<>(3);
        root.left = l11;root.right = l12;
        l12.left = l21;
        return root;
    }
    public class Complete{
        public boolean completed;
        public int size, height;
        Complete(boolean completed, int size, int height){
            this.completed = completed;
            this.size = size;
            this.height = height;
        }
    }
    public Complete checkSize(TreeNode<Integer> root){
        if(root==null) return new Complete(true,0,-1);
        Complete left = checkSize(root.left);
        Complete right = checkSize(root.right);
        boolean completed = false;
        int size = left.size + right.size + 1;
        if(left.completed && right.size==Math.pow(2,right.height+1)-1){
            completed = true;
            max = Math.max(max,size);
        }
        int height = Math.max(left.height,right.height) + 1;
        return new Complete(completed,size,height);
    }
    public int getMax(TreeNode<Integer> root){
        max = 0;
        checkSize(root);
        return max;
    }

    public static void main(String[] args) {
        CompleteTree ct = new CompleteTree();
        TreeNode root = ct.build();
        System.out.println(ct.getMax(root));
    }
}
