/**
 * Created by eric on 1/30/17.
 */
public class T485 {
    public static int findMaxConsecutiveOnes(int[] nums){
        int maxL = 0;
        int tempL = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                if(tempL>maxL){
                    maxL = tempL;
                    tempL = 0;
                }
            }else
                tempL+=1;
        }
        return maxL>tempL?maxL:tempL;
    }
}
