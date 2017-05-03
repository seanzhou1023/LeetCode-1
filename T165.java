import java.util.Arrays;

/**
 * Created by eric on 3/13/17.
 */
public class T165 {
    public static int compareVersion(String version1, String version2){
        String[] num1 = version1.split("\\.",0);
        String[] num2 = version2.split("\\.",0);
        int s1 = 0, s2 = 0, cnt = 0;
        while(s1<num1.length && s2<num2.length){
            int cur1 = Integer.valueOf(num1[s1]);
            int cur2 = Integer.valueOf(num2[s2]);
            if(cur1>cur2) return 1;
            else if(cur1<cur2) return -1;
            else{
                s1++;
                s2++;
            }
        }
        if(num1.length==num2.length) return 0;
        else{
            if(num1.length>num2.length){
                while(s1<num1.length){
                    cnt += Integer.valueOf(num1[s1++]);
                }
                if(cnt==0) return 0;
                else return 1;
            }else{
                while(s2<num2.length){
                    cnt += Integer.valueOf(num2[s2++]);
                }
                if(cnt==0) return 0;
                else return -1;
            }
        }
    }

    public static void main(String[] args) {
        String s1 = "1", s2 = "1.1";
        System.out.println(compareVersion(s1,s2));
    }
}
