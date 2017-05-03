/**
 * Created by eric on 3/17/17.
 */
public class T520 {
    public static boolean detectCapitalUse(String word){
        int state = 0;// init the state to no input form
        for(int i=word.length()-1;i>0;i--){
            if(word.charAt(i)>='a' && word.charAt(i)<='z'){
                if(state==2) return false;// 2->1 break loop of 2
                state = 1;// comes from 0 or 1
            }else if(word.charAt(i)>='A' && word.charAt(i)<='Z'){
                if(state==1) return false;// 1->2 break loop of 1
                state = 2;// comes from 0 or 2
            }else return false;// illegal characters
        }
        //check if result comes from state 2 && first character is lowercase
        //otherwise always return true
        return !(state==2 && word.charAt(0)>='a' && word.charAt(0)<='z');
    }

    public static void main(String[] args) {
        String word = "FlaG";
        System.out.println(detectCapitalUse(word));
    }
}
