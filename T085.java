import java.util.Arrays;
import java.util.Stack;

/**
 * Created by eric on 2/28/17.
 */
public class T085 {
    public static int maximalRectangle(char[][] matrix){
        if(matrix==null||matrix.length<1) return 0;
        int[] res;
        int maxArea = 0;
        if(matrix.length<matrix[0].length){
            res = new int[matrix[0].length];
            for(int i=0;i<matrix.length;i++){
                for(int j=0;j<matrix[0].length;j++){
                    if(matrix[i][j]=='0')
                        res[j] = 0;
                    else
                        res[j] += 1;
                }
                int curArea = largestRectangleArea(res);
                maxArea = maxArea>curArea?maxArea:curArea;
            }
        }else{
            res = new int[matrix.length];
            for(int i=0;i<matrix[0].length;i++){
                for(int j=0;j<matrix.length;j++){
                    if(matrix[j][i]=='0')
                        res[j] = 0;
                    else
                        res[j] += 1;
                }
                int curArea = largestRectangleArea(res);
                maxArea = maxArea>curArea?maxArea:curArea;
            }
        }
        System.out.println(Arrays.toString(res));
        return maxArea;
    }
    public static int largestRectangleArea(int[] heights){
        if(heights==null||heights.length<1) return 0;
        if(heights.length==1) return heights[0];
        Stack<Integer> stack = new Stack<>();
        int cur = 0, maxArea = 0, curArea = 0, top = 0;
        while(cur!=heights.length){
            if(stack.isEmpty()) stack.push(cur++);
            while(cur!=heights.length && heights[cur]>=heights[stack.peek()]){
                stack.push(cur++);
            }
            if(cur!=heights.length){
                while(!stack.isEmpty() && heights[cur]<heights[stack.peek()]){
                    top = stack.pop();
                    curArea = stack.isEmpty()?cur:(cur-stack.peek()-1);
                    curArea*=heights[top];
                    maxArea = maxArea>curArea?maxArea:curArea;
                }
            }
        }
        while(!stack.isEmpty()){
            top = stack.pop();
            curArea = stack.isEmpty()?cur:(cur-stack.peek()-1);
            curArea*=heights[top];
            maxArea = maxArea>curArea?maxArea:curArea;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        char[][] matrix= {{'1','0','1'},
                          {'1','0','1'},
                          {'1','1','1'},
                          {'1','0','0'}};
        System.out.println(maximalRectangle(matrix));
    }
}
