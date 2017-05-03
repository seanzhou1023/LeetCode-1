import java.util.LinkedList;
import java.util.*;

/**
 * Created by eric on 3/19/17.
 * do it in place!
 */
public class T544 {
    public static String findContestMatch(int n){
        List<String> matches = new ArrayList<>();
        for(int i=1;i<=n;i++) matches.add(i+"");
        while(matches.size()!=1){
            List<String> next = new ArrayList<>();
            for(int i=0;i<matches.size()/2;i++){
                next.add("("+matches.get(i)+","+matches.get(matches.size()-1-i)+")");
            }
            matches = next;
        }
        return matches.get(0);
    }
    public static String findContestMatchInPlace(int n){
        String[] res = new String[n];
        for(int i=0;i<res.length;i++) res[i] = (i+1)+"";
        int left = 0, right = n-1;
        while(left<right){
            while(left<right){
                res[left] = "("+res[left++]+","+res[right--]+")";
            }
            left = 0;
        }
        return res[0];
    }

    public static void main(String[] args) {
        System.out.println(findContestMatchInPlace(8));
    }
}
