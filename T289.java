/**
 * Created by eric on 3/21/17.
 */
public class T289 {
    public static int getLiveNeighbors(int[][] board,int i, int j){
        int[][] dir = {{-1,-1},{-1,0},{-1,1},{0,-1},
                       {0,1},{1,-1},{1,0},{1,1}};
        int live = 0, row = board.length, col = board[0].length;
        for(int d=0;d<dir.length;d++){
            if(i+dir[d][0]>=0 && i+dir[d][0]<row &&
                    j+dir[d][1]>=0 && j+dir[d][1]<col)
                live += board[i+dir[d][0]][j+dir[d][1]]&1;
        }
        return live;
    }
    public static void gameOfLife(int[][] board){
        for(int i=0;i<board.length;i++)
            for(int j=0;j<board[0].length;j++){
                int neighbors = getLiveNeighbors(board,i,j);
                if((board[i][j]&1)==1){
                    if(neighbors==2 || neighbors==3) board[i][j] = 3;
                }else{
                    if(neighbors==3) board[i][j] = 2;
                }
            }
        for(int i=0;i<board.length;i++)
            for(int j=0;j<board[0].length;j++)
                board[i][j] >>= 1;
    }
}
