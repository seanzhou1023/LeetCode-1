import java.util.ArrayList;
import java.util.List;

/**
 * Created by eric on 3/13/17.
 */
public class T054 {
    public static List<Integer> spiralOrder(int[][] matrix){
        List<Integer> res = new ArrayList<>();
        if(matrix==null || matrix.length<1) return res;
        int rows = matrix.length, cols = matrix[0].length;
        int procedures = Math.min(rows,cols)/2;
        for(int p=0;p<procedures;p++){
            for(int i=p;i<cols-p-1;i++)
                res.add(matrix[p][i]);
            for(int j=p;j<rows-p-1;j++)
                res.add(matrix[j][cols-p-1]);
            for(int k=cols-p-1;k>p;k--)
                res.add(matrix[rows-p-1][k]);
            for(int l=rows-p-1;l>p;l--)
                res.add(matrix[l][p]);
        }
        if((rows%2==1 && cols%2!=1) || (rows==1)){
            if((rows>1 && cols!=2) || rows==1){
                for(int m=procedures;m<cols-procedures;m++)
                    res.add(matrix[procedures][m]);
            }
        }else{
            if(cols!=2){
                for(int m=procedures;m<rows-procedures;m++)
                    res.add(matrix[m][procedures]);
            }
        }

        return res;
    }

    public static void main(String[] args) {
//        int[][] matrix = {{1,2,3,5,6,5,6},
//                          {5,6,7,7,7,5,6},
//                          {5,6,7,4,5,5,6},
//                          {4,5,6,5,4,5,6}};
        int[][] matrix = {{6},{9},{7}};
        System.out.println(spiralOrder(matrix));
    }
}
