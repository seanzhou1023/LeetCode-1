/**
 * Created by eric on 4/5/17.
 */
public class T208 {
    static class Trie {
        static class TrieNode{//setter getter omit
            char val;
            boolean isEnd;
            TrieNode[] trieMap;
            public TrieNode(char val){
                trieMap = new TrieNode[26];
                this.val = val;
                isEnd = false;
            }
        }

        TrieNode root;
        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode('#');
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode parent = root;
            for(char c:word.toCharArray()){
                if(parent.trieMap[c-'a']==null)
                    parent.trieMap[c-'a'] = new TrieNode(c);
                parent = parent.trieMap[c-'a'];
            }
            parent.isEnd = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            char[] sc = word.toCharArray();
            int i=0;
            TrieNode parent = root;
            for(;i<sc.length;i++){
                if(parent.trieMap[sc[i]-'a']==null) break;
                else parent = parent.trieMap[sc[i]-'a'];
            }
            return i==sc.length && parent.isEnd;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            char[] sc = prefix.toCharArray();
            int i=0;
            TrieNode parent = root;
            for(;i<sc.length;i++){
                if(parent.trieMap[sc[i]-'a']==null) break;
                else parent = parent.trieMap[sc[i]-'a'];
            }
            return i==sc.length;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("catch");
        System.out.println(trie.search("cat"));
    }
}
