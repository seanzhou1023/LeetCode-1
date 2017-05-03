import java.util.*;

import static java.lang.System.*;

/**
 * Created by eric on 4/29/17.
 * be careful with the rotation
 */
public class T249 {
    public List<List<String>> groupStrings(String[] strings){
        Map<String, List<String>> hm = new HashMap<>();
        List<String> single = new ArrayList<>();
        for(String str: strings){
            if(str.length()==1){
                single.add(str);
                continue;
            }
            char[] ch = str.toCharArray();
            StringBuilder sb = new StringBuilder();
            for(int i=1;i<ch.length;i++){
                int offset = ch[i]-ch[i-1];
                char c = 'a';
                c += offset<0?offset+26:offset;
                sb.append(c);
            }
            String key = sb.toString();
            hm.putIfAbsent(key,new ArrayList<>());
            hm.get(key).add(str);
        }
        List<List<String>> res = new ArrayList<>(hm.values());
        if(single.size()>0) res.add(single);
        return res;
    }

    public static void main(String[] args) {
        String[] strs = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
        T249 t = new T249();
        StringBuilder sb = new StringBuilder();
        out.println(t.groupStrings(strs) instanceof RandomAccess);
    }
}
