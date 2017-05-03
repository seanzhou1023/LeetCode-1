/**
 * Created by eric on 3/9/17.
 */
public class T408 {
    public static boolean validWordAbbreviation(String word, String abbr){
        int s1 = 0, s2 = 0;
        while(s2<abbr.length()){
            int margin = 0;
            while(s2<abbr.length() && Character.isDigit(abbr.charAt(s2))){
                char cur = abbr.charAt(s2++);
                if(margin==0 && cur=='0') return false;
                margin = margin*10 + cur - '0';
            }
            s1+=margin;
            if(s2==abbr.length()) return s1==word.length();
            if(s1>=word.length() || word.charAt(s1++)!=abbr.charAt(s2++)) return false;
        }
        return s1==word.length();
    }

    public static void main(String[] args) {
        String s = "a", abbr = "01";
        System.out.println(validWordAbbreviation(s,abbr));
    }
}
