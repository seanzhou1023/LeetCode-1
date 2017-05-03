import java.util.*;

/**
 * Created by eric on 4/8/17.
 * couldn't handle the case: {"wrtkj","wrt"} - invalid
 */
public class T269 {
    static class CharNode{
        char val;
        Set<CharNode> out, in;
        CharNode(char val){
            this.val = val;
            out = new HashSet<>();
            in = new HashSet<>();
        }
    }
    public static List<Integer> construct(int i, List<Integer> lastStop, CharNode dummy, String[] words,
                                          Map<Character,CharNode> hm){
        List<Integer> stop = new ArrayList<>();
        for(int k=0;k<lastStop.size();k++){
            CharNode lastNode = dummy;
            int start = lastStop.get(k);
            int end = k==lastStop.size()-1?words.length:lastStop.get(k+1);
            for(int j=start;j<end;j++){
                if(words[j].length()<=i) continue;
                char curChar = words[j].charAt(i);
                if(curChar==lastNode.val) continue;
                stop.add(j);
                if(!hm.containsKey(curChar)) hm.put(curChar,new CharNode(curChar));
                CharNode curNode = hm.get(curChar);
                curNode.in.add(lastNode);
                lastNode.out.add(curNode);
                lastNode = curNode;
            }
        }
        return stop;
    }
    public static String alienOrder(String[] words){
        Map<Character,CharNode> hm = new HashMap<>();
        CharNode dummy = new CharNode('*');
        List<Integer> stop = new ArrayList<>();
        int i = 0; stop.add(i);
        while(stop.size()!=0) {
            System.out.println(stop);
            stop = construct(i++,stop,dummy,words,hm);
        }
        for(CharNode cN:dummy.out)
            cN.in.remove(dummy);
        StringBuilder sb = new StringBuilder();
        while(hm.size()>0){
            CharNode nextNode = null;
            for(Character c: hm.keySet())
                if(hm.get(c).in.size()==0){
                    nextNode = hm.get(c); break;
                }
            if(nextNode==null) return "";// couldn't find the node with in-degree as 0
            sb.append(nextNode.val);
            Set<CharNode> out = nextNode.out;
            hm.remove(nextNode.val);
            for(CharNode cN: out)
                cN.in.remove(nextNode);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] words = {"wrtkj", "wrt"};
        System.out.println(alienOrder(words));
    }
}
