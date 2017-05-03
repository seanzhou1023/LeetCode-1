package sedgewick;

/**
 * Created by eric on 4/20/17.
 * 2-2 quickfind
 */
public class QuickFind {
    static int[] label;
    QuickFind(int n){
        label = new int[n];
        for(int i=0;i<n;i++)
            label[i] = i;
    }
    public static void addU(int a, int b){
        if(a>b) QuickFind.addU(b,a);
        for(int i=0;i<label.length;i++)
            if(label[i]==label[b]) label[i] = label[a];
    }
    public static boolean isConnected(int a, int b){
        return label[a] == label[b];
    }

    public static void main(String[] args) {
        QuickFind qf = new QuickFind(5);
        qf.addU(0,4);
        qf.addU(1,3);
        System.out.println(qf.isConnected(2,3));
        System.out.println(qf.isConnected(1,3));
    }
}
