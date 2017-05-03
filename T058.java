/**
 * Created by eric on 2/15/17.
 */
public class T058 {
    public static int lengthOfLastWord(String s){
        if(s==null || s.length()<1)
            return 0;
        char[] ch = s.toCharArray();
        int cnt = 0, idx = ch.length-1;
        while(idx>=0 && ch[idx]==' ')
            idx--;
        while(idx>=0 && ch[idx]!=' '){
            cnt++;
            idx--;
        }
        return cnt;
    }

    public static void main(String[] args) {
        String s = "Hello World";
        System.out.println(lengthOfLastWord(s));
    }
}
