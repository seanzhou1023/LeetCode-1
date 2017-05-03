import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by eric on 4/2/17.
 * greedy next time
 */
public class T253 {
    public static class Interval{
        int start;
        int end;
        Interval(){start=0;end=0;}
        Interval(int s, int e){start=s;end=e;}
    }
    public int minMeetingRooms(Interval[] intervals){
        if(intervals==null || intervals.length<1) return 0;
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start-i2.start;
            }
        });
        PriorityQueue<Interval> pq = new PriorityQueue<>(intervals.length, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.end-i2.end;
            }
        });
        pq.offer(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            Interval cur = pq.poll();
            if(intervals[i].start>=cur.end){
                cur.end = intervals[i].end;
            }else{
                pq.offer(intervals[i]);
            }
            pq.offer(cur);
        }
        return pq.size();
    }
    public int minMeetingRoomsF(Interval[] intervals){
        if(intervals==null || intervals.length<1) return 0;
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for(int i=0;i<intervals.length;i++){
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int rooms = 0, pre = 0;
        for(int i=0;i<intervals.length;i++){
            rooms++;
            if(start[i]>=end[pre]){
                rooms--;
                pre++;
            }
        }
        return rooms;
    }
}
