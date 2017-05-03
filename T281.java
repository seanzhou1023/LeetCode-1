import java.util.List;

/**
 * Created by eric on 4/14/17.
 */
public class T281 {
    public class ZigzagIterator {
        List<Integer> v1, v2;
        boolean isFirst;
        int idx1, idx2;
        public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
            this.v1 = v1;
            this.v2 = v2;
            isFirst = true;
            idx1 = idx2 = 0;
        }

        public int next() {
            if(isFirst){
                isFirst ^= true;
                if(idx1<v1.size()) return v1.get(idx1++);
                else return v2.get(idx2++);
            }else{
                isFirst ^= true;
                if(idx2<v2.size()) return v2.get(idx2++);
                else return v1.get(idx1++);
            }
        }

        public boolean hasNext() {
            if(isFirst) return idx1<v1.size() || (idx1>=v1.size() && idx2<v2.size());
            else return idx2<v2.size() || (idx2>=v2.size() && idx1<v1.size());
        }
    }
}
