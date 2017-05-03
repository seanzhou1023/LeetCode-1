/**
 * Created by eric on 2/28/17.
 */
public class T221 {
    public int maximalSquare(char[][] matrix){
        if(matrix==null || matrix.length==0) return 0;
        int row = matrix.length, col = matrix[0].length;
        int maxLen = 0;
        int[][] res = new int[row][col];
        for(int i=1;i<row+1;i++)
            for(int j=1;j<col+1;j++){
                if(matrix[i-1][j-1]=='0')
                    res[i][j] = 0;
                else{
                    int temp = res[i-1][j]<res[i][j-1]?res[i-1][j]:res[i][j-1];
                    res[i][j] = res[i-1][j-1]<temp?res[i-1][j-1]:temp;
                    res[i][j]++;
                }
                if(res[i][j]>maxLen) maxLen = res[i][j];
            }
        return maxLen*maxLen;
    }

    public static void main(String[] args) {

    }
}
