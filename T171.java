/**
 * Created by eric on 1/30/17.
 */
public class T171 {
    public static int titleToNumber(String s){
        int res = 0;
        int mul = 1;
        for(int i = s.length()-1;i>=0;i--){
            res+=(s.charAt(i)-'A'+1)*mul;
            mul*=26;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "AZ";
        System.out.println(titleToNumber(s));
    }
}
