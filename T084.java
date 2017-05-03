import java.util.Stack;

/**
 * Created by eric on 2/28/17.
 */
public class T084 {
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
        int[] heights = {4,2,0,3,2,5};
//        int[] heights = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));
    }
}
