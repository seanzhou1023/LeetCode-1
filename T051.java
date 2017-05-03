import java.util.*;

/**
 * Created by eric on 3/11/17.
 * solved the problem to 8,for n>=9 stackoverflow
 */
public class T051 {
    public static boolean isValid(int lastRow,int lastCol,
                              int currentRow, int currentCol){
        if(currentCol==lastCol || (currentRow+currentCol==lastRow+lastCol)
                || (currentRow-currentCol==lastRow-lastCol)) return false;
        return true;
    }
    public static void nQueens(List<int[]>tmp, int[] lastTried, int row){
        if(row>lastTried.length-1) return;
        int start = 0;
        for(int i=start;i<lastTried.length;i++){
            boolean available = true;
            for(int j=row-1;j>=0;j--){
                int rdx = j; int cdx = lastTried[j];
                if(!isValid(rdx,cdx,row,i)){available = false;break;}
            }
            if(available){
                lastTried[row] = i;
                if(row==lastTried.length-1){
                    int[] success = new int[lastTried.length];
                    for(int k=0;k<lastTried.length;k++)
                        success[k] = lastTried[k];
                    tmp.add(success);
                }else nQueens(tmp,lastTried,row+1);
            }
            lastTried[row] = -1;
        }
    }
    public static List<String> transform(int[] lastTried){
        List<String> res = new ArrayList<>();
        for(int i=0;i<lastTried.length;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<lastTried.length;j++){
                if(j==lastTried[i]) sb.append("Q");
                else sb.append(".");
            }
            res.add(sb.toString());
        }
        return res;
    }
    public static List<List<String>> solveNQueens(int n){
        List<List<String>> res = new ArrayList<>();
        List<int[]> tmp = new ArrayList<>();
        int[] lastTried = new int[n];
        for(int j=0;j<n;j++)
            lastTried[j] = -1;
        nQueens(tmp,lastTried,0);
        System.out.println(tmp.size());
        for(int i=0;i<tmp.size();i++)
            res.add(transform(tmp.get(i)));
        return res;
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(9));
    }
}
