/**
 * Created by eric on 4/22/17.
 * next time become faster
 */
public class T562 {
    public int dfsR(int[][] M, int i, int j){
        int res = 0;
        while(j<M[0].length && M[i][j]==1){
            res++;
            j++;
        }
        return res;
    }
    public int dfsV(int[][] M, int i, int j){
        int res = 0;
        while(i<M.length && M[i][j]==1){
            res++;
            i++;
        }
        return res;
    }
    public int dfsD(int[][] M, int i, int j){
        int res = 0;
        while(i<M.length && j<M[0].length && M[i][j]==1){
            res++;
            i++;j++;
        }
        return res;
    }
    public int dfsA(int[][] M, int i, int j){
        int res = 0;
        while(i>=0 && j<M[0].length && M[i][j]==1){
            res++;
            i--;j++;
        }
        return res;
    }
    public int longestLine(int[][] M){
        int res = 0;
        for(int i=0;i<M.length;i++)
            for(int j=0;j<M[0].length;j++){
            if(M[i][j]==1){
                int R = dfsR(M,i,j);
                int V = dfsV(M,i,j);
                int D = dfsD(M,i,j);
                int A = dfsA(M,i,j);
                int n1 = Math.max(R,V), n2 = Math.max(D,A);
                int n = Math.max(n1,n2);
                res = Math.max(n,res);
            }
        }
        return res;
    }
}
