import java.util.*;

/**
 * Created by eric on 3/22/17.
 */
public class T247 {
    private static void generate(char[] tmp, List<String> res, int n,
                                 char[] left, char[] right){
        if(n==0) {if(tmp[0]!='0') res.add(new String(tmp));}
        else if(n==1){
            for(int i=0;i<3;i++){
                tmp[tmp.length/2] = left[i];
                res.add(new String(tmp));
            }
        }else{
            for(int i=0;i<left.length;i++){
                if(n/2-1==0 && left[i]=='0') continue;
                tmp[n/2-1] = (left[i]);
                tmp[tmp.length-(n/2)] = right[i];
                generate(tmp,res,n-2,left,right);
            }
        }
    }
    public static List<String> findStrobogrammatic(int n){
        List<String> res = new ArrayList<>();
        if(n==0) return res;
        char[] left = {'0','1','8','6','9'};
        char[] right = {'0','1','8','9','6'};
        char[] tmp = new char[n];
        generate(tmp,res,n,left,right);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findStrobogrammatic(2));
    }
}
