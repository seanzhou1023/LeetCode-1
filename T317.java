import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by eric on 4/5/17.
 * first try, wrong implementation: dfs -> should be bfs
 * wtf bfs: be careful with the boolean function(have muiltiple repeated visit)
 * corner cases: not all the ones are reachable
 * too slow, needs optimization: save distance for each node
 *
 * 1. instead of moving from all zero, move from all buildings at once,
 *      to see if they can meet
 * 2.
 */
public class T317 {
    static class Pos{
        int row,col,distance;
        Pos(int r, int c, int d){ row=r;col=c;distance=d;}
    }
    public static int shortestDistance(int[][] grid){
        int result = Integer.MAX_VALUE, cnt=0;
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1) cnt++;
            }
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    boolean[][] visited = new boolean[grid.length][grid[0].length];
                    int cur = bfs(visited,grid,i,j,cnt);
                    if(cur<result) result = cur;
                }
            }
        return result==Integer.MAX_VALUE?-1:result;//be careful
    }
    public static int bfs(boolean[][] visited, int[][] grid,
                           int row, int col, int ones){
        Queue<Pos> queue = new LinkedList<>();
        queue.offer(new Pos(row,col,0));
        visited[row][col] = true;
        int[] direction = {0,1,0,-1,0};
        int total = 0;
        while(!queue.isEmpty()){
            Pos pos = queue.poll();
            int cur = grid[pos.row][pos.col];
            if(cur==0){
                for(int i=0;i<direction.length-1;i++){
                    int newRow = pos.row+direction[i],
                            newCol = pos.col+direction[i+1];
                    if(!(newRow<0 || newRow>grid.length-1) &&
                            !(newCol<0 || newCol>grid[0].length-1) &&
                            !visited[newRow][newCol]){
                        queue.offer(new Pos(newRow,newCol,pos.distance+1));
                        visited[newRow][newCol] = true;
                    }
                }
            }else if(cur==1){
                total += pos.distance;ones--;
            }
        }
        return (total==0 || ones!=0)?Integer.MAX_VALUE:total;//be careful
    }

    public static void main(String[] args) {
        int[][] grid = {{1,1,1,1,1,0},{0,0,0,0,0,1},{0,1,1,0,0,1},
                        {1,0,0,1,0,1},{1,0,1,0,0,1},{1,0,0,0,0,1},
                        {0,1,1,1,1,0}};
        System.out.println(shortestDistance(grid));
    }
}
