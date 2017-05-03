import java.util.*;

/**
 * Created by eric on 4/29/17.
 * first try tree: 120/158
 * second try - O(n^2): 155/158 TLE correct logic
 * third try - modified the first try logic error: add function! check it next time - correct!
 * fourth try: just modified a little bit, boost the performance
 * no use to check the
 *
 * path compression + weights balance -> 16ms
 * + 1 based index -> 13ms (100%)
 */
public class T305 {
    final int[] dir = {0,1,0,-1,0};
    int[] weights;
    public int root(int[] id, int idx){
        if(id[idx]==-1) return -1;
        while(id[idx]!=idx)
            idx = id[id[idx]];
        return idx;
    }
    public int add(int[] id, int[] op, int m, int n, int count){
        int root = op[0] * n + op[1];
        id[root] = root;
        count++;
        weights[root] = 1;
        for(int i=0;i<dir.length-1;i++){
            int r = op[0] + dir[i], c = op[1] + dir[i+1];
            int newIdx = r * n + c;
            if(r<0 || c<0 || r>=m || c>=n || id[newIdx]==-1) continue;
            int rootNew = root(id,newIdx);
            if(rootNew!=root){
                if(weights[rootNew]>weights[root]){
                    id[root] = rootNew;
                    weights[rootNew] += weights[root];
                    root = rootNew;
                }else{
                    id[rootNew] = root;
                    weights[root] += weights[rootNew];
                }
                count--;
            }
        }
        return count;
    }
    public List<Integer> numIslands2(int m, int n, int[][] positions){
        List<Integer> res = new ArrayList<>();
        int[] id = new int[m*n];
        weights = new int[m*n];
        Arrays.fill(id,-1);//if one-based, don't have to do this
        int count = 0;
        for(int[] op: positions){
            count = add(id,op,m,n,count);
            res.add(count);
        }
        return res;
    }

    public static void main(String[] args) {
        T305 t = new T305();
        int[][] positions = {{0,1},{1,2},{2,1},{1,0},{0,2},{0,0},{1,1}};
        System.out.println(t.numIslands2(3,3,positions));
    }
}
