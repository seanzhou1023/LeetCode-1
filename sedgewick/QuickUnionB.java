package sedgewick;

import java.util.Arrays;

/**
 * Created by eric on 4/20/17.
 */
public class QuickUnionB {
    int[] label, weight;
    QuickUnionB(int n){
        label = new int[n];
        weight = new int[n];
        for(int i=0;i<n;i++){
            label[i] = i;
            weight[i] = 1;
        }
    }
    public void addU(int a, int b){
        int _a = root(a), _b = root(b);
        if(weight[_a]>weight[_b]){
            label[_b] = _a;
            weight[_a] += weight[_b];
        }else{
            label[_a] = _b;
            weight[_b] += weight[_a];
        }
    }
    public int root(int a){
        while(a!=label[a]){
            a = label[a];
            System.out.println("0");
        }
        return a;
    }
    public boolean isConnected(int a, int b){
        return root(a) == root(b);
    }

    public static void main(String[] args) {
        QuickUnionB qu = new QuickUnionB(10);
        qu.addU(4,3);
        qu.addU(3,8);
        qu.addU(6,5);
        qu.addU(9,4);
        qu.addU(2,1);
        qu.addU(5,0);
        qu.addU(7,2);
        qu.addU(6,1);
        qu.addU(7,3);
        System.out.println(qu.isConnected(9,0));
        System.out.println(Arrays.toString(qu.label));
    }
}
