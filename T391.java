import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * Created by eric on 4/2/17.
 * sweep line algorithm - comes from n line segments intersect
 * http://www.geeksforgeeks.org/check-if-two-given-line-segments-intersect/
 * http://www.geeksforgeeks.org/given-a-set-of-line-segments-find-if-any-two-segments-intersect/
 * http://jeffe.cs.illinois.edu/teaching/373/notes/x06-sweepline.pdf
 */
public class T391 {
    static class Points implements Comparable<Points>{
        int x;
        int[] rect;
        Points(int x, int[] rect){
            this.x = x;
            this.rect = rect;
        }
        public int compareTo(Points that){
            if(this.x != that.x) return this.x-that.x;
            else return this.rect[0]-that.rect[0];
        }
    }
    static class Border{
        int low, high;
        Border(int low, int high){
            this.low = low;
            this.high = high;
        }
    }
    public static boolean isRectangleCover(int[][] rectangles){
        PriorityQueue<Points> pq = new PriorityQueue<>();
        Border border = new Border(Integer.MAX_VALUE,Integer.MIN_VALUE);
        for(int[] points:rectangles){
            pq.add(new Points(points[0],points));
            pq.add(new Points(points[2],points));
            if(points[1]<border.low) border.low = points[1];
            if(points[3]>border.high) border.high = points[3];
        }
        TreeSet<int[]> tSet = new TreeSet<>(new Comparator<int[]>() {
            public int compare(int[] rect1, int[] rect2) {
                if(rect1[3]<=rect2[1]) return -1;
                else if(rect2[3]<=rect1[1]) return 1;
                else return 0;
            }
        });
        int yRange = 0;
        while(!pq.isEmpty()){
            int x = pq.peek().x;
            while(!pq.isEmpty() && pq.peek().x == x){
                Points cur = pq.poll();
                int[] rect = cur.rect;
                if(x==rect[2]){
                    tSet.remove(rect);
                    yRange -= rect[3]-rect[1];
                }else{
                    if(!tSet.add(rect)) return false;
                    yRange += rect[3]-rect[1];
                }
            }
            if(!pq.isEmpty() && border.high-border.low!=yRange) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] rectangles = {{1,1,3,3},{3,1,4,2},{3,2,4,4},{1,3,2,4},{2,3,3,4}};
        System.out.println(isRectangleCover(rectangles));
    }
}
