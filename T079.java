/**
 * Created by eric on 3/11/17.
 */
public class T079 {
    public static boolean explore(char[][] board, char[] wchar,
                                  int i, int j, int pos){
        if(pos==wchar.length) return true;
        if(i<0 || j<0 || i>board.length-1
                || j>board[0].length-1 || board[i][j]!=wchar[pos]) return false;
        board[i][j] = '*';
        boolean res = explore(board,wchar,i-1,j,pos+1) ||
                explore(board,wchar,i,j+1,pos+1) ||
                explore(board,wchar,i+1,j,pos+1) ||
                explore(board,wchar,i,j-1,pos+1);
        board[i][j] = wchar[pos];
        return res;
    }
    public static boolean exist(char[][] board, String word){
        char[] wchar = word.toCharArray();
        for(int i=0;i<board.length;i++)
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0))
                    if(explore(board,wchar,i,j,0)) return true;
            }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},
                          {'S','F','E','S'},
                          {'A','D','E','E'}};
        String word = "AC";
        System.out.println(exist(board,word));
    }
}
