/**
 * Created by eric on 4/16/17.
 */
public class T507 {
    public static boolean checkPerfectNumber(int num) {
        if(num==1) return false;
        int n = num - 1;
        for(int i=2;i*i<=num;i++){
            if(num%i==0){
                n -= i;
                if(i*i!=num) n -= num/i;
            }
            if(n<0) return false;
        }
        return n==0;
    }

    public static void main(String[] args) {
        System.out.println(checkPerfectNumber(28));
    }
}
