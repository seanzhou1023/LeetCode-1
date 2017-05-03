import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Created by eric on 4/11/17.
 * java.lang.IllegalArgumentException: Comparison method violates its general contract!
 * For objects that implement Comparable, there should always be a consistency
 * between the methods equals(), hashcode() and compareTo().
 *
 * method 1: simple sort + longest increasing subsequence - (n^2)
 * method 2: radix sort + binary search + modified LIS - (nlogn) - beats 100%
 */
public class T354 {
    static class Envelope{
        int w, h;
        Envelope(int width, int height){
            w = width; h = height;
        }
        public String toString(){
            return "["+this.w+","+this.h+"]";
        }
    }
    public static void radixSort(Envelope[] E){
        int minW = Integer.MAX_VALUE, maxW = Integer.MIN_VALUE;
        int minH = Integer.MAX_VALUE, maxH = Integer.MIN_VALUE;
        for(Envelope e: E){
            minW = minW<e.w?minW:e.w; maxW = maxW>e.w?maxW:e.w;
            minH = minH<e.h?minH:e.h; maxH = maxH>e.h?maxH:e.h;
        }
        for(int pos=1;pos>=0;pos--){
            int len = (pos==1?maxH-minH:maxW-minW)+1;
            int[] count = new int[len+1];
            for(Envelope e: E)
                count[(pos==1?e.h-minH:e.w-minW)+1]++;
            for(int i=0;i<count.length-1;i++)
                count[i+1] += count[i];
            Envelope[] aux = new Envelope[E.length];
            for(Envelope e: E)
                aux[count[pos==1?e.h-minH:e.w-minW]++] = e;
            if(pos==1){
                for(int i=0;i<E.length;i++)
                    E[i] = aux[E.length-1-i];
            }else{
                for(int i=0;i<E.length;i++)
                    E[i] = aux[i];
            }
        }
    }
    public static int maxEnvelopes(int[][] envelopes){
        Envelope[] E = new Envelope[envelopes.length];
        for(int i=0;i<E.length;i++)
            E[i] = new Envelope(envelopes[i][0],envelopes[i][1]);
        radixSort(E);
        System.out.println(Arrays.toString(E));
        int len = 0;
        int[] dp = new int[E.length];
        for(Envelope e: E){
            int idx = Arrays.binarySearch(dp,0,len,e.h);
            if(idx<0) idx = -(idx+1);
            dp[idx] = e.h;
            if(idx==len) len++;
        }
        return len;
    }

    public static void main(String[] args) {
        int[][] envelopes = {{1,3},{3,5},{6,7},{6,8},{8,4},{9,5}};
//        int[][] envelopes = {{4,5},{6,7},{2,3}};
        System.out.println(maxEnvelopes(envelopes));
    }
}
