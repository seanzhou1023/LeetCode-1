import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by eric on 4/9/17.
 */
public class T554 {
    public static int leastBricks(List<List<Integer>> wall){
        if(wall.size()<1) return 0;
        Map<Integer,Integer> hm = new HashMap<>();
        int max = 0, length = 0;
        for(List<Integer> list: wall){
            for(int i=0;i<list.size()-1;i++){
                list.set(i,list.get(i) + (i>0?list.get(i-1):0));
                int cur = list.get(i);
                hm.put(cur,hm.getOrDefault(cur,0)+1);//make this as the default pattern
                max = Math.max(max,hm.get(cur));
            }
        }
        return wall.size()-max;
    }
}
