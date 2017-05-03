import java.util.Arrays;

/**
 * Created by eric on 2/22/17.
 */
public class T042 {
    public static int trap(int[] height){
        int len = height.length;
        int[] maxLeft = new int[len];
        int res = 0;
        int maxL = 0, maxR = 0;
        for(int i=0;i<len;i++){
            if(maxL<height[i])
                maxL = height[i];
            maxLeft[i] = maxL;
        }
        for(int i=len-1;i>=0;i--){
            maxR = maxR>height[i]?maxR:height[i];
            res += Integer.max(Integer.min(maxLeft[i],maxR)-height[i],0);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
}
