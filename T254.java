import java.util.*;

/**
 * Created by eric on 3/15/17.
 */
public class T254 {
    public static void addFactors(List<List<Integer>> res, List<Integer> tmp,
                                  int start, List<Integer> factors, int n){
        if(n==1){
            List<Integer> result = new ArrayList<>(tmp);
            res.add(result);
            return;
        }
        for(int i=start;i<factors.size();i++){
            int div = factors.get(i);
            if(n%div==0){
                tmp.add(div);
                addFactors(res,tmp,i,factors,n/div);
                tmp.remove(tmp.size()-1);
            }
        }
    }
    public static List<List<Integer>> getFactors(int n){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        List<Integer> factors = new ArrayList<>();
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
              if(i*i==n) factors.add(i);
              else{
                  factors.add(i);
                  factors.add(n/i);
              }
            }
        }
        addFactors(res,tmp,0,factors,n);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(getFactors(32));
    }
}
