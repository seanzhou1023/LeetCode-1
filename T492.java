/**
 * Created by eric on 4/16/17.
 */
public class T492 {
    public static int[] constructRectangle(int area){
        int[] res = new int[2];
        int diff = Integer.MAX_VALUE;
        for(int i=1;i*i<=area;i++){
            if(area%i!=0) continue;
            int curDiff = area/i - i;
            if(curDiff<diff){
                res[0] = area/i;
                res[1] = i;
            }
        }
        return res;
    }
}
