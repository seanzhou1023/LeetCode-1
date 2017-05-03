import com.sun.deploy.util.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

/**
 * Created by eric on 4/29/17.
 */
public class T464{
    public boolean canIWin(int max, int total){
        if(total<=0) return true;
        if(max/2*(1+max)<total) return false;
        return canIWin(total,0,max, new Boolean[1<<max]);
    }
    public boolean canIWin(int total, int state, int max, Boolean[] table){
        if(table[state]!=null) return table[state];
        for(int i=1;i<=max;i++){
            int bit = 1 << (i-1);
            if((state & bit)==0){
                state |= bit;
                if(total<=i || !canIWin(total-i,state,max,table)){
                    table[state] = true;
                    state &= ~bit;
                    return true;
                }
                state &= ~bit;
            }
        }
        table[state] = false;
        return false;
    }
    public static void main(String[] args) {
        T464 t = new T464();
        char[] states = {0,1,0,1,1};
        System.out.println(Arrays.toString(states).substring(1));
        System.out.println(Integer.toBinaryString(25));
        int set = 25 ^ (1<<2);
        int set0 = set ^ (1<<2);
        System.out.println(Integer.toBinaryString(set));
        System.out.println(Integer.toBinaryString(set0));
    }
}
