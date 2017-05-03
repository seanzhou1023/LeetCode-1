/**
 * Created by eric on 3/10/17.
 */
public class T240 {
    public static boolean searchMatrix(int[][] matrix, int target){
        int row = 0, col = matrix[0].length-1;
        while(row<=matrix.length-1 && col>=0){
            if(target==matrix[row][col]) return true;
            else if(target>matrix[row][col]) row++;
            else col--;
        }
//        if(col==0){
//            int start = row, end = matrix.length-1;
//            while(start<=end){
//                int mid = start + (end-start)/2;
//                if(matrix[mid][col]==target) return true;
//                else if(matrix[mid][col]<target) start = mid+1;
//                else end = mid-1;
//            }
//        }else{
//            int start = 0, end = col;
//            while(start<=end){
//                int mid = start + (end-start)/2;
//                if(matrix[row][mid]==target) return true;
//                else if(matrix[row][mid]<target) start = mid+1;
//                else end = mid-1;
//            }
//        }
        return false;
    }

    public static void main(String[] args) {
//        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},
//                {3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int[][] matrix = {{1,3,7,9},
                          {3,5,8,11},
                          {4,6,9,13}};
        int target = 10;
        System.out.println(searchMatrix(matrix,target));
    }
}
