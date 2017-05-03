/**
 * Created by eric on 3/13/17.
 */
public class T335 {
    public static boolean cross14(int n1, int n2, int n3, int n4){
        return (n1-n3)>=0 && (n4-n2)>=0;
    }
    public static boolean cross15(int n1, int n2, int n3, int n4, int n5){
        return (n2==n4) && (n1+n5>=n3);
    }
    public static boolean cross16(int n1, int n2, int n3, int n4, int n5, int n6){
        return (n4>n2) && (n1<n3) && (n5<n3 && n5+n1>=n3) && (n4-n6<=n2);
    }
    public static boolean isSelfCrossing(int[] x){
        if(x.length>=4){
            for(int i=x.length-4;i<x.length-3;i++)
                if(cross14(x[i],x[i+1],x[i+2],x[i+3])) return true;
        }
        if(x.length>=5){
            for(int i=x.length-5;i<x.length-4;i++){
                if(cross14(x[i],x[i+1],x[i+2],x[i+3])) return true;
                if(cross15(x[i],x[i+1],x[i+2],x[i+3],x[i+4])) return true;
            }
        }
        for(int i=0;i<x.length-5;i++){
            if(cross14(x[i],x[i+1],x[i+2],x[i+3])) return true;
            if(cross15(x[i],x[i+1],x[i+2],x[i+3],x[i+4])) return true;
            if(cross16(x[i],x[i+1],x[i+2],x[i+3],x[i+4],x[i+5])) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] x = {1,2,3,4};
        System.out.println(isSelfCrossing(x));
    }
}
