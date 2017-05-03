import java.util.*;
/**
 * Created by eric on 1/24/17.
 */
public class T118 {
    public static List<List<Integer>> generate(int numRows){
        List<List<Integer>> pt = new ArrayList<List<Integer>>();
        for(int r = 0;r<numRows;r++){
            List<Integer> newLine = new ArrayList<Integer>();
            newLine.add(1);
            if(r!=0){
                List<Integer> lastLine = pt.get(r-1);
                for(int i=0;i<lastLine.size()-1;i++){
                    newLine.add(lastLine.get(i)+lastLine.get(i+1));
                }
                newLine.add(1);
            }
            pt.add(newLine);
        }
        return pt;
    }

    public static void main(String[] args) {
        System.out.println(generate(10));
    }
}
