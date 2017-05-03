import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by eric on 3/10/17.
 */
public class T036 {
    public static boolean isValidSudoku(char[][] board){
        Set<Character> row, col, box;
        for(int i=0;i<9;i++){
            row = new HashSet<>();
            col = new HashSet<>();
            box = new HashSet<>();
            for(int j=0;j<9;j++){
                if(board[i][j]!='.' && !row.add(board[i][j]))
                    return false;
                if(board[j][i]!='.' && !col.add(board[j][i]))
                    return false;
                int bi = (i/3)*3 + j%3, bj = (i%3)*3 + j/3;
                if(board[bi][bj]!='.' && !box.add(board[bi][bj]))
                    return false;
            }
        }
        return true;
    }
    public static boolean isValidSudoku1(char[][] board){
        Set<String> seen = new HashSet<>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.') continue;
                String key = "("+board[i][j]+")";
                if(!seen.add(i+key) || !seen.add(key+j) || !seen.add(i/3+key+j/3))
                    return false;
            }
        }
        return true;
    }
    public static boolean isValidSudoku2(char[][] board){
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    int diff = board[i][j]-'0';
                    int row = diff*10+i, col = diff*100+j, cube = diff*1000+(i/3)*3+j/3;
                    if(!set.add(row) || !set.add(col) || !set.add(cube))
                        return false;
                }
            }
        }
        return true;
    }
    public static boolean isValidSudoku3(char[][] board){
        boolean[] seen = new boolean[9010];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    int diff = board[i][j]-'0';
                    int row = diff*10+i, col = diff*100+j, cube = diff*1000+(i/3)*3+j/3;
                    if(seen[row] || seen[col] || seen[cube]) return false;
                    seen[row] = true;
                    seen[col] = true;
                    seen[cube] = true;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = new char[9][9];
        Random random = new Random();
        for(int i=0;i<9;i++)
            for(int j=0;j<9;j++){
                int next = random.nextInt(15);
                if(next<10) board[i][j] = (char)(next+'0');
                else board[i][j] = '.';
            }
//        long t0 = System.nanoTime();
//        for(int i=0;i<2000000;i++)
//            isValidSudoku(board);
//        long t1 = System.nanoTime();
//        for(int i=0;i<2000000;i++)
//            isValidSudoku1(board);
//        long t2 = System.nanoTime();
//        for(int i=0;i<2000000;i++)
//            isValidSudoku2(board);
//        long t3 = System.nanoTime();
//        for(int i=0;i<2000000;i++)
//            isValidSudoku3(board);
//        long t4 = System.nanoTime();
//        System.out.println((t1-t0)/1e9+":"+(t2-t1)/1e9+":"+(t3-t2)/1e9+":"+(t4-t3)/1e9);
        System.out.println(isValidSudoku2(board));
        "asd".equals("asd");
    }
}
