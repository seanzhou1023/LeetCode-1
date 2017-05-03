import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by eric on 4/15/17.
 */
public class T295 {
    static class MedianFinder {
        PriorityQueue<Integer> lo, hi;
        int lsize, hsize;
        /** initialize your data structure here. */
        public MedianFinder() {
            lo = new PriorityQueue<>(Comparator.reverseOrder());
            hi = new PriorityQueue<>();
            lsize = hsize = 0;
        }

        public void addNum(int num) {
            lo.offer(num);
            int cur = lo.poll();
            hi.offer(cur);
            hsize++;
            if(hsize>lo.size()){
                int pop = hi.poll();
                lo.offer(pop);
                hsize--;
                lsize++;
            }
            System.out.println(lo);
            System.out.println(hi);
        }

        public double findMedian() {
            if(lsize>hsize) return lo.peek();
            else return (lo.peek()+hi.peek())*0.5;
        }
    }

    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        mf.addNum(2);
        System.out.println(mf.findMedian());
        mf.addNum(3);
        System.out.println(mf.findMedian());
    }
}
