import java.util.*;

/**
 * Created by eric on 2/15/17.
 * https://discuss.leetcode.com/topic/12509/o-m-n-algorithm-using-hash-without-sort
 * count-sort / prime-number / codepoint
 */
public class T049 {
    public static void radix(char[] ch){
        int[] table = new int[26];
        for(char c: ch)
            table[c-'a']++;
        int i = 0, k = 0;
        while(i<ch.length){
            for(int j=0;j<table[k];j++){
                ch[i++] = (char)('a'+k);
            }
            k++;
        }
    }
    public static List<List<String>> groupAnagrams(String[] strs){
        if(strs==null||strs.length<1)
            return new ArrayList<List<String>>();
        HashMap<String,List<String>> hm = new HashMap<>();
        for(String str:strs){
            char[] ch = str.toCharArray();
            radix(ch);
            String strkey = new String(ch);
            if(str=="")
                strkey = "";
            if(!hm.containsKey(strkey))
                hm.put(strkey,new ArrayList<String>());
            hm.get(strkey).add(str);
        }
        return new ArrayList<List<String>>(hm.values());
    }
    public static List<List<String>> groupAnagramsA(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();

        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for(String str: strs){
            char[] arr = new char[26];
            for(int i=0; i<str.length(); i++){
                arr[str.charAt(i)-'a']++;
            }
            String ns = new String(arr);
            if(map.containsKey(ns)){
                map.get(ns).add(str);
            }else{
                ArrayList<String> al = new ArrayList<String>();
                al.add(str);
                map.put(ns, al);
            }
        }

        result.addAll(map.values());

        return result;
    }

    public static void main(String[] args) {
        String[] s = {};
        System.out.println(groupAnagramsA(s));
    }
}
