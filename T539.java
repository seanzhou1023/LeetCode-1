import java.util.*;

/**
 * Created by eric on 3/18/17.
 * first bucket sort
 * be careful with the same time points in the same buckets
 * how to calculate circurly faster?
 */
public class T539 {
    public static int findMinDifference(List<String> timePoints){
        int[] bucket = new int[24*60];
        for(String tp:timePoints){
            String[] time = tp.split(":");
            int idx = Integer.valueOf(time[0])*60+Integer.valueOf(time[1]);
            bucket[idx]++;
        }
        int firstTP = 0, lastTP = 0;
        int min = 0;
        for(int i=0;i<bucket.length;i++)
            if(bucket[i]==1){
                if(min == 0) {firstTP = lastTP = i;min = bucket.length/2;continue;}
                int tmp = Math.min(i-lastTP,bucket.length-i+lastTP);
                min = min<tmp?min:tmp;
                lastTP = i;
            }else if(bucket[i]>1){
                min = 0;break;
            }
        int tmp = Math.min(lastTP-firstTP,bucket.length-lastTP+firstTP);
        min = min<tmp?min:tmp;
        return min;
    }

    public static void main(String[] args) {
        String[] tp = {"05:31","22:08","00:35"};
        List<String> timePoints = new ArrayList<>(Arrays.asList(tp));
        System.out.println(findMinDifference(timePoints));
    }
}
