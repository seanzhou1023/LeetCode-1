/**
 * Created by eric on 3/21/17.
 */
public class T275 {
    public static int hIndex(int[] citations){
        if(citations.length<1) return 0;
        int s = 0, e = citations.length-1;
        while(s<=e){
            int m = s + (e-s)/2;
            if(citations[m]==citations.length-m) return citations[m];
            else if(citations[m]>citations.length-m) e = m - 1;
            else s = m + 1;
        }
        return citations.length-1-e;
    }

    public static void main(String[] args) {
        int[] citations = {1,1};
        System.out.println(hIndex(citations));
    }
}
