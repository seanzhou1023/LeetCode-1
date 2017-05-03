/**
 * Created by eric on 4/6/17.
 */
public class T211 {
    static class TrieNode{
        char val;
        boolean isEnd;
        TrieNode[] trieMap = new TrieNode[26];
        TrieNode(char val){
            this.val = val;
            isEnd = false;
        }
    }
    static class WordDictionary {
        TrieNode root;
        /** Initialize your data structure here. */
        public WordDictionary() {
            root = new TrieNode('#');
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            TrieNode cur = root;
            for(char c:word.toCharArray()){
                if(cur.trieMap[c-'a']==null)
                    cur.trieMap[c-'a'] = new TrieNode(c);
                cur = cur.trieMap[c-'a'];
            }
            cur.isEnd = true;
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            return search(word,root);
        }
        public boolean search(String word,TrieNode start){
            int i = 0;
            for(char c:word.toCharArray()){
                if(c!='.'){
                    if(start.trieMap[c-'a']==null) return false;
                    else start = start.trieMap[c-'a'];
                }else{
                    for(TrieNode tn:start.trieMap){
                        if(tn!=null){
                            if(search(word.substring(i+1,word.length()),tn))
                                return true;
                        }
                    }
                    return false;
                }
                i++;
            }
            return start.isEnd;
        }
    }

    public static void main(String[] args) {
        WordDictionary wd = new WordDictionary();
        wd.addWord("bad");
        wd.addWord("dad");
        wd.addWord("mad");
        System.out.println(wd.search("b.."));
    }
}
