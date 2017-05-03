/**
 * Created by eric on 1/30/17.
 * be careful with the "Z"
 */
public class T168 {
    public static String converToTitle(int n){
        int div = n;
        int res;
        StringBuilder str = new StringBuilder();
        while(div>0){
            res = div%26;
            div/=26;
            if(res>0)
//                has residual
                str.insert(0,Character.toString((char)(res+(int)('A')-1)));
            else{
//                no residual -> "Z"
                str.insert(0,"Z");
                div-=1;
            }

        }
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(converToTitle(26));
    }
}
