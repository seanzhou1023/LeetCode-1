import java.util.*;

/**
 * Created by eric on 3/14/17.
 * https://discuss.leetcode.com/topic/7256/what-does-this-question-aim-to-teach/13
 * from greedy to DP
 */
public class T068 {
    public static List<String> fullJustifyDP(String[] words, int maxWidth){
        List<String> res = new ArrayList<>();
        int Length = words.length;
        int[] wordsLen = new int[Length+1];
        for(int i=1;i<Length+1;i++)
            wordsLen[i] = wordsLen[i-1]+words[i-1].length();//count word length
        int[][] cost = new int[Length][Length];//cost matrix
        for(int i=0;i<Length;i++)
            for(int j=i;j<Length;j++){
                int spaces = j>i?(j-i):0;
                int tmpCost = maxWidth-(spaces+wordsLen[j+1]-wordsLen[i]);
                cost[i][j] = tmpCost>=0?tmpCost*tmpCost:-1;
            }
        int[] minCost = new int[Length];
        int[] lineBreak = new int[Length];
        lineBreak[Length-1] = Length;
        minCost[Length-1] = cost[Length-1][Length-1];
        for(int i=Length-2;i>=0;i--){
            int minTmp = cost[i][i]+minCost[i+1];
            lineBreak[i] = i+1;
            minCost[i] = minTmp;
            for(int j=Length-1;j>i;j--){
                if(cost[i][j]==-1) continue;
                int tmpCost = j<Length-1?(cost[i][j]+minCost[j+1]):cost[i][j];
                if(tmpCost<minTmp){
                    minTmp = tmpCost;
                    lineBreak[i] = j+1;
                    minCost[i] = tmpCost;
                }
            }
        }
        int totalcost = 0;
        int start = 0;
        while(start<Length){
            int loop = lineBreak[start];
            StringBuilder[] sb = new StringBuilder[loop-start];
            for(int i=0;i<sb.length;i++)
                sb[i] = new StringBuilder();
            int less = 0;
            for(int i=start;i<loop;i++){
                sb[i-start].append(words[i]);
                less += words[i].length();
                if(i!=loop-1){
                    sb[i-start].append(" ");less++;
                }
            }
            int open = sb.length;
            int more = maxWidth-less;
//            if(open>1 && loop!=Length){
//                int spacesEven = more/(open-1);
//                for(int k=0;k<spacesEven;k++)
//                    for(int i=0;i<open-1;i++)
//                        sb[i].append(" ");
//                int spacesOdd = more%(open-1);
//                for(int k=0;k<spacesOdd;k++)
//                    sb[k].append(" ");
//            }else{
//                while(more>0){
//                    sb[sb.length-1].append(" ");
//                    more--;
//                }
//            }
            while(more>0){
                    sb[sb.length-1].append(" ");
                    more--;
            }
            for(int i=start;i<loop;i++){
                totalcost += (int)Math.pow(sb[i-start].length()-words[i-start].length(),2);
            }
            start = loop;
            StringBuilder result = new StringBuilder();
            for(int i=0;i<sb.length;i++)
                result.append(sb[i].toString());
            res.add(result.toString());
        }
        System.out.println("dp cost:"+totalcost);
        return res;
    }
    public static List<String> fullJustify(String[] words, int maxWidth){
        List<String> res = new ArrayList<String>();
        int cost = 0;
        int[] wLen = new int[words.length+1];
        for(int i=1;i<words.length+1;i++)
            wLen[i] = wLen[i-1] + words[i-1].length();
        int start = 0;
        while(start<words.length){
            int end = words.length-1;
            for(int i=start;i<words.length;i++){
                if(wLen[i+1]-wLen[start]+i-start>maxWidth){
                    end = i-1;break;
                }
            }
            StringBuilder[] sb = new StringBuilder[end-start+1];
            for(int i=0;i<sb.length;i++)
                sb[i] = new StringBuilder();
            int less = 0;
            for(int i=start;i<end+1;i++){
                sb[i-start].append(words[i]);
                less += words[i].length();
                if(i!=end){
                    sb[i-start].append(" ");less++;
                }
            }
            int open = sb.length;
            int more = maxWidth-less;
//            if(end!=words.length-1 && open>1){
//                int spacesEven = more/(open-1);
//                for(int k=0;k<spacesEven;k++)
//                    for(int i=0;i<open-1;i++)
//                        sb[i].append(" ");
//                int spacesOdd = more%(open-1);
//                for(int k=0;k<spacesOdd;k++)
//                    sb[k].append(" ");
//            }else{
//                while(more>0){
//                    sb[sb.length-1].append(" ");
//                    more--;
//                }
//            }
            while(more>0){
                sb[sb.length-1].append(" ");
                more--;
            }
            //cost
            for(int i=start;i<end+1;i++){
//                System.out.println(sb[i-start].length());
                cost += (int)Math.pow(sb[i-start].length()-words[i-start].length(),2);
            }
            start = end+1;
            StringBuilder result = new StringBuilder();
            for(int i=0;i<sb.length;i++)
                result.append(sb[i].toString());
            res.add(result.toString());
        }
        System.out.println("greedy cost:"+cost);
        return res;
    }
    public static void main(String[] args) {
        String[] tushar = {"Tushar","Roy","likes","to","code"};
        String[] test = {"What","must","be","shall","be."};
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        String str = "You better lose yourself in the music the moment" +
                " You own it you better never let it go" +
                " You only get one shot do not miss your chance to blow" +
                " This opportunity comes once in a lifetime you better";
        String[] eminem1 = str.split(" ");String[] eminem2 = str.split(" ");
//        System.out.println(Arrays.toString(eminem));
        System.out.println(fullJustify(eminem1,20));
        System.out.println(fullJustifyDP(eminem2,20));
    }
}
