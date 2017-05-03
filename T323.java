/**
 * Created by eric on 4/21/17.
 * union find is not the fastest - adding path compression, faster
 */
public class T323 {
    int count;
    public int root(int[] idx, int i){
        while(i!=idx[i]) i = idx[i];
        return i;
    }
    public void add(int[] idx, int[] weight, int i, int j){
        int ri = root(idx,i), rj = root(idx,j);
        if(weight[ri]>weight[rj]){
            idx[rj] = ri;
            weight[ri] += weight[rj];
        }else{
            idx[ri] = rj;
            weight[rj] += weight[ri];
        }
        if(ri!=rj) count--;
    }
    public int countComponents(int n, int[][] edges){
        int[] idx = new int[n];
        int[] weight = new int[n];
        for(int i=0;i<n;i++){
            idx[i] = i;
            weight[i] = 1;
        }
        count = n;
        for(int[] edge: edges){
            add(idx,weight,edge[0],edge[1]);
        }
        return count;
    }
}
