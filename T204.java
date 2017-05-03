import java.util.Arrays;

/**
 * Created by eric on 3/10/17.
 */
public class T204 {
    public static int countPrimes(int n){
        boolean[] comb = new boolean[n];
        int cnt = 0;
        for(int i=2;i<n;i++){
            if(!comb[i]){
                cnt++;
                if(i*i<n){
                    for(int k=i;k*i<n;k++){
                        comb[i*k] = true;
                    }
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(17));
    }
}
