/**
 * Created by eric on 3/16/17.
 */
public class T419 {
    public static void explore(int row, int col, char[][] board){
        if(row<0 || row>board.length-1 || col<0 || col>board[0].length-1) return;
        if(board[row][col]=='.') return;
        board[row][col] = '.';
        explore(row-1,col,board);
        explore(row+1,col,board);
        explore(row,col-1,board);
        explore(row,col-1,board);
    }
    public static int countBattleships(char[][] board){
        int cnt = 0;
        for(int i=0;i<board.length;i++)
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='X'){
                    cnt++;explore(i,j,board);
                }
            }
        return cnt;
    }

    public static void main(String[] args) {
        char[][] board = {{'X','.','.','X'},
                          {'.','.','.','X'},
                          {'.','.','.','X'}};
        System.out.println(countBattleships(board));
    }
}
