/**
 * Created by eric on 3/11/17.
 */
public class T167 {
    public static int[] twoSum(int[] numbers, int target){
        int left = 0, right = numbers.length-1;
        int[] res = new int[2];
        while(left<=right){
            int cur = numbers[left]+numbers[right];
            if(cur==target){
                res[0] = left+1;
                res[1] = right+1;
                break;
            }else if(cur>target){
                right--;
            }else left++;
        }
        return res;
    }

}
