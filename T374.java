/**
 * Created by eric on 2/15/17.
 * be careful with the "My", game master in the first person
 */
public class T374 {
    public static int guess(int num){
        return num;
    }
    public static int guessNumber(int n){
        int l = 1, h = n;
        return guessNumber(l,h);
    }
    public static int guessNumber(int l,int h){
        int mid = l + (h-l)/2;
        if(guess(mid)==1)
            return guessNumber(mid,h);
        else if(guess(mid)==-1)
            return guessNumber(l,mid);
        else
            return mid;
    }
}
