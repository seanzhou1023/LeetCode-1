import java.util.*;

/**
 * Created by eric on 3/12/17.
 */
public class T077 {
    public static void recurse(List<List<Integer>> res, List<Integer> tmp,
                               int start, int n, int k){
        if(k==0){
            res.add(new ArrayList<>(tmp));
            return ;
        }
        for(int i=start;i<=n-k+1;i++){
            tmp.add(i);
            recurse(res,tmp,i,n,k-1);//i include all the [1,1] [2,2]...[3,2] [4,2]
            tmp.remove(tmp.size()-1);
        }
    }
    public static List<List<Integer>> combine(int n, int k){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        recurse(res,tmp,1,n,k);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(combine(5,2));
    }
}
