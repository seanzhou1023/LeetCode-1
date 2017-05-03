import java.util.*;

/**
 * Created by eric on 3/12/17.
 */
public class T451 {
    public static String frequencySort(String s){
        char[] arr = s.toCharArray();
        int[] num = new int[256];
        for(char c:arr)
            num[(int)c]++;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(char c:arr){
            if(num[(int)c]!=0) hm.put((int)c,num[(int)c]);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer c1, Integer c2) {
                return hm.get(c2)-hm.get(c1);
            }
        });
        for(Map.Entry<Integer,Integer> e:hm.entrySet()){
            pq.add(e.getKey());
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            int cur = pq.poll();
            for(int i=0;i<hm.get(cur);i++)
                sb.append((char)(cur));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "tree";
        System.out.println(frequencySort(str));
    }
}
