import java.util.*;

/**
 * Created by eric on 3/30/17.
 */
public class T315 {
    static class Node{
        Node left,right;
        int val, sum, dup=1;
        Node(int val, int sum){
            this.val = val;
            this.sum = sum;
        }
    }
    private static Node insert(Node root, int number, Integer[] res,
                               int i, int preSum){
        if(root==null){
            root = new Node(number,0);
            res[i] = preSum;
        }else if(number==root.val){
            root.dup++;
            res[i] = preSum + root.sum;
        }else if(root.val>number){
            root.sum++;
            root.left = insert(root.left,number,res,i,preSum);
        }else{
            root.right = insert(root.right,number,res,i,preSum+root.dup+root.sum);
        }
        return root;
    }
    public static List<Integer> countSmaller(int[] nums){
        Integer[] res = new Integer[nums.length];
        Node root = null;
        for(int i=nums.length-1;i>=0;i--){
            root = insert(root,nums[i],res,i,0);
        }
        return Arrays.asList(res);
    }

    public static void main(String[] args) {
        int[] nums = {5,2,6,1};
        System.out.println(countSmaller(nums));
    }
}

