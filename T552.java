/**
 * Created by eric on 4/15/17.
 * classic!
 */
public class T552 {
    static int mod = 1000000007;
    public static int checkRecord(int n){
        long[] PorL = new long[n+1], P = new long[n+1];
        PorL[0] = P[0] = 1;
        PorL[1] = 2; P[1] = 1;
        for(int i=2;i<=n;i++){
            P[i] = PorL[i-1];
            PorL[i] = (P[i]+P[i-1]+P[i-2]) % mod;
        }

        long res = PorL[n];
        for(int i=0;i<n;i++){
            long s = (PorL[i] * PorL[n-i-1]) % mod;
            res += (res + s) % mod;
        }
        return (int)res;
    }
}
