package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by eric on 4/12/17.
 * https://www.careercup.com/question?id=16759664
 * key words: heap - sort k lists
 */
public class SmallestRangeKList {
    public static boolean isValid(int[] pos, int[] len){
        for(int i=0;i<pos.length;i++)
            if(pos[i]>=len[i]) return false;
        return true;
    }
    public static int[] findSmallestRangeFromKLists(List<List<Integer>> lists){
        int[] res = new int[2];
        res[0] = 0;
        res[1] = Integer.MAX_VALUE;
        int[] pos = new int[3];
        int l1 = lists.get(0).size(), l2 = lists.get(1).size(), l3 = lists.get(2).size();
        int[] len = {l1,l2,l3};
        while(isValid(pos,len)){
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            int minPos = 0;
            for(int i=0;i<3;i++) {
                int p = pos[i];
                if(lists.get(i).get(p)<min) {
                    min = lists.get(i).get(p);
                    minPos = i;
                }
                if(lists.get(i).get(p)>max) {
                    max = lists.get(i).get(p);
                }
            }
            if(max-min<res[1]-res[0]){
                res[0] = min; res[1] = max;
            }
            pos[minPos]++;
        }
        return res;
    }
    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>(Arrays.asList(4,10,15,24,26));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(0,9,12,20));
        List<Integer> l3 = new ArrayList<>(Arrays.asList(5,18,22,30));
        lists.add(l1);lists.add(l2);lists.add(l3);
        System.out.println(Arrays.toString(findSmallestRangeFromKLists(lists)));
    }
}
