import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by eric on 4/23/17.
 */
public class T525 {
    public int findMaxLength(int[] nums){
        int[] cnt = new int[nums.length+1];
        for(int i=1;i<cnt.length;i++){
            cnt[i] = cnt[i-1] + (nums[i-1]==1?1:-1);
        }
        Map<Integer,Integer> hm = new HashMap<>();
        int max = 0;
        for(int i=0;i<cnt.length;i++){
            if(hm.containsKey(cnt[i]))
                max = Math.max(max, i-hm.get(cnt[i]));
            else hm.put(cnt[i],i);
        }
        return max;
    }

    public static void main(String[] args) {
        T525 t = new T525();
        System.out.println(t.findMaxLength(new int[]{0,1,1,0}));
    }
}
