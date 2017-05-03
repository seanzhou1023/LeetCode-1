import java.util.Arrays;

/**
 * Created by eric on 3/29/17.
 */
public class T135 {
    public static int candy(int[] ratings){
        int[] res = new int[ratings.length];
        int sum = 0;
        Arrays.fill(res,1);
        for(int i=1;i<ratings.length;i++)
            if(ratings[i]>ratings[i-1]) res[i] = res[i-1]+1;
        for(int i=ratings.length-1;i>0;i--)
            if(ratings[i-1]>ratings[i]) res[i-1] = Math.max(res[i]+1,res[i-1]);
        for(int r:res) sum+=r;
        return sum;
    }
}
