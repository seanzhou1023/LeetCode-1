import java.util.Arrays;

/**
 * Created by eric on 3/14/17.
 */
public class T073 {
    public static void setZeroes(int[][] matrix){
        int col0 = 1;//column 0 -> row 0
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][0]==0) col0 = 0;
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    matrix[0][j] = matrix[i][0] = 0;
                }
            }
        }
        for(int i=matrix.length-1;i>=0;i--){
            for(int j=matrix[0].length-1;j>0;j--){
                if(matrix[0][j]==0 || matrix[i][0]==0)
                    matrix[i][j] = 0;
            }
            if(col0==0) matrix[i][0] = 0;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,1,1},
                          {0,1,2}};
        setZeroes(matrix);
        for(int i=0;i<matrix.length;i++)
            System.out.println(Arrays.toString(matrix[i]));
    }
}
