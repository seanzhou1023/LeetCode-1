/**
 * Created by eric on 3/14/17.
 */
public class T415 {
    public static String addStrings(String num1, String num2){
        char[] arr1 = num1.toCharArray();
        char[] arr2 = num2.toCharArray();
        int s1 = arr1.length-1, s2 = arr2.length-1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(s1>=0 || s2>=0){
            int n1 = s1>=0?arr1[s1--]:(0+'0');
            int n2 = s2>=0?arr2[s2--]:(0+'0');
            int tmp = n1-'0'+n2-'0'+carry;
            carry = tmp/10;
            int cur = tmp%10;
            sb.insert(0,(char)(cur+'0'));
        }
        if(carry!=0) sb.insert(0,(char)(carry+'0'));
        return sb.toString();
    }

    public static void main(String[] args) {
        String num1 = "9133", num2 = "235";
        System.out.println(addStrings(num1,num2));
    }
}
