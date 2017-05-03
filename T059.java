import java.util.*;

/**
 * Created by eric on 3/13/17.
 */
public class T059 {
    public static int[][] generateMatrix(int n){
        int[][] matrix = new int[n][n];
        int procedures = n/2;
        int start = 1;
        for(int i=0;i<procedures;i++){
            for(int a=i;a<n-i-1;a++)
                matrix[i][a] = start++;
            for(int b=i;b<n-i-1;b++)
                matrix[b][n-i-1] = start++;
            for(int c=n-i-1;c>i;c--)
                matrix[n-1-i][c] = start++;
            for(int d=n-i-1;d>i;d--)
                matrix[d][i] = start++;
        }
        if(n%2==1) matrix[procedures][procedures] = start;
        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = generateMatrix(7);
        for(int[] m:matrix)
            System.out.println(Arrays.toString(m));
    }
}
