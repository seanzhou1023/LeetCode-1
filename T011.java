/**
 * Created by eric on 2/28/17.
 */
public class T011 {
    public static int maxArea(int[] height){
        if(height.length==1) return 0;
        if(height.length==2) return Integer.min(height[0],height[1]);
        int start = 0, end = height.length-1;
        int res = 0;
        while(start<end){
            int temp = Integer.min(height[start],height[end])*(end-start);
            if(temp>res) res = temp;
            if(height[start]<height[end]) start++;
            else end--;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
