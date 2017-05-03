/**
 * Created by eric on 2/28/17.
 * if we count the number div onebyone, time limit exceed
 */
public class T319 {
    public static int bulbSwitch(int n){
        return (int)Math.sqrt(n);
    }

    public static void main(String[] args) {
        System.out.println(bulbSwitch(6));
    }
}
