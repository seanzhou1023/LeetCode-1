import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by eric on 5/2/17.
 */
public class T379 {
    public static class PhoneDirectory {
        Set<Integer> used;
        Queue<Integer> available;
        int max;
        /** Initialize your data structure here
         @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
        public PhoneDirectory(int maxNumbers) {
            available = new LinkedList<>();
            used = new HashSet<>();
            max = maxNumbers;
            while(maxNumbers-->=0)
                available.offer(max-maxNumbers);
        }

        /** Provide a number which is not assigned to anyone.
         @return - Return an available number. Return -1 if none is available. */
        public int get() {
            if(available.size()>0){
                int res = available.poll();
                used.add(res);
                return res;
            }
            else return -1;
        }

        /** Check if a number is available or not. */
        public boolean check(int number) {
            return number < max && !used.contains(number);
        }

        /** Recycle or release a number. */
        public void release(int number) {
            available.offer(number);
            used.remove(number);
        }
    }
}
