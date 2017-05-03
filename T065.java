import java.util.regex.Pattern;

/**
 * Created by eric on 3/13/17.
 */
public class T065 {
    public static boolean isNumber(String s){
        String str = s.trim();//remove leading & trailing zeros
        if(str.lastIndexOf(" ")>0) return false;// space in between
        if(str.length()<1) return false;//empty string
        if(str.lastIndexOf("-")==0 || str.lastIndexOf("+")==0)
            str = str.substring(1);//remove leading sign
        char[] arr = str.toCharArray();
        int dotCnt = 0, eCnt = 0, dotIdx = 0, eIdx = 0;
        boolean dot = false, e = false;
        for(int i=0;i<arr.length;i++){
            if(!Character.isDigit(arr[i])){//not a digit
                if(arr[i]=='.'){
                    dot = true;
                    dotIdx = i;
                    if(dotCnt++!=0) return false;//dot exists more than one time
                }else if(arr[i]=='e'){
                    e = true;
                    eIdx = i;
                    if(eCnt++!=0) return false;//'e' exists more than one time
                }else if(Character.isAlphabetic(arr[i]))
                    return false;// non 'e' character exists
                else return false;// other non digit characters
            }
        }
        if(eCnt+dotCnt>1) return false;// check dot & 'e' coexist
        //check dot left & right
        if(dot) return arr.length>1;
        //check 'e' left & right
        if(e) return eIdx>0 && eIdx<arr.length-1;
        return true;
    }
    public static boolean isNumberException(String s){
        s = s.trim();
        s = s.replaceAll("e|E","/");
        s = s.replaceAll("[a-zA-Z]","x");
        s = s.replaceAll("/","e");
        try{
            Double.parseDouble(s);
        }catch(Exception e){
            return false;
        }
        return true;
    }
    public static boolean isNumberSM(String s){
        // 7 states
        return false;
    }

    public static void main(String[] args) {
        String str = "eeee";
        System.out.println(isNumberException(str));
    }
}
