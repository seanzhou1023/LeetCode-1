import java.util.Iterator;

/**
 * Created by eric on 4/14/17.
 * cache!
 */
public class T284 {
    static class PeekingIterator implements Iterator<Integer> {
        Integer peek = null;
        Iterator<Integer> it;
        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            it = iterator;
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            Integer res = null;
            if(peek==null) {
                res = it.next();
                peek = res;
            }
            else res = peek;
            return res;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            Integer res = null;
            if(peek!=null) {
                res = peek;
                peek = null;
            }else res = it.next();
            return res;
        }

        @Override
        public boolean hasNext() {
            if(peek==null && !it.hasNext()) return false;
            else return true;
        }
    }
}
