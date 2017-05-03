/**
 * Created by eric on 3/20/17.
 * it's easy to do recursively, change to iteratively next time
 */
public class T105 {
    public static TreeNode buildTree(int[] preorder, int[] inorder){
        if(preorder.length==0) return null;
        else if(preorder.length==1)
            return new TreeNode(preorder[0]);
        else{
            TreeNode root = new TreeNode(preorder[0]);
            int rootIdx = 0;
            while(inorder[rootIdx]!=preorder[0]) rootIdx++;
            int leftSize = rootIdx, rightSize = preorder.length-1-rootIdx;
            int[] leftIn = new int[leftSize], rightIn = new int[rightSize];
            int[] leftPre = new int[leftSize], rightPre = new int[rightSize];
            for(int i=0;i<leftSize;i++){
                leftPre[i] = preorder[i+1];
                leftIn[i] = inorder[i];
            }
            for(int i=0;i<rightSize;i++){
                rightPre[i] = preorder[i+1+leftSize];
                rightIn[i] = inorder[i+1+leftSize];
            }
            root.left = leftSize!=0?buildTree(leftPre,leftIn):null;
            root.right = rightSize!=0?buildTree(rightPre,rightIn):null;
            return root;
        }
    }
}
