import java.util.*;

/**
 * Created by eric on 5/2/17.
 * recursion - top down memorization
 * and bottom up DP
 */
public class T241 {
    public List<Integer> calculate(String input, Map<String,List<Integer>> cache){
        if(cache.containsKey(input)) return cache.get(input);
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<input.length();i++){
            char c = input.charAt(i);
            if(!Character.isDigit(c)){
                List<Integer> left = calculate(input.substring(0,i), cache);
                List<Integer> right = calculate(input.substring(i+1), cache);
                cache.put(input.substring(0,i),left);
                cache.put(input.substring(i+1),right);
                for(int l: left){
                    for(int r: right){
                        switch(c){
                            case '+':res.add(l+r);break;
                            case '-':res.add(l-r);break;
                            case '*':res.add(l*r);break;
                            default:
                        }
                    }
                }
            }
        }
        if(res.size()==0) res.add(Integer.valueOf(input));
        return res;
    }
    public List<Integer> diffWaysToCompute(String input){
        if(input.length()<1) return new ArrayList<>();
        Map<String,List<Integer>> cache = new HashMap<>();
        return calculate(input, cache);
    }
    public List<Integer> diffWaysToComputeDP(String input){
        List<Integer> res = new ArrayList<>();
        if(input==null || input.length()<1) return res;
        List<String> fields = new ArrayList<>();
        int sum = 0;
        for(char c: input.toCharArray()){//parse
            if(Character.isDigit(c)){
                sum = sum*10 + c-'0';
            }else{
                fields.add(sum+"");
                sum = 0;
                fields.add(c+"");
            }
        }
        fields.add(sum+"");
        int size = (fields.size()+1)/2;
        List<Integer>[][] dp = new ArrayList[size][size];
        for(int d=0;d<size;d++){
            if(d==0){
                for(int i=0;i<size;i++){//init
                    dp[i][i] = new ArrayList<>();;
                    dp[i][i].add(Integer.valueOf(fields.get(i*2)));
                }
                continue;
            }
            for(int i=0;i+d<size;i++){
                dp[i][i+d] = new ArrayList<>();
                for(int j=i;j<i+d;j++){
                    List<Integer> left = dp[i][j], right = dp[j+1][i+d];
                    char op = fields.get(j*2+1).charAt(0);
                    for(int l: left)
                        for(int r: right){
                            switch(op){
                                case '+':dp[i][i+d].add(l+r);break;
                                case '-':dp[i][i+d].add(l-r);break;
                                case '*':dp[i][i+d].add(l*r);break;
                                default:
                            }
                        }
                }
            }
        }
        return dp[0][size-1];
    }

    public static void main(String[] args) {
        T241 t = new T241();
        System.out.println(t.diffWaysToComputeDP("2-1-1"));
    }
}
