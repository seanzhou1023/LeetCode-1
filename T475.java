import java.util.Arrays;

/**
 * Created by eric on 3/11/17.
 */
public class T475 {
    public static int findRadius(int[] houses, int[] heaters){
        Arrays.sort(heaters);
        int res = 0;
        for(int house:houses){
            int idx = Arrays.binarySearch(heaters,house);
            if(idx<0){
                idx = ~idx;
                int left = idx>=1?(house-heaters[idx-1]):Integer.MAX_VALUE;
                int right = idx<heaters.length?(heaters[idx]-house):Integer.MAX_VALUE;
                res = Math.max(res,Math.min(left,right));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int[] heaters = {2};
        System.out.println(findRadius(nums,heaters));
    }
}
