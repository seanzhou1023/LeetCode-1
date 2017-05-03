import java.util.ArrayList;
import java.util.*;

/**
 * Created by eric on 3/18/17.
 */
public class T130 {
    public static int level = 0, maxLevel = 0, r=0, c=0;
    public static void explore(boolean[][] table, char[][] board, int row, int col){
        level++;
        if(maxLevel<level){
            maxLevel = level;
            r = row;c = col;
        }
        System.out.println(level+":"+row+":"+col);
        table[row][col] = true;
        if(row>1 && !(table[row-1][col] || board[row-1][col]=='X'))
            explore(table,board,row-1,col);
        if(row<board.length-1 && !(table[row+1][col] || board[row+1][col]=='X'))
            explore(table,board,row+1,col);
        if(col>1 && !(table[row][col-1] || board[row][col-1]=='X'))
            explore(table,board,row,col-1);
        if(col<board[0].length-1 && !(table[row][col+1] || board[row][col+1]=='X'))
            explore(table,board,row,col+1);
        level--;
    }
//    public static void explore(boolean[][] table, char[][] board, int row, int col){
//        level++;
//        if(maxLevel<level){
//            maxLevel = level;
//            r = row;c = col;
//        }
//        System.out.println(level+":"+row+":"+col);
//        if(row<0 || row>board.length-1 || col<0
//                || col>board[0].length-1) return ;
//        if(table[row][col] && board[row][col]=='X') return;
////        board[row][col] = 'X';
//        explore(table,board,row-1,col);
//        explore(table,board,row,col-1);
//        explore(table,board,row+1,col);
//        explore(table,board,row,col+1);
//        level--;
//    }
    public static void solve(char[][] board){
        if(board.length<2 || board[0].length<2) return;
        int row = board.length, col = board[0].length;
        boolean[][] table = new boolean[row][col];
        for(int j=row-1;j>0;j--)// starting from left bottom
            if(board[j][0]=='O' && !table[j][0]){
                explore(table,board,j,0);
            }
        for(int j=1;j<col-1;j++)// starting from right bottom
            if(board[row-1][j]=='O' && !table[row-1][j]){
                explore(table,board,row-1,j);
            }
        for(int j=0;j<row-1;j++)// starting from right top
            if(board[j][col-1]=='O' && !table[j][col-1]){
                explore(table,board,j,col-1);
            }
        for(int j=col-2;j>=0;j--)// starting from left top
            if(board[0][j]=='O' && !table[0][j]){
                explore(table,board,0,j);
            }
        //
        for(int i=0;i<row;i++)
            for(int j=0;j<col;j++){
                if(board[i][j]=='O' && !table[i][j]) board[i][j] = 'X';
            }
    }
    public static void main(String[] args) {
        String[] matrix = {};
        char[][] board = new char[73][73];
        int cnt = 0;
        for(int i=0;i<73;i++){
            char[] tmp = matrix[i].toCharArray();
            for(int j=0;j<73;j++){
                board[i][j] = 'O';
                if(tmp[j]=='O') cnt++;
            }
        }
        System.out.println("cnt:"+cnt);
        solve(board);
        System.out.println("duh:"+maxLevel+":"+r+":"+c);
    }
}
