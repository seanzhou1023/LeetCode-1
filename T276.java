/**
 * Created by eric on 3/22/17.
 */
public class T276 {
    public int numWays(int n, int k){
        if(n==0) return 0;
        if(n==1) return k;
        int same = k;
        int diff = k*(k-1);
        for(int i=2;i<n;i++){
            int tmp = same;
            same = diff;
            diff = (tmp+diff)*(k-1);
        }
        return same+diff;
    }
}
