import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by eric on 3/22/17.
 * recursion/dfs is too slow, using bfs to solve shortest path 19/39
 * bfs first try failed, the queue is too big on deeper levels (wordlist: 599) 21/39
 * reason for above comes from infinite loop
 * top level tree node shouldn't be allowed in lower tree(
 * there's no need to search again, plus the path won't be shortest)
 * implementing bi-direction searching
 */
public class T127 {
    static class WordNode{
        String str;
        LinkedHashSet<WordNode> children, parents;
        WordNode(String str){
            this.str = str;
            children = new LinkedHashSet<>();
            parents = new LinkedHashSet<>();
        }
    }
    public static boolean isValid(String s, String t){
        int miss = 0;
        for(int i=0;i<s.length();i++)
            if(s.charAt(i)!=t.charAt(i)) miss++;
        return miss==1;
    }
//    public static void addChildren(Queue<WordNode> q, WordNode parent,
//                                   List<String> wordList){
//        for(String str:wordList){
//            if(!parent.parents.contains(str)
//                    && !parent.str.equals(str) && isValid(parent.str,str)){
//                WordNode cur = new WordNode(str);
//                parent.children.add(cur);//update children
//                cur.parents.addAll(parent.parents);//update parents
//                cur.parents.add(parent);
//            }
//        }
//        for(WordNode word:parent.children){
//            q.offer(word);
//        }
//    }
//    public static int ladderLength(String beginWord, String endWord,
//                                   List<String> wordList){
//        if(!wordList.contains(endWord)) return 0;
//        WordNode root = new WordNode(beginWord);
//        Queue<WordNode> q = new LinkedList<>();
//        q.offer(root);
//        int level = 0;
//        while(!q.isEmpty()){
//            int size = q.size();
//            level++;
//            System.out.println(size);
//            for(int i=0;i<size;i++){
//                WordNode curWord = q.poll();
//                if(isValid(curWord.str,endWord)){
////                    for(WordNode word:curWord.parents)
////                        System.out.println(word.str);
////                    System.out.println(curWord.parents.size());
////                    System.out.println(curWord.str);
//                    return level+1;//found it!
//                }
//                addChildren(q,curWord,wordList);
//            }
//        }
//        return 0;
//    }
    public static int ladderLength1(String beginWord, String endWord,
                            List<String> wordList){//40~ms
        Set<String> wordSet = new LinkedHashSet<>(wordList);
        if(!wordSet.contains(endWord)) return 0;// be careful with the description
        Set<String> beginSet = new LinkedHashSet<>();
        Set<String> endSet = new LinkedHashSet<>();
        Set<String> visited = new LinkedHashSet<>();
        beginSet.add(beginWord); endSet.add(endWord);
        int level = 1;
        while(!beginSet.isEmpty() && !endSet.isEmpty()){
            Set<String> nextSet = new LinkedHashSet<>();
            for(String word:beginSet){
                char[] wordArr = word.toCharArray();
                for(int i=0;i<wordArr.length;i++)
                    for(char t='a';t<='z';t++){
                        char original = wordArr[i];
                        wordArr[i] = t;
                        String changed = new String(wordArr);
                        if(endSet.contains(changed)) return level+1;
                        if(!visited.contains(changed) &&
                                wordSet.contains(changed)){
                            nextSet.add(changed);
                            visited.add(changed);
                        }
                        wordArr[i] = original;
                    }
            }
            if(nextSet.size()>endSet.size()){
                beginSet = endSet;
                endSet = nextSet;
            }
            else beginSet = nextSet;
            level++;
        }
        return 0;
    }
    public static int ladderLength(String beginWord, String endWord,
                                    List<String> wordList){//200~ms
        Set<String> wordSet = new LinkedHashSet<>(wordList);
        if(!wordSet.contains(endWord)) return 0;// be careful with the description
        Set<String> beginSet = new LinkedHashSet<>();
        Set<String> endSet = new LinkedHashSet<>();
        Set<String> visited = new LinkedHashSet<>();
        beginSet.add(beginWord); endSet.add(endWord);
        int level = 1;
        while(!beginSet.isEmpty() && !endSet.isEmpty()){
            if(beginSet.size()>endSet.size()){//swap the two sets
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }
            Set<String> nextSet = new LinkedHashSet<>();
            for(String word:beginSet){
                for(String goal:endSet){
                    if(isValid(word,goal)) return level+1;
                }
                for(String pool:wordSet){
                    if(!visited.contains(pool) && isValid(word,pool)){
                        nextSet.add(pool);
                        visited.add(pool);
                    }
                }
            }
            beginSet = nextSet;
            level++;
        }
        return 0;
    }
    public static int ladderLengthBi(String beginWord, String endWord,
                                   List<String> wordList){
        Set<String> begin = new HashSet<>();
        Set<String> end = new HashSet<>();
        begin.add(beginWord); end.add(endWord);
        int length = 1;
        Set<String> dict = new HashSet<>(wordList);
        if(!dict.contains(endWord)) return 0;
        while(!begin.isEmpty() && !end.isEmpty()){
            length++;
            Set<String> next = new HashSet<>();
            for(String word: begin){
                char[] wordChar = word.toCharArray();
                for(int i=0;i<wordChar.length;i++){//each position
                    char pre = wordChar[i];
                    for(char c='a';c<='z';c++){//change character
                        if(c-wordChar[i]==0) continue;
                        wordChar[i] = c;
                        String newWord = new String(wordChar);
                        if(end.contains(newWord)) return length;
                        if(dict.remove(newWord)) next.add(newWord);
                    }
                    wordChar[i] = pre;
                }
            }
            if(next.size()>end.size()){
                begin = end;
                end = next;
            }else begin = next;
        }
        return 0;
    }
    public static int ladderLengthSi(String beginWord, String endWord,
                                     List<String> wordList){
        Set<String> dict = new HashSet<>(wordList);
        if(!dict.contains(endWord)) return 0;
        Set<String> begin = new HashSet<>();
        begin.add(beginWord);
        int length = 1;
        while(!begin.isEmpty()){
            length++;
            Set<String> next = new HashSet<>();
            for(String word: begin){
                char[] wordChar = word.toCharArray();
                for(int i=0;i<wordChar.length;i++){
                    char pre = wordChar[i];
                    for(char c='a';c<='z';c++){
                        if(c==pre) continue;
                        wordChar[i] = c;
                        String newWord = new String(wordChar);
                        if(endWord.equals(newWord)) return length;
                        if(dict.remove(newWord)) next.add(newWord);
                    }
                    wordChar[i] = pre;
                }
            }
            begin = next;
        }
        return 0;
    }
    public static void main(String[] args) {
        String bW = "cet", eW = "ism";
        String begin = "hit", end = "cog";
        String[] str = {"kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim","ike","jed","ego","mac","baa","min","com","ill","was","cab","ago","ina","big","ilk","gal","tap","duh","ola","ran","lab","top","gob","hot","ora","tia","kip","han","met","hut","she","sac","fed","goo","tee","ell","not","act","gil","rut","ala","ape","rig","cid","god","duo","lin","aid","gel","awl","lag","elf","liz","ref","aha","fib","oho","tho","her","nor","ace","adz","fun","ned","coo","win","tao","coy","van","man","pit","guy","foe","hid","mai","sup","jay","hob","mow","jot","are","pol","arc","lax","aft","alb","len","air","pug","pox","vow","got","meg","zoe","amp","ale","bud","gee","pin","dun","pat","ten","mob"};
        String[] str1 = {"hot","dot","dog","lot","log","cog"};
        List<String> wordList = new ArrayList<>(Arrays.asList(str1));
        System.out.println(ladderLengthSi(begin,end,wordList));
    }
}
