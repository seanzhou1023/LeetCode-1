/**
 * Created by eric on 3/21/17.
 */
public class T274 {
    public static int hIndex(int[] citations){
        int max = citations.length;
        int[] count = new int[max+1];
        for(int h:citations){
            if(h<=max) count[h]++;
            else count[max]++;
        }
        int cnt = 0;
        for(int i=max;i>0;i--){
            cnt+=count[i];
            if(cnt>=i) return cnt;
        }
        return 0;
    }
}
