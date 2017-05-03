import java.util.Arrays;

/**
 * Created by eric on 3/15/17.
 */
public class T134 {
    public static int canCompleteCircuit(int[] gas, int[] cost){
        int start = gas.length-1, finish = 0;
        int sum = gas[start]-cost[start];
        while(start>finish){
            if(sum>=0){
                sum += gas[finish]-cost[finish];
                ++finish;
            }else{
                --start;
                sum += gas[start]-cost[start];
            }
        }
        return sum>=0?start:-1;
    }
    public static int canCompleteCircuit2(int[] gas, int[] cost){
        int sum = 0, res = 0, max = Integer.MAX_VALUE;
        for(int i=0;i<gas.length;i++){
            sum += gas[i]-cost[i];
            if(sum<max){
                res = i+1;
                max = sum;
            }
        }
        return sum>=0?res:-1;
    }

    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println(canCompleteCircuit(gas,cost));
    }
}
