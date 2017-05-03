import java.util.HashMap;
import java.util.*;

/**
 * Created by eric on 3/23/17.
 */
public class T380 {
    static class RandomizedSet {
        HashMap<Integer,Integer> position;
        List<Integer> nums;
        Random random;
        /** Initialize your data structure here. */
        public RandomizedSet() {
            position = new HashMap<>();
            nums = new ArrayList<>();
            random = new Random();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if(position.containsKey(val)) return false;
            position.put(val,nums.size());
            nums.add(val);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if(!position.containsKey(val)) return false;
            int idx = position.get(val), lastidx = nums.size()-1;
            if(idx!=lastidx){
                nums.set(idx,nums.get(lastidx));
                position.put(nums.get(lastidx),idx);
            }
            nums.remove(lastidx);
            position.remove(val);
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            return nums.get(random.nextInt(nums.size()));
        }
    }
}
