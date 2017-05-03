import java.util.Arrays;

/**
 * Created by eric on 3/7/17.
 */
public class T048 {
    public static void rotate(int[][] matrix){
        int len = matrix.length;
        for(int i=0;i<len;i++){
            for(int j=0;j<=len-1-i;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len-1-j][len-1-i];
                matrix[len-1-j][len-1-i] = temp;
            }
            for(int j=0;j<len/2;j++){
                int col = len-1-i;
                int temp = matrix[j][col];
                matrix[j][col] = matrix[len-1-j][col];
                matrix[len-1-j][col] = temp;
            }
        }
    }

    public static void fastRotate(int[][] matrix){
        int len = matrix.length;
        for(int i=0;i<=len/2;i++)
            for(int j=i;j<len-i-1;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len-1-j][i];
                matrix[len-1-j][i] = matrix[len-1-i][len-1-j];
                matrix[len-1-i][len-1-j] = matrix[j][len-1-i];
                matrix[j][len-1-i] = temp;
            }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        for(int i=0;i<matrix.length;i++)
            System.out.println(Arrays.toString(matrix[i]));
        fastRotate(matrix);
        fastRotate(matrix);
        fastRotate(matrix);
        for(int i=0;i<matrix.length;i++)
            System.out.println(Arrays.toString(matrix[i]));

    }
}
