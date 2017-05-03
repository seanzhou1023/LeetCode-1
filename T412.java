import java.util.*;

/**
 * Created by eric on 1/30/17.
 */
public class T412 {
    public static List<String> FizzBuzz(int n){
        List<String> ls = new ArrayList<String>();
        for(int i=1;i<n+1;i++){
            if(i%3!=0&&i%5!=0)
                ls.add(Integer.toString(i));
            else if(i%3==0&&i%5!=0)
                ls.add("Fizz");
            else if(i%3!=0&&i%5==0)
                ls.add("Buzz");
            else
                ls.add("FizzBuzz");
        }
        return ls;
    }
}
