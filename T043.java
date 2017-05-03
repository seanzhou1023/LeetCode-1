import java.util.Arrays;

/**
 * Created by eric on 3/14/17.
 */
public class T043 {
    public static String multiply(String num1, String num2){
        int l1 = num1.length(), l2 = num2.length();
        int[] pos = new int[l1+l2];
        for(int i=l1-1;i>=0;i--)
            for(int j=l2-1;j>=0;j--){
                int mul = (num1.charAt(i)-'0')*(num2.charAt(j)-'0')+pos[i+j+1];
                pos[i+j] += mul/10;
                pos[i+j+1] = mul%10;
            }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<pos.length;i++){
            if(!(pos[i]==0 && i==0)) sb.append(pos[i]);
        }
        return sb.length()==0?"0":sb.toString();
    }

    public static void main(String[] args) {
        String str1 = "123", str2 = "456";
        System.out.println(multiply(str1,str2));
        System.out.println(123*456);
    }
}
