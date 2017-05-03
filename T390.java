/**
 * Created by eric on 3/20/17.
 */
public class T390 {
    public static int lastRemaining(int n){
        int head = 1, remaining = n, step = 1;
        boolean left = true;
        while(remaining!=1){
            if(left || remaining%2==1){
                head += step;
            }
            remaining /= 2;
            step *= 2;
            left = !left;
        }
        return head;
    }
}
