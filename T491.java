import java.util.HashSet;
import java.util.Set;

/**
 * Created by eric on 4/2/17.
 */
public class T491 {
    public static int curMax(Set<Integer> chosen, int maxNumber){
        for(int i=maxNumber;i>0;i--)
            if(chosen.contains(i)) return i;
        return 0;
    }
    public static boolean canIWin(Set<Integer> chosen, int total, int maxNumber){
        if(curMax(chosen,maxNumber)>=total) return true;
        for(int i=1;i<=maxNumber;i++){
            chosen.add(i);
            if(canIWin(chosen,total-i,maxNumber)) return true;
            else chosen.remove(i);
        }
        return false;
    }
    public static boolean canIWin(int maxChoosableInteger, int desiredTotal){
        Set<Integer> chosen = new HashSet<>();
        return canIWin(chosen,desiredTotal,maxChoosableInteger);
    }

    public static void main(String[] args) {
        int maxChoosableInteger = 10, desiredTotal = 11;
        System.out.println(canIWin(maxChoosableInteger,desiredTotal));
    }
}
