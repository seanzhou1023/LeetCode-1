import java.util.*;

/**
 * Created by eric on 3/22/17.
 */
public class T311 {
    public static int[][] multiplyList(int[][] A, int[][] B){
        int rowA = A.length, colA = A[0].length, colB = B[0].length;
        int[][] res = new int[rowA][colB];
        List<Integer>[] sparseA = new List[rowA];
        for(int i=0;i<rowA;i++){
            List<Integer> cur = new ArrayList<>();
            for(int j=0;j<colA;j++){
                if(A[i][j]!=0){
                    cur.add(j);
                    cur.add(A[i][j]);
                }
            }
            sparseA[i] = cur;
        }
        for(int i=0;i<rowA;i++){
            for(int k=0;k<sparseA[i].size()-1;k+=2){
                int idx = sparseA[i].get(k);
                int val = sparseA[i].get(k+1);
                for(int j=0;j<colB;j++){
                    res[i][j] += val*B[idx][j];
                }
            }
        }
        return res;
    }
    public static int[][] multiply(int[][] A, int[][] B){
        int rowA = A.length, colA = A[0].length, colB = B[0].length;
        int[][] C = new int[rowA][colB];
        for(int i=0;i<rowA;i++)
            for(int j=0;j<colA;j++){
                if(A[i][j]!=0){
                    for(int k=0;k<colB;k++){
                        if(B[j][k]!=0) C[i][k] += A[i][j]*B[j][k];
                    }
                }
            }
        return C;
    }
    public static int[][] multiplyHash(int[][] A, int[][] B){
        if (A == null || A[0] == null || B == null || B[0] == null) return null;
        int m = A.length, n = A[0].length, l = B[0].length;
        int[][] C = new int[m][l];
        Map<Integer, Map<Integer, Integer>> tableA = new HashMap<>();
        for(int k = 0; k < m; k++) {
            tableA.put(k, new HashMap<Integer, Integer>());
            for(int j = 0; j < n; j++) {
                if (A[k][j] != 0){
                    tableA.get(k).put(k, A[k][j]);
                }
            }
        }
        Map<Integer, Map<Integer, Integer>> tableB = new HashMap<>();
        for(int k = 0; k < l; k++) {
            tableB.put(k, new HashMap<Integer, Integer>());
            for(int j = 0; j < n; j++) {
                if (B[j][k] != 0){
                    tableB.get(k).put(k, B[j][k]);
                }
            }
            if(tableB.get(k).size()==0) tableB.remove(k);
        }
        for(int i:tableA.keySet()){
            for(int j:tableB.keySet()){
                for(int colA:tableA.get(i).keySet()){
                    for(int rowB:tableB.get(j).keySet()){
                        C[i][j] += tableA.get(i).get(colA)*tableB.get(j).get(rowB);
                    }
                }
            }
        }
        return C;
    }

    public static void main(String[] args) {
        int[][] A = {{1,0,0},{-1,0,3}};
        int[][] B = {{7,0,0},{0,0,0},{0,0,1}};
        System.out.println(multiplyHash(A,B));
    }
}
