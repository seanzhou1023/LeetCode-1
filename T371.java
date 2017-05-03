/**
 * Created by eric on 3/10/17.
 */
public class T371 {
    public static int getSum(int a, int b){
        int and = (a & b)<<1;
        int or = a ^ b;
        int tmp = or;
        while(and !=0){
            System.out.println(Integer.toBinaryString(or)+":"+Integer.toBinaryString(and));
            or = or ^ and;
            and = (tmp & and)<<1;
            tmp = or;
        }
        return or;
    }

    public static void main(String[] args) {
        System.out.println(getSum(11,22));
    }
}
