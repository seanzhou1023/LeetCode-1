/**
 * Created by eric on 4/16/17.
 * recursion & iterative
 * someone has a 5ms soultion? what?
 */
public class T504 {
    public static String convertToBase7(int num) {
        if(num==0) return "0";
        StringBuilder res = new StringBuilder();
        String sign = "";
        if(num<0){
            num *= -1;
            sign = "-";
        }
        while(num>0){
            int cur = num%7;
            res.append(cur);
            num /= 7;
        }
        res.append(sign);
        return res.reverse().toString();
    }
    public static String convertToBase7Re(int num){
        if(num<0) return "-" + convertToBase7Re(-num);
        if(num<7) return num + "";
        return convertToBase7Re(num/7)+num%7;
    }

    public static void main(String[] args) {
        System.out.println(convertToBase7Re(-8));
    }
}
