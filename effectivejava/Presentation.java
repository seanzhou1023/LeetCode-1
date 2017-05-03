package effectivejava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by eric on 4/26/17.
 * by the father of effective java
 */
public class Presentation {
    static Comparator<Integer> cmp = new Comparator<Integer>() {
        public int compare(Integer i, Integer j) {
            return i<j?-1:(i>j?1:0);
        }
    };
    public static void main(String[] args) {
        String[] strs = {"0","1000","2000","3000","4000","5000"};
        List<Integer> integers = new ArrayList<>();
        for(String str: strs)
            integers.add(Integer.valueOf(str));
        System.out.println(Collections.binarySearch(integers, 1000, cmp));
    }
}
