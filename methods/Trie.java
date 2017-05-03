package methods;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eric on 4/5/17.
 */
public class Trie {
    public class Result{
        public boolean isPrefix;
        public List<Integer> restIdx;
        Result(boolean isPrefix, List<Integer> restIdx){
            this.isPrefix = isPrefix;
            this.restIdx = restIdx;
        }
        public String toString(){
            return "isPrefix: "+isPrefix+" "+restIdx.toString();
        }
    }
    static class TrieNode{//setter getter omit
        char val;
        boolean isEnd;
        int idx;
        TrieNode[] trieMap;
        List<Integer> restIdx;
        public TrieNode(char val){
            trieMap = new TrieNode[26];
            this.val = val;
            this.isEnd = false;
            restIdx = new ArrayList<>();
        }
    }

    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode('#');
    }

    /** Inserts a word into the trie. */
    public void insert(String word, int idx) {
        TrieNode parent = root;
        for(char c:word.toCharArray()){
            if(parent.trieMap[c-'a']==null){
                parent.trieMap[c-'a'] = new TrieNode(c);
            }
            parent = parent.trieMap[c-'a'];
            parent.restIdx.add(idx);
        }
        parent.isEnd = true;
        parent.idx = idx;
    }
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public Result startsWithRe(String prefix) {
        char[] sc = prefix.toCharArray();
        int i=sc.length-1;
        TrieNode parent = root;
        for(;i>=0;i--){
            if(parent.trieMap[sc[i]-'a']==null) break;
            else parent = parent.trieMap[sc[i]-'a'];
        }
        List<Integer> res = parent.restIdx;
        Result result = new Result(i==-1,res);
        return result;
    }

    public Result startsWith(String prefix) {
        char[] sc = prefix.toCharArray();
        int i=0;
        TrieNode parent = root;
        for(;i<sc.length;i++){
            if(parent.trieMap[sc[i]-'a']==null) break;
            else parent = parent.trieMap[sc[i]-'a'];
        }
        List<Integer> res = parent.restIdx;
        Result result = new Result(i==sc.length,res);
        return result;
    }
}
