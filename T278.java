/**
 * Created by eric on 3/9/17.
 */
public class T278 {
    public static boolean isBadVersion(int version){
        return false;
    }
    public static int firstBadVersion(int n){
        int start = 1, end = n;
        while(start<=end){
            int mid = start + (end-start)>>1;
            if(isBadVersion(mid)){
                if(mid==start || !isBadVersion(mid-1)) return mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return start;
    }
}
