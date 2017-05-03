/**
 * Created by eric on 4/14/17.
 */
public class T477 {
    public static int totalHammingDistance(int[] nums){
        int mask = 1, res = 0;
        for(int i=0;i<32;i++){
            int cnt = 0;
            for(int num: nums){
                cnt += ((mask & num) >> i);
            }
            res += cnt * (nums.length-cnt);
            mask <<= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4,14,2};
        System.out.println(totalHammingDistance(nums));
        System.out.println(Integer.toBinaryString(1<<31));
    }
}
