package language;

import java.util.*;

/**
 * Created by eric on 3/24/17.
 */
public class Collect {
    public static int forLoopTest(int size, List<Integer> link){
        int res = 0;
        for(int i=0;i<link.size();i++)
            res = link.get(i);
        return res;
    }
    public static int forEachTest(int size, List<Integer> link){
        int res = 0;
        for(int i:link)
            res = i;
        return res;
    }
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        List<Integer> link = new LinkedList<>();
        int size = 100000;
        Random random = new Random();
        for(int i=0;i<size;i++){
            arr.add(random.nextInt(size));
            link.add(random.nextInt(size));
        }
        long t0 = System.nanoTime();
        forEachTest(size,link);
        long t1 = System.nanoTime();
        forLoopTest(size,link);
        long t2 = System.nanoTime();
        System.out.println((t1-t0)/1e6+":"+(t2-t1)/1e6);
    }
}
