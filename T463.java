/**
 * Created by eric on 3/5/17.
 */
public class T463 {
    public static int islandPerimeter(int[][] grid){
        int res = 0;
        for(int row=0;row<grid.length;row++)
            for(int col=0;col<grid[0].length;col++){
                if(grid[row][col]==1){
                    int count = 0;
                    count += (row-1>=0 && grid[row-1][col]==1)?2:0;
                    count += (col-1>=0 && grid[row][col-1]==1)?2:0;
//                    count += (row+1<grid.length && grid[row+1][col]==1)?1:0;
//                    count += (col+1<grid[0].length && grid[row][col+1]==1)?1:0;
                    res += 4-count;
                }
            }
        return res;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        System.out.println(islandPerimeter(grid));
    }
}
