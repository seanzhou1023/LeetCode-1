import java.util.Arrays;

/**
 * Created by eric on 3/4/17.
 */
public class T223 {
    public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H){
        int total = (C-A)*(D-B)+(G-E)*(H-F);
        if(E>=C || G<=A || F>=D || H<=B)
            return total;
        int x1 = Math.max(A,E), x2 = Math.min(C,G);
        int y1 = Math.max(B,F), y2 = Math.min(D,H);
        return total-(x2-x1)*(y2-y1);
    }

    public static void main(String[] args) {
        int A=-2, B=-2, C=2, D=2, E=3, F=3, G=4, H=4;
        System.out.println(computeArea(A,B,C,D,E,F,G,H));
    }
}
