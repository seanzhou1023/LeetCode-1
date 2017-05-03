/**
 * Created by eric on 3/16/17.
 */
public class T495 {
    public static int findPoisonedDuration(int[] timeSeries, int duration){
        int res = duration;
        for(int i=1;i<timeSeries.length;i++){
            if(timeSeries[i]-timeSeries[i-1]<duration) res -= duration + timeSeries[i]-timeSeries[i-1];
            else res += duration;
        }
        return res;

    }
}
