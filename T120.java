import java.util.*;

/**
 * Created by eric on 3/14/17.
 */
public class T120 {
    public static int minimumTotal(List<List<Integer>> triangle){
        if(triangle==null || triangle.size()<1) return 0;
        int min = Integer.MAX_VALUE, len = triangle.size();
        if(triangle.size()==1) return triangle.get(0).get(0);
        for(int i=1;i<len;i++){
            List<Integer> last = triangle.get(i-1);
            List<Integer> cur = triangle.get(i);
            for(int j=0;j<cur.size();j++){
                if(j==0) cur.set(j,last.get(j)+cur.get(j));
                else if(j==cur.size()-1) cur.set(j,last.get(j-1)+cur.get(j));
                else cur.set(j,Math.min(last.get(j-1),last.get(j))+cur.get(j));
                if(i==len-1) min = min<cur.get(j)?min:cur.get(j);
            }
        }
        return min;
    }

    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>();
        l1.add(2);
        List<Integer> l2 = new ArrayList<>();
        l2.add(3);l2.add(4);
//        List<Integer> l3 = new ArrayList<>();
//        l3.add(5);l3.add(6);l3.add(7);
//        List<Integer> l4 = new ArrayList<>();
//        l4.add(4);l4.add(1);l4.add(8);l4.add(3);
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(l1);triangle.add(l2);
//        triangle.add(l3);triangle.add(l4);
        System.out.println(minimumTotal(triangle));
    }
}
