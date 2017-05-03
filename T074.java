/**
 * Created by eric on 3/10/17.
 */
public class T074 {
    public static boolean searchMatrix(int[][] matrix, int target){
        if(matrix.length<1) return false;
        if(matrix[0].length<1) return false;
        int start = 0, end = matrix.length-1;
        int rowFound = 0;
        while(start<=end){
            int mid = start + (end-start)/2;
            System.out.println(mid+":"+start+":"+end);
            if(matrix[mid][0]==target) return true;
            else if(matrix[mid][0]<target){
                if(mid==end){
                    rowFound = end;break;
                }else{
                    if(target<matrix[mid+1][0]){
                        rowFound = mid;break;
                    }
                    start = mid+1;
                }
            }else{
                if(mid==start){
                    return false;
                }else{
                    if(target>matrix[mid-1][0]){
                        rowFound = mid-1;break;
                    }
                    end = mid-1;
                }
            }
        }
        int s = 0, e = matrix[0].length-1;
        if(target<matrix[rowFound][s] || target>matrix[rowFound][e]) return false;
        while(s<e){
            int mid = s + (e-s)/2;
            if(matrix[rowFound][mid]==target) return true;
            else if(matrix[rowFound][mid]>target){
                if(mid==start) return false;
                else e = mid-1;
            }else{
                if(mid==e) return false;
                else s = mid+1;
            }
        }
        return matrix[rowFound][s]==target;
    }
    public static boolean searchMatrixFaster(int[][] matrix, int target){
        if(matrix==null || matrix.length<1) return false;
        if(matrix[0].length<1) return false;
        int start = 0, rows = matrix.length, cols = matrix[0].length;
        int end = rows*cols-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(matrix[mid/cols][mid%cols]==target) return true;
            else if(matrix[mid/cols][mid%cols]>target){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        int tgt = 3;
        int[][] matrix = {{1},{3}};
        System.out.println(searchMatrixFaster(matrix, tgt));
    }
}
