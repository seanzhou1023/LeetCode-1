import java.util.*;

/**
 * Created by eric on 4/15/17.
 * extending from T295, slow!
 * use treemap next time
 * https://discuss.leetcode.com/topic/74874/easy-to-understand-o-nlogk-java-solution-using-treemap
 */
public class T480 {
    static class MedianFinder {
        PriorityQueue<Long> lo, hi;
        int lsize, hsize;
        /** initialize your data structure here. */
        public MedianFinder() {
            lo = new PriorityQueue<>(Comparator.reverseOrder());
            hi = new PriorityQueue<>();
            lsize = hsize = 0;
        }
        public void addNum(long num) {
            if(hi.contains(num)){
                hi.remove(num);
                hsize--;
            }
            else{
                lo.remove(num);
                lsize--;
            }
            if(hsize>lsize){
                long pop = hi.poll();
                lo.offer(pop);
                hsize--;
                lsize++;
            }
        }
        public void removeNum(long num){
            if(hi.contains(num)) hi.remove(num);
            else lo.remove(num);
        }
        public double findMedian() {
            if(lsize>hsize) return lo.peek();
            else return (lo.peek()+hi.peek())*0.5;
        }
    }
    public static double[] medianSlidingWindow(int[] nums, int k){
        double[] res = new double[nums.length-k+1];
        MedianFinder mf = new MedianFinder();
        for(int i=0;i<=nums.length-k;i++){
            if(i==0){
                for(int j=i;j<i+k;j++)
                    mf.addNum(nums[j]);
            }else{
                mf.removeNum(i-1);
                mf.addNum(i+k-1);
            }
            res[i] = mf.findMedian();
        }
        return res;
    }
    public static void add(List<Integer> sorted, int num){
        int idx = Collections.binarySearch(sorted,num);
        idx = idx>=0?idx:-(idx+1);
        sorted.add(idx,num);
    }
    public static void remove(List<Integer> sorted, int num){
        int idx = Collections.binarySearch(sorted,num);
        sorted.remove(idx);
    }
    public static double[] medianSlidingWindowNoHeap(int[] nums, int k){
        double[] res = new double[nums.length-k+1];
        List<Integer> sorted = new LinkedList<>();
        for(int i=0;i<=nums.length-k;i++){
            if(i==0){
                for(int j=0;j<k;j++) add(sorted,nums[j]);
            }else{
                remove(sorted,nums[i-1]);
                add(sorted,nums[i+k-1]);
            }
            if(k%2==0) res[i] = ((double)sorted.get(k/2)+(double)sorted.get(k/2-1))*0.5;
            else res[i] = sorted.get(k/2);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2147483647,2147483647};
        int k = 2;
        System.out.println(Arrays.toString(medianSlidingWindowNoHeap(nums,k)));
    }
}
