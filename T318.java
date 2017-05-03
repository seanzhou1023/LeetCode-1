/**
 * Created by eric on 3/15/17.
 */
public class T318 {
    public static int maxProduct(String[] words){
        int[] value = new int[words.length];
        for(int i=0;i<words.length;i++){
            char[] tmp = words[i].toCharArray();
            for(char c:tmp)
                value[i] |= 1 << (c-'a');
        }
        int res = Integer.MIN_VALUE;
        for(int i=0;i<words.length;i++)
            for(int j=i+1;j<words.length;j++){
                if((value[i] & value[j]) == 0){
                    int mul = words[i].length()*words[j].length();
                    res = res>mul?res:mul;
                }
            }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(0|0);
    }
}
