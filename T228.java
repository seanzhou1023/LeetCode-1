import java.util.ArrayList;
import java.util.List;

/**
 * Created by eric on 3/10/17.
 */
public class T228 {
    public static List<String> summaryRanges(int[] nums){
        List<String> res = new ArrayList<>();
        if(nums==null || nums.length<1) return res;
        String tmp;
        int start = nums[0], last = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]==last+1){
                last = nums[i];
            }else{
                tmp= start!=last?(start+"->"+last):(start+"");
                res.add(tmp);
                start = nums[i];
                last = nums[i];
            }
        }
        tmp= start!=last?(start+"->"+last):(start+"");
        res.add(tmp);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,4,5,7};
        System.out.println(summaryRanges(nums));
    }
}
