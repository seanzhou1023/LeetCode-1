import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by eric on 4/21/17.
 * added path compression
 * weighted quick union
 */
public class T547 {
    int cnt;
    int[] idx, weight;
    public int root(int i){
        while(i!=idx[i]){
            int cur = i;
            i = idx[i];
            idx[cur] = i;
        }
        return i;
    }
    public void add(int a, int b){
        int ar = root(a), br = root(b);
        if(weight[ar]>weight[br]){
            idx[br] = ar;
            weight[ar] += weight[br];
        }else{
            idx[ar] = br;
            weight[br] += weight[ar];
        }
        if(ar!=br) cnt--;
    }
    public int findCircleNum(int[][] M){
        idx = new int[M.length];
        weight = new int[M.length];
        cnt = M.length;
        for(int i=0;i<M.length;i++){
            idx[i] = i;
            weight[i] = 1;
        }
        for(int i=0;i<M.length;i++){
            for(int j=i+1;j<M.length;j++){
                if(M[i][j]==1) add(i,j);
            }
            if(cnt==1) return cnt;
        }
        return cnt;
    }
    public int findCircleNumSlow(int[][] M){
        int[] idx = new int[M.length];
        for(int i=0;i<M.length;i++) idx[i] = i;
        for(int i=0;i<M.length;i++)
            for(int j=i+1;j<M.length;j++){
                if(M[i][j]==1){
                    int cur = idx[j];
                    for(int k=0;k<M.length;k++)
                        if(idx[k]==cur) idx[k] = idx[i];
                }
            }
        Set<Integer> res = new HashSet<>();
        for(int i: idx) res.add(i);
        return res.size();
    }
    public static void main(String[] args) {
        T547 t = new T547();
        int[][] M = {{1,0,0,1},
                     {0,1,1,0},
                     {0,1,1,1},
                     {1,0,1,1}};
        int[][] M0 = new int[100][100];
        for(int[] m: M0) Arrays.fill(m,1);
        System.out.println(t.findCircleNum(M));
    }
}
