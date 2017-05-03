import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by eric on 3/4/17.
 */
public class T243 {
    public static int sDisDummy(String[] words, String word1, String word2) {
        HashMap<String,List<Integer>> hm = new HashMap<>();
        for(int i=0;i<words.length;i++){
            if(!hm.containsKey(words[i])){
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(i);
                hm.put(words[i],arr);
            }else{
                hm.get(words[i]).add(i);
                hm.put(words[i],hm.get(words[i]));
            }
        }
        List<Integer> l1 = hm.get(word1);
        List<Integer> l2 = hm.get(word2);
        int minDis = words.length;
        for(int i=0;i<l1.size();i++)
            for(int j=0;j<l2.size();j++){
                minDis = minDis<Math.abs(l1.get(i)-l2.get(j))
                        ?minDis:Math.abs(l1.get(i)-l2.get(j));
            }
        return minDis;
    }
    public static int shortestDistance(String[] words, String word1, String word2){
        int p1 = -1, p2 = -1, minDis = words.length;
        for(int i=0;i<words.length;i++){
            if(words[i].equals(word1)){
                p1=i;
                if(p1!=-1 && p2!=-1)
                    minDis = minDis<(p1-p2)?minDis:(p1-p2);
            }
            if(words[i].equals(word2)){
                p2=i;
                if(p1!=-1 && p2!=-1)
                    minDis = minDis<(p2-p1)?minDis:(p2-p1);
            }
        }
        return minDis;
    }

    public static void main(String[] args) {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "coding";
        String word2 = "practice";
        System.out.println(shortestDistance(words,word1,word2));
    }
}
