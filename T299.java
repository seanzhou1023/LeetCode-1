/**
 * Created by eric on 3/20/17.
 */
public class T299 {
    public static String getHint(String secret, String guess){
        if(secret==null || secret.length()!=guess.length()) return "";
        int[] nums = new int[10];
        int bulls = 0, cows = 0;
        char[] sc = secret.toCharArray(), gc = guess.toCharArray();
        for(int i=0;i<sc.length;i++){
            if(sc[i]==gc[i]) bulls++;
            else nums[sc[i]-'0']++;
        }
        for(int i=0;i<gc.length;i++)
            if(sc[i]!=gc[i] && nums[gc[i]-'0']-->0){
                cows++;
            }
        return bulls+"A"+cows+"B";
    }

    public static void main(String[] args) {
        String s = "1234", g = "1222";
        System.out.println(getHint(s,g));
    }
}
