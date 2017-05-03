import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by eric on 4/15/17.
 * next time make the code shorter
 */
public class T500 {
    public static String[] findWords(String[] words){
        Set<Character> r1 = new HashSet<>();
        r1.addAll(Arrays.asList('q','w','e','r','t','y','u','i','o','p'));
        Set<Character> r2 = new HashSet<>();
        r2.addAll(Arrays.asList('a','s','d','f','g','h','j','k','l'));
        Set<Character> r3 = new HashSet<>();
        r3.addAll(Arrays.asList('z','x','c','v','b','n','m'));
        Set<Integer> idx = new HashSet<>();
        for(int i=0;i<words.length;i++){
            char[] wc = words[i].toLowerCase().toCharArray();
            Set<Character> cur;
            if(r1.contains(wc[0])) cur = r1;
            else if(r2.contains(wc[0])) cur = r2;
            else cur = r3;
            boolean consistent = true;
            for(int j=1;j<wc.length;j++)
                if(!cur.contains(wc[j])) {
                    consistent = false;
                    break;
                }
            if(consistent) idx.add(i);
        }
        String[] result = new String[idx.size()];
        Iterator<Integer> it = idx.iterator();
        for(int i=0;i<result.length;i++)
            result[i] = words[it.next()];
        return result;
    }

    public static void main(String[] args) {
        String[] words = {"Hello","Alaska","Dad","Peace"};
        System.out.println(Arrays.toString(findWords(words)));
    }
}
