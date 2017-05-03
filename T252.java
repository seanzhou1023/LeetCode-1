import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by eric on 4/2/17.
 */
public class T252 {
    public static class Interval{
        int start;
        int end;
        Interval(){start=0;end=0;}
        Interval(int s, int e){start=s;end=e;}
    }
    public boolean canAttendMeetings(Interval[] intervals){
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                if(i1.start!=i2.start) return i1.start-i2.start;
                else if(i1.end!=i2.end) return i1.end-i2.end;
                else return 0;
            }
        });
        for(int i=1;i<intervals.length;i++)
            if(intervals[i].start<intervals[i-1].end) return false;
        return true;
    }
}
