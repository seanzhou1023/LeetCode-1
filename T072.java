import java.util.Arrays;

/**
 * Created by eric on 2/9/17.
 */
public class T072 {
    public static int minDistance(String word1, String word2){
        int l1 = word1.length(), l2 = word2.length();
        if(l1==0)
            return l2;
        if(l2==0)
            return l1;
        int[][] res = new int[l1+1][l2+1];
        for(int i=0;i<l1;i++)
            res[i][l2] = l1-i;
        for(int i=0;i<l2;i++)
            res[l1][i] = l2-i;
        for(int i=l1-1;i>=0;i--){
            for(int j=l2-1;j>=0;j--){
                if(word1.charAt(i)==word2.charAt(j))
                    res[i][j] = res[i+1][j+1];
                else{
                    res[i][j] = res[i+1][j+1]<res[i][j+1]?res[i+1][j+1]:res[i][j+1];
                    res[i][j] = res[i][j]<res[i+1][j]?res[i][j]:res[i+1][j];
                    res[i][j]++;
                }
            }
        }
        return res[0][0];
    }

    public static void main(String[] args) {
        String word1 = "apple";
        String word2 = "ie";
        System.out.println(minDistance(word1,word2));
    }
}
