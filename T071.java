import java.util.*;

/**
 * Created by eric on 4/22/17.
 */
public class T071 {
    public String simplifyPath(String path){
        String[] stack = new String[path.length()];
        int pos = 0;
        for(String str: path.split("/")){
            if(str.equals("..")){
                if(pos!=0) pos--;
            }
            else if(str.length()!=0 && !str.equals(".")) stack[pos++] = str;
        }
        StringBuilder sb = new StringBuilder("/");
        for(int i=0;i<pos;i++) sb.append(stack[i]).append("/");
        if(pos>0) sb.setLength(sb.length()-1);
        return sb.toString();
    }

    public static void main(String[] args) {
        T071 t = new T071();
        System.out.println(t.simplifyPath("/."));
    }
}
