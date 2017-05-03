import java.util.*;

/**
 * Created by eric on 3/22/17.
 * find shortest length + dfs pruning -> TLE 21/39
 * record the level and next words: 298 ms
 * try two-end next time
 */
public class T126 {
    public static boolean addNext(Set<String> dict, Map<String,Set<String>> nextWords,
                           Set<String> next, Map<String,Integer> levels,
                           String word, String endWord, int length){
        boolean found = false;
        char[] wordChar = word.toCharArray();
        for(int i=0;i<wordChar.length;i++){
            char pre = wordChar[i];
            for(char c='a';c<='z';c++){
                if(c==pre) continue;
                wordChar[i] = c;
                String newWord = new String(wordChar);
                if(newWord.equals(endWord)) found = true;
                if(dict.contains(newWord)){
                    next.add(newWord);
                    nextWords.putIfAbsent(word,new HashSet<>());
                    if(nextWords.get(word).add(newWord))
                        levels.put(word,length);
                }
            }
            wordChar[i] = pre;
        }
        return found;
    }
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);
        Set<String> begin = new HashSet<>();
        Map<String,Set<String>> nextWords = new HashMap<>();
        Map<String,Integer> levels = new HashMap<>();
        begin.add(beginWord);
        boolean found = false;
        int length = 0;
        while(!begin.isEmpty()){
            length++;
            Set<String> next = new HashSet<>();
            for(String word: begin){
                found |= addNext(dict,nextWords,next,levels,word,endWord,length);
            }
            if(found) break;
            dict.removeAll(begin);
            begin = next;
        }
        if(!found) return res;
        levels.put(endWord,length+1);
        List<String> tmp = new ArrayList<>();
        tmp.add(beginWord);
        generate(res,tmp,nextWords,levels,beginWord,endWord);
        return res;
    }
    public static void generate(List<List<String>> res, List<String> tmp, Map<String,Set<String>> nextWords,
                           Map<String,Integer> levels,String beginWord, String endWord){
        if(endWord.equals(beginWord)){
            res.add(new ArrayList<>(tmp));
        }else{
            for(String word: nextWords.get(beginWord)){
                if(levels.get(word)!=null && levels.get(word)==levels.get(beginWord)+1){
                    tmp.add(word);
                    generate(res,tmp,nextWords,levels,word,endWord);
                    tmp.remove(tmp.size()-1);
                }
            }
        }
    }
    public static void main(String[] args) {
//        String bW = "qa", eW = "sq";
//        String[] wL = {"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"};
//        System.out.println(wL.length);
        String begin = "hot", end = "dog";
        String[] words = {"hot","cog","dog","tot","hog","hop","pot","dot"};
        List<String> wordList = new ArrayList<>(Arrays.asList(words));
        System.out.println(findLadders(begin,end,wordList));
    }
}
