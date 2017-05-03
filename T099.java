import java.util.ArrayList;
import java.util.List;

/**
 * Created by eric on 4/26/17.
 */
public class T099 {
    public TreeNode build(){
        TreeNode root = new TreeNode(0);
        TreeNode l = new TreeNode(1);
        root.left = l;
        return root;
    }
    public void recoverTree(TreeNode root){
        if(root==null) return;
        List<TreeNode> res = new ArrayList<>();
        TreeNode cur = root;
        TreeNode last = null;
        while(cur!=null){
            if(cur.left==null){
                if(last!=null && last.val>cur.val){
                    res.add(last);
                    res.add(cur);
                }
                last = cur;
                cur = cur.right;
            }else{
                TreeNode pre = cur.left;
                while(pre.right!=null && pre.right!=cur)
                    pre = pre.right;
                if(pre.right==null){
                    pre.right = cur;
                    cur = cur.left;
                }else{
                    if(last!=null && last.val>cur.val){
                        res.add(last);
                        res.add(cur);
                    }
                    pre.right = null;
                    last = cur;
                    cur = cur.right;
                }
            }
        }
        last = res.get(0);
        if(res.size()==2) cur = res.get(1);
        else cur = res.get(3);
        int tmp = last.val;
        last.val = cur.val;
        cur.val = tmp;
    }

    public static void main(String[] args) {
        T099 t = new T099();
        TreeNode root = t.build();
        t.recoverTree(root);
        System.out.println(root.val);
    }
}
