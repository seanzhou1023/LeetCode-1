import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by eric on 4/11/17.
 * needs optimization: next time try different methods
 * https://discuss.leetcode.com/category/435/android-unlock-patterns
 */
public class T351 {
    public static boolean isValid(boolean[] used, int last, int cur){
        if(used[cur]) return false;
        if(last==-1) return true;
        if((last+cur)%2==1) return true;
        int mid = (last+cur)/2;
        if(mid==4) return used[mid];
        if((last%3 != cur%3) && (last/3 != cur/3)) return true;
        return used[mid];
    }
    public static int recursive(boolean[] used, int last, int k){
        if(k==0) return 1;
        int sum = 0;
        for(int i=0;i<=8;i++){
            if(isValid(used,last,i)){
                used[i] = true;
                sum += recursive(used,i,k-1);
                used[i] = false;
            }
        }
        return sum;
    }
    public static int numberOfPatterns(int m, int n){
        if(m>n) return 0;
        int res = 0;
        for(int i=m;i<=n;i++){
            boolean[] used = new boolean[9];
            res += recursive(used,-1,i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(numberOfPatterns(1,2));
    }
}
