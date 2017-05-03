import java.util.*;

/**
 * Created by eric on 3/11/17.
 */
public class T347 {
    public static List<Integer> topKFrequent(int[] nums, int k){
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int num:nums){
            if(hm.containsKey(num)) hm.put(num,hm.get(num)+1);
            else hm.put(num,1);
        }
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder(new Comparator<Integer>() {
            @Override
            public int compare(Integer int1, Integer int2) {
                return hm.get(int1)-hm.get(int2);
            }
        }));
        for(Map.Entry<Integer,Integer> e:hm.entrySet())
            pq.add(e.getKey());
        for(int i=0;i<k;i++)
            res.add(pq.poll());
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        System.out.println(topKFrequent(nums,k));
    }
}
