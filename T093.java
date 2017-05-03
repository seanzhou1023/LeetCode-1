import java.util.*;

/**
 * Created by eric on 3/16/17.
 * more elegant with pruning next time
 */
public class T093 {
    public static List<String> restoreIpAddresses(String s){
        List<String> res = new ArrayList<>();
        int len = s.length();
        for(int a=1;a<4;a++)
            for(int b=1;b<4;b++)
                for(int c=1;c<4;c++)
                    for(int d=1;d<4;d++){
                        if(a+b+c+d==len){
                            int A = Integer.valueOf(s.substring(0,a));
                            int B = Integer.valueOf(s.substring(a,a+b));
                            int C = Integer.valueOf(s.substring(a+b,a+b+c));
                            int D = Integer.valueOf(s.substring(a+b+c,a+b+c+d));
                            if(A<256 && B<256 && C<256 && D<256){
                                String tmp = A+"."+B+"."+C+"."+D;
                                if(tmp.length()==s.length()+3) res.add(tmp);
                            }
                        }
                    }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("25525511135"));
    }
}
