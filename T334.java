/**
 * Created by eric on 3/26/17.
 */
public class T334 {
    public static boolean increasingTriplet(int[] nums){
        int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        for(int num:nums){
            if(num<=min) min = num;
            else if(num<secondMin) secondMin = num;
            else if(num>secondMin) return true;
        }
        return false;
    }
}
