import java.util.*;

/**
 * Created by eric on 2/27/17.
 */
public class T089 {
    public static List<String> int2bin(List<Integer> L){
        List<String> res = new ArrayList<>();
        for(Integer i: L)
            res.add(Integer.toBinaryString(i));
        return res;
    }
    public static List<Integer> grayCode(int n){
        if(n==0) return new ArrayList<Integer>(Arrays.asList(0));
        List<Integer> top = grayCode(n-1);
        List<Integer> bottom = new ArrayList<>();
        bottom.addAll(top);
        Collections.reverse(bottom);
        for(int i=0;i<bottom.size();i++)
             bottom.set(i,bottom.get(i)+(1<<(n-1)));
        top.addAll(bottom);
        return top;
    }
    public static List<Integer> fastGrayCode(int n){
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<1<<n;i++)
            res.add(i ^ i>>1);
        return res;
    }

    public static void main(String[] args) {
        long t1 = System.nanoTime();
        List<Integer> res = grayCode(10);
        long t2 = System.nanoTime();
        List<Integer> res1 = fastGrayCode(10);
        long t3 = System.nanoTime();
        System.out.println(String.valueOf(t2-t1)+" : "+String.valueOf(t3-t2));
    }
}
