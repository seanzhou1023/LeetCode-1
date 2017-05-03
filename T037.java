import java.util.*;

/**
 * Created by eric on 5/2/17.
 */
public class T037 {
    final char[] choice = {'1','2','3','4','5','6','7','8','9'};
    public static boolean isValid(char[][] board){
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
    public boolean solveSudoku(char[][] board, Map<Integer,Set<Character>> seen){
        if(seen.size()==243){
            return isValid(board);
        }
        for(int k=0;k<81;k++){//by rows
            int i = k/9, j = k%9;
            List<Character> left = new ArrayList<>();
            for(char c: choice){
                if(!seen.get(i+1).contains(c))
                    left.add(c);
            }
            int pos = 0;
            if(board[i][j]=='.'){
                char addTo = left.get(pos++);
                seen.get((i+1)).add(addTo);
                seen.get(10*(j+1)).add(addTo);
                seen.get(100*((i/3)*3+j/3+1)).add(addTo);
                board[i][j] = addTo;
                if(isValid(board) && solveSudoku(board,seen)) return true;
                board[i][j] = '.';
                pos--;
                seen.get((i+1)).remove(addTo);
                seen.get(10*(j+1)).remove(addTo);
                seen.get(100*((i/3)*3+j/3+1)).remove(addTo);
            }
        }
        return isValid(board);
    }
    public void solveSudoku(char[][] board){
        Map<Integer,Set<Character>> seen = new HashMap<>();
        for(int i=0;i<9;i++)
            for(int j=0;j<9;j++){
                char c = board[i][j];
                if(c!='.'){
                    seen.putIfAbsent(i+1,new HashSet<>());
                    seen.get(i+1).add(c);
                    seen.putIfAbsent(10*(j+1),new HashSet<>());
                    seen.get(10*(j+1)).add(c);
                    seen.putIfAbsent(100*((i/3)*3+j/3+1),new HashSet<>());
                    seen.get(100*((i/3)*3+j/3+1)).add(c);
                }
            }
        System.out.println(solveSudoku(board,seen));
    }

    public static void main(String[] args) {
        char[][] board = new char[9][9];
        board[0] = "53..7....".toCharArray();
        board[1] = "6..195...".toCharArray();
        board[2] = ".98....6.".toCharArray();
        board[3] = "8...6...3".toCharArray();
        board[4] = "4..8.3..1".toCharArray();
        board[5] = "7...2...6".toCharArray();
        board[6] = ".6....28.".toCharArray();
        board[7] = "...419..5".toCharArray();
        board[8] = "....8..79".toCharArray();
        T037 t = new T037();
        t.solveSudoku(board);
        for(char[] c: board)
            System.out.println(Arrays.toString(c));
    }
}
