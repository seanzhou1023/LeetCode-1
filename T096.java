/**
 * Created by eric on 3/29/17.
 * recursion + memorization - too slow! (with the help of duality)
 * dp -> 0ms O(n^2)
 */
public class T096 {
    public static int memorize(int[] mem, int n){
        int total = 0;
        if(mem[n]!=0) return mem[n];
        else{
            if(n==0 || n==1) {mem[n]=1;total=1;}
            else if(n==2) {mem[n]=2;total=2;}
            else{
                for(int i=0;i<n/2;i++){
                    total += memorize(mem, i) * memorize(mem, n-i-1);
                }
                total *= 2;
                if(n%2==1) total += memorize(mem,n/2)*memorize(mem,n/2);
            }
        }
        return total;
    }
    public static int numTrees(int n){
        int[] mem = new int[n+1];
        return memorize(mem,n);
    }
    public static int numTreesDP(int n){
        if(n==0 || n==1) return 1;
        int[] res = new int[n+1];
        res[0] = res[1] = 1;
        for(int i=2;i<=n;i++)
            for(int j=0;j<=i-1;j++){
                res[i] += res[j]*res[i-j-1];
            }
        return res[n];
    }
    public static long factorial(int n){
        if(n<2) return 1;
        return factorial(n-1)*n;
    }
    public static long catalan(int n){
        long nom = 1, d1 = 1, d2 = 1;
        nom = factorial(2*n);
        d1 = factorial(n+1);
        d2 = factorial(n);
        return nom/d1/d2;
    }

    public static void main(String[] args) {
        System.out.println(catalan(19));
    }
}
