import java.util.ArrayList;
import java.util.List;

/**
 * Created by eric on 3/23/17.
 * preorder tree traversal, each node may have at most 10 childer (0~9)
 */
public class T386 {
    public static void dfs(int cur, int n, List<Integer> res){
        if(cur>n) return;
        else{
            res.add(cur);
            for(int i=0;i<10;i++){
                if(10*cur+i>n) return;
                dfs(10*cur+i,n,res);
            }
        }
    }
    public static List<Integer> lexicalOrder(int n){
        List<Integer> res = new ArrayList<>();
        for(int i=1;i<10;i++)
            dfs(i,n,res);
        return res;
    }
    public static List<Integer> lexicalOrderIt(int n){
        List<Integer> res = new ArrayList<>();
        int cur = 1;
        for(int i=1;i<=n;i++){
            res.add(cur);
            if(cur*10<=n) cur*=10;
            else if(cur%10!=9 && cur+1<=n){
                cur++;
            }else{
                while((cur/10)%10==9) cur/=10;
                cur = cur/10+1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lexicalOrder(18));
        System.out.println(lexicalOrderIt(18));
    }
}
