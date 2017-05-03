/**
 * Created by eric on 4/23/17.
 * handle overflow!
 */
public class T029 {
    public static int recurse(long x, long y, int count){
        if(x<=0 || count==0) return 0;
        else if(y>x) return recurse(x,y>>1,count>>>1);
        else return recurse(x-y,y+y,count+count)+count;
    }
    public static int divide(int a, int b){
        if(a==Integer.MIN_VALUE){
            if(b==-1) return Integer.MAX_VALUE;//this is the only tricky part
        }
        long x = a>0?(long)a:-(long)a;
        long y = b>0?(long)b:-(long)b;
        int res = recurse(x,y,1);
        if(a<0 && b<0) return res;
        if(a<0 || b<0) return -res;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(divide(Integer.MAX_VALUE,Integer.MIN_VALUE));
    }
}
