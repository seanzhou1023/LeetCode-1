import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by eric on 4/8/17.
 * all level traversal, TLE - test case: skew tree 1000 depth
 * solution passed: if current node is null, get rid of it's children,
 * only reserve one of the null to determine if it's left or right
 *
 * next time try recursion
 */
public class T297 {
    static class Codec {
        // Encodes a tree to a single string.
        public static String serialize(TreeNode root) {
            if(root==null) return "";
            StringBuilder sb = new StringBuilder();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()){
                int size = queue.size();
                boolean lastLevel = true;
                for(int i=0;i<size;i++){
                    TreeNode cur = queue.poll();
                    sb.append(cur==null?"null":cur.val).append("#");
                    if(cur!=null){
                        TreeNode left = cur.left;
                        TreeNode right = cur.right;
                        queue.offer(left);
                        queue.offer(right);
                        if(left!=null || right!=null) lastLevel = false;
                    }
                }
                if(lastLevel) break;
            }
            sb.setLength(sb.length()-1);
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public static TreeNode deserialize(String data) {
            if(data.length()<1) return null;
            String[] nodeStr = data.split("#");
            Queue<TreeNode> queue = new LinkedList<>();
            TreeNode root = new TreeNode(Integer.valueOf(nodeStr[0]));
            queue.offer(root);
            int start = 0;
            while(true){
                boolean lastLevel = true;
                int size = queue.size();
                if(start+size>=nodeStr.length) break;
                for(int s=0;s<size;s++){
                    TreeNode cur = queue.poll();
                    if(cur!=null){
                        start++;
                        Integer left = nodeStr[start].equals("null")?null:
                                Integer.valueOf(nodeStr[start]);
                        start++;
                        Integer right = nodeStr[start].equals("null")?null:
                                Integer.valueOf(nodeStr[start]);
                        if(left!=null) cur.left = new TreeNode(left);
                        if(right!=null) cur.right = new TreeNode(right);
                        queue.offer(cur.left);
                        queue.offer(cur.right);
                    }
                }
            }
            return root;
        }
    }
    public static void main(String[] args) {
        String data = "1#null#null";
        TreeNode root = Codec.deserialize(data);
        String reStore = Codec.serialize(root);
        System.out.println(reStore);
    }
}
