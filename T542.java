import java.util.*;

/**
 * Created by eric on 3/19/17.
 * two sweeps DP?
 */
public class T542 {

    public static List<List<Integer>> updateMatrix(List<List<Integer>> matrix){
        int row = matrix.size(), col = matrix.get(0).size();
        List<List<Integer>> res = new ArrayList<>();
        return res;
    }

    public static void main(String[] args) {
        int row = 1001, col = 1001;
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<row;i++){
            List<Integer> tmp = new ArrayList<Integer>
                    (Collections.nCopies(col,1));
            res.add(tmp);
        }
        for(int i=0;i<col;i++){
            res.get(0).set(i,0);
            res.get(row-1).set(i,0);
        }
        for(int i=0;i<row;i++){
            res.get(i).set(0,0);
            res.get(i).set(col-1,0);
        }
        List<List<Integer>> matrix = new ArrayList<>();
        matrix = updateMatrix(res);
        System.out.println(matrix.get((row-1)/2).get((col-1)/2));
    }
}
