import java.util.HashMap;

/**
 * Created by eric on 1/25/17.
 */
public class T246 {
    public static boolean isStrobogrammatic(String num){
        int start = 0, end = num.length()-1;
        HashMap<Character,Character> dict = new HashMap<>();
        dict.put('6','9');
        dict.put('9','6');
        dict.put('8','8');
        dict.put('1','1');
        dict.put('0','0');
        while(start<end){
            if(dict.get(num.charAt(start))==null)
                return false;
            else{
                if(dict.get(num.charAt(start))!=num.charAt(end))
                    return false;
                else{
                    start++;
                    end--;
                }
            }
        }
        if(start==end){
            if(dict.get(num.charAt(start))==null)
                return false;
            if(dict.get(num.charAt(start))!=num.charAt(start))
                return false;
        }
        return true;
    }
    public static boolean fastStrobog(String num){
//        without overhead
        if(num.length()<1){
            return false;
        }
        int start = 0, end = num.length()-1;
        while(start<=end){
            char cs = num.charAt(start), ce = num.charAt(end);
            if(cs==ce&&(cs!='0'&&cs!='1'&&cs!='8'))
                return false;
            if(cs!=ce&&!((cs=='6'&&ce=='9')||(cs=='9'&&ce=='6')))
                return false;
            start++;
            end--;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isStrobogrammatic("6969"));
    }
}
