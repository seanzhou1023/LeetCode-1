package sedgewick;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Created by eric on 4/26/17.
 */
public class Test {
    public static void main(String[] args) {
        PriorityQueue<StringBuilder> pq = new PriorityQueue<>();
        HashMap<StringBuilder, Integer> hm = new HashMap<>();
        pq.add(new StringBuilder());
        pq.peek().append("0");
        System.out.println(pq.poll().toString());
    }
}
