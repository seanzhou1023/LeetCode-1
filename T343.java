/**
 * Created by eric on 4/14/17.
 * https://discuss.leetcode.com/topic/43055/why-factor-2-or-3-the-math-behind-this-problem
 * using DP next time
 */
public class T343 {
    public static int integerBreak(int n){
        if(n<=2) return 1;
        if(n==3) return 2;
        int max = 0;
        for(int i=1;i<n;i++){
            if(n/i+(n%i==0?0:1)<2) continue;
            int res = 1;
            for(int j=0;j<n/i-1;j++)
                res *= i;
            int r1 = 1, r2 = 1;
            r1 = res * ((n%i==0?0:n%i)+i);
            r2 = res * i*(n%i==0?0:n%i);
            res = Math.max(r1,r2);
            max = Math.max(max,res);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(integerBreak(10));
    }
}
