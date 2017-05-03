/**
 * Created by eric on 3/18/17.
 */
public class T402 {
    public static String removeKdigits(String num, int k){
        if(num.length()<1 || k==num.length()) return "0";
        char[] arr = num.toCharArray();
        StringBuilder res = new StringBuilder();
        res.append(arr[0]);
        for(int i=1;i<arr.length;i++){
            while(res.length()>0 && k>0 && arr[i]<res.charAt(res.length()-1)){
                res.setLength(res.length()-1);k--;
            }
            res.append(arr[i]);
        }
        while(res.length()>1 && res.charAt(0)=='0') res.deleteCharAt(0);
        res.setLength(res.length()-k);
        return res.length()==0?"0":res.toString();
    }

    public static void main(String[] args) {
        String num = "1234560";
        System.out.println(removeKdigits(num,6));
    }
}
