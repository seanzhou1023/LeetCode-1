import java.util.ArrayList;
import java.util.List;

/**
 * Created by eric on 3/12/17.
 */
public class T052 {
    public static void nQueens(List<Integer> res, int[] lastTried, int row){
        if(row>lastTried.length-1) return;
        int start = 0;
        for(int i=start;i<lastTried.length;i++){
            boolean available = true;
            for(int j=row-1;j>=0;j--){
                int rdx = j; int cdx = lastTried[j];
                if((i==cdx || (row+i==rdx+cdx)
                        || (row-i==rdx-cdx))){available = false;break;}
            }
            if(available){
                lastTried[row] = i;
                if(row==lastTried.length-1){
                    res.add(0);
                }else nQueens(res,lastTried,row+1);
            }
            lastTried[row] = -1;
        }
    }
    public static int totalNQueens(int n){
        List<Integer> res = new ArrayList<>();
        int[] lastTried = new int[n];
        for(int j=0;j<n;j++)
            lastTried[j] = -1;
        nQueens(res,lastTried,0);
        return res.size();
    }

    public static void main(String[] args) {
        System.out.println(totalNQueens(4));
    }
}
