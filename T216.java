import java.util.*;

/**
 * Created by eric on 3/15/17.
 */
public class T216 {
    public static void addSum(List<List<Integer>> res, List<Integer> tmp,
                              int k, int n, int start){
        if(k==0){
            if(n==0){
                List<Integer> result = new ArrayList<>(tmp);
                res.add(result);
            }
        }else if(k<0) ;
        else{
            for(int i=start;i<=9;i++){
                tmp.add(i);
                addSum(res,tmp,k-1,n-i,i+1);
                tmp.remove(tmp.size()-1);
            }
        }
    }
    public static List<List<Integer>> combinationSum3(int k, int n){
        List<List<Integer>> res = new ArrayList<>();
        if(k>n || n>45) return res;
        List<Integer> tmp = new ArrayList<>();
        addSum(res,tmp,k,n,1);
        return res;
    }

    public static void main(String[] args) {
        int k=3, n=9;
        System.out.println(combinationSum3(3,7));
    }
}
