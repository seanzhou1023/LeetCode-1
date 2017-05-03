import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by eric on 4/5/17.
 * BFS or brute-force O(m^2*n^2)
 * median is the optimal point instead of the mean
 * collect the rows and cols with "selection sort"
 *
 */
public class T296 {
    public int calculate(List<Integer> pos){
        int res = 0, s = 0, e = pos.size()-1;
        while(s<e){
            res += pos.get(e)-pos.get(s);
        }
        return res;
    }
    public int minTotalDistance(int[][] grid){
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<Integer>();
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    rows.add(i);
                }
            }
        for(int j=0;j<grid[0].length;j++)
            for(int i=0;i<grid.length;i++){
                if(grid[i][j]==1)
                    cols.add(j);
            }
        int row = rows.get(rows.size()/2);
        int col = cols.get(cols.size()/2);
        int res = 0;
        res += calculate(rows);
        res += calculate(cols);
        return res;
    }
}
