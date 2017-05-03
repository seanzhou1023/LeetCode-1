/**
 * Created by eric on 3/16/17.
 */
public class T277 {
    public static boolean knows(int a, int b){
        return false;
    }
    public static int findCelebrity(int n) {
        int start = 0, end = n-1;
        while(start<end){//actually only one loop will do the work
            if((knows(start,end) && knows(end,start)) ||
                    (!knows(start,end) && !knows(end,start))){
                start++; end--;
            }else if(knows(start,end)) start++;
            else end--;
        }
        if(end<start) return -1;
        else{
            int cnt = 0;
            for(int i=0;i<n;i++)
                if(i!=start && knows(i,start) && !knows(start,i)) cnt++;
            return cnt==n-1?start:-1;
        }
    }
}
