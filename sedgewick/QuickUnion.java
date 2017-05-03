package sedgewick;

import java.util.Arrays;

/**
 * Created by eric on 4/20/17.
 * addU - O(1)
 * isConnected - O(logn)? not it should be O(n), the tree could be skew
 */
public class QuickUnion {
    int[] label;
    QuickUnion(int n){
        label = new int[n];
        for(int i=0;i<n;i++) label[i] = i;
    }
    public void addU(int a, int b){
        int ra = root(a), rb = root(b);
        label[rb] = ra;
    }
    public int root(int a){
        while(a!=label[a]){
            a = label[a];// O(n)
            System.out.println("0");
        }
        return a;
    }
    public boolean isConnected(int a, int b){
        return root(a) == root(b);
    }

    public static void main(String[] args) {
        QuickUnion qu = new QuickUnion(10);
        qu.addU(4,3);
        qu.addU(3,8);
        qu.addU(6,5);
        qu.addU(9,4);
        qu.addU(2,1);
        qu.addU(5,0);
        qu.addU(7,2);
        qu.addU(6,1);
        qu.addU(7,3);
        System.out.println(qu.isConnected(0,9));
//        System.out.println(qu.root(9)+":"+qu.root(0));
        System.out.println(Arrays.toString(qu.label));
    }
}
