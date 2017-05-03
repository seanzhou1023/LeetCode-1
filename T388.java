import java.util.*;
/**
 * Created by eric on 2/23/17.
 * once again, stack doesn't have to store the "concrete value"
 */
public class T388 {
    public static int lengthLongestPath(String input){
        Stack<Integer> stack = new Stack<>();
        String[] arr = input.split("\n");
        System.out.println(Arrays.toString(arr));
        stack.push(0);
        int maxLen = 0;
        for(String s: arr){
            int level = s.lastIndexOf("\t")+1;
            while(level+1<stack.size()) stack.pop();
            int len = stack.peek() + s.length()-level+1;
            stack.push(len);
            if(s.lastIndexOf('.')>0) maxLen = maxLen>(len-1)?maxLen:(len-1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String str = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
        String[] arr = str.split("\n");
        System.out.println(lengthLongestPath(str));
    }
}
