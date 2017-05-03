import java.util.*;

/**
 * Created by eric on 3/9/17.
 */
public class T056 {
    public static class Interval{
        int start;
        int end;
        Interval(){start=0;end=0;}
        Interval(int s, int e){start=s;end=e;}
    }
    public static List<Interval> merge(List<Interval> intervals){
        if(intervals.size()<2) return intervals;
        Comparator<Interval> comp = new Comparator<Interval>() {
            @Override
            public int compare(Interval int1, Interval int2) {
                return int1.start-int2.start;
            }
        };
        Collections.sort(intervals,comp);
        List<Interval> res = new ArrayList<>();
        int begin = intervals.get(0).start, lastEnd = intervals.get(0).end;
        for(int i=1;i<intervals.size();i++){
            int curStart = intervals.get(i).start;
            int curEnd = intervals.get(i).end;
            if(lastEnd<curStart){
                Interval temp = new Interval(begin,lastEnd);
                res.add(temp);
                begin = curStart;
            }
            lastEnd = lastEnd>curEnd?lastEnd:curEnd;
            if(i==intervals.size()-1){
                Interval temp = new Interval(begin,lastEnd);
                res.add(temp);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Interval int1 = new Interval(1,4);
        Interval int2 = new Interval(5,6);
        Interval int3 = new Interval(1,6);
//        Interval int4 = new Interval(15,18);
        List<Interval> list = new ArrayList<>();
//        list.add(int3);
//        list.add(int4);
        list.add(int1);list.add(int2);
        list = merge(list);
        for(Interval i:list)
            System.out.println(i.start+":"+i.end);
    }
}
