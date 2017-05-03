import java.util.*;

/**
 * Created by eric on 4/12/17.
 * using only the iterator built-in
 * throw exception
 */
public class T251 {
    static class Vector2D implements Iterator<Integer> {
        static int x, y;
        List<List<Integer>> vector;
        public Vector2D(List<List<Integer>> vec2d) {
            vector = vec2d;
            x = 0; y = 0;
        }

        @Override
        public Integer next() {
            return vector.get(x).get(y++);
        }

        @Override
        public boolean hasNext() {
            while(x<vector.size() && y>=vector.get(x).size()){
                x++; y = 0;
            }
            return x<vector.size();
        }
    }
    static class Vector2DIt implements Iterator<Integer> {
        ListIterator<List<Integer>> x;
        ListIterator<Integer> y;
        public Vector2DIt(List<List<Integer>> vec2d) {
            x = vec2d.listIterator();
        }

        public Integer next() {
            hasNext();
            return y.next();
        }

        public Integer previous() {
            hasPrevious();
            return y.previous();
        }

        public boolean hasNext() {
            while((y==null || !y.hasNext()) && x.hasNext()){
                y = x.next().listIterator();
            }
            return y!=null && y.hasNext();
        }

        public boolean hasPrevious(){
            while((y==null || !y.hasPrevious()) && x.hasPrevious()){
                y = x.previous().listIterator();
            }
            return y!=null && y.hasPrevious();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>(Arrays.asList());
        List<Integer> l2 = new ArrayList<>(Arrays.asList(3));
        List<Integer> l3 = new ArrayList<>(Arrays.asList(4,5,6));
        res.add(l1);
        res.add(l2);
        res.add(l3);
        Vector2DIt vector = new Vector2DIt(res);
        System.out.println(vector.next());
        System.out.println(vector.next());
        System.out.println(vector.previous());
    }
}
