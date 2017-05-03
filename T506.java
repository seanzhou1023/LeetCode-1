import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by eric on 4/16/17.
 */
public class T506 {
    public static String[] findRelativeRanks(int[] nums){
        Integer[] index = new Integer[nums.length];
        for(int i=0;i<nums.length;i++) index[i] = i;
        Arrays.sort(index, new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                return nums[i2]-nums[i1];
            }
        });
        String[] res = new String[nums.length];
        for(int i=0;i<index.length;i++){
            switch(i){
                case 0: res[index[i]] = "Gold Medal";break;
                case 1: res[index[i]] = "Silver Medal";break;
                case 2: res[index[i]] = "Bronze Medal";break;
                default: res[index[i]] = (i+1)+"";
            }
        }
        return res;
    }
}
