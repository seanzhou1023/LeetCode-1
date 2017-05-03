import java.util.*;

/**
 * Created by eric on 3/29/17.
 * normal loop(edge cases) slow
 * using binary search once and for all
 */
public class T057 {
    static class Interval{
        int start, end;
        Interval(){start=0;end=0;};
        Interval(int s, int e){start=s;end=e;}
    }
    public static boolean isOverlap(Interval I1, Interval I2){
        if(I1.end<I2.start || I2.end<I1.start) return false;
        else return true;
    }
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval){
        int insertPoint = intervals.size();
        for(int i=0;i<intervals.size();i++){
            Interval cur = intervals.get(i);
            if(isOverlap(cur,newInterval)){
                intervals.remove(i);
                newInterval = new Interval(Math.min(cur.start,newInterval.start),
                        Math.max(cur.end,newInterval.end));
                insertPoint = i;
                i--;
            }else if(newInterval.end<cur.start){
                intervals.add(insertPoint,newInterval);
                break;
            }
        }
        intervals.add(insertPoint,newInterval);
        return intervals;
    }
    public static List<Interval> insertBS(List<Interval> intervals, Interval newInterval){
        //search interval start point startPosition
        //search interval end point startPosition
        //two situations: in/out of the intervals
        int s = 0, e = intervals.size()-1;
        Integer startPos = null;
        while(s<e){
            int m = s + (e-s)/2;
            Interval cur = intervals.get(m);
            if(newInterval.start==cur.start){
                startPos = m;
                break;
            }else if(newInterval.start<cur.start){
                if(m==0 || newInterval.start>intervals.get(m-1).start){
                    startPos = m;
                    break;
                }
                else e = m;
            }else{
                if(m==intervals.size()-1 || newInterval.start<intervals.get(m+1).start){
                    startPos = m+1;
                    break;
                }
                else s = m;
            }
        }
        startPos = startPos!=null?startPos:s;
        s = 0;e = intervals.size()-1;
        Integer endPos = null;
        while(s<e){
            int m = s + (e-s)/2;
            Interval cur = intervals.get(m);
            if(newInterval.end==cur.end){
                endPos = m;
                break;
            }else if(newInterval.end<cur.end){
                if(m==0 || newInterval.end>intervals.get(m-1).end){
                    endPos = m;
                    break;
                }
                else e = m;
            }else{
                if(m==intervals.size()-1 || newInterval.end<intervals.get(m+1).end){
                    endPos = m+1;
                    break;
                }
                else s = m;
            }
        }
        endPos = endPos!=null?endPos:s;
        System.out.println(startPos+":"+endPos);
        return null;
    }

    public static void main(String[] args) {
        List<Interval> res = new ArrayList<>();
//        res.add(new Interval(1,2));res.add(new Interval(3,5));
//        res.add(new Interval(6,7));res.add(new Interval(8,10));
//        res.add(new Interval(12,16));
        Interval newInterval = new Interval(4,9);
        insertBS(res,newInterval);
    }
}
