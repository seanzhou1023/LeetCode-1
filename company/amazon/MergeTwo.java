package company.amazon;

import java.util.Arrays;

/**
 * Created by eric on 4/26/17.
 */
public class MergeTwo {
    public void mergeSort(int[] A, int[] B){//O(n*m) worst
        int i = 0, j = 0;
        while(i<A.length){
            if(A[i]<=B[j]) i++;
            else{
                int idx = Arrays.binarySearch(B,A[i]);
                if(idx<0) idx = -idx-1;
                int curA = A[i];
                A[i] = B[j];
                for(int k=j+1;k<idx;k++)
                    B[k-1] = B[k];
                B[idx-1] = curA;
            }
        }
    }
    public void mergeSortFaster(int[] A, int[] B){
        int adx = 0, bdx = 0;
        while(adx+bdx<A.length){
            if(A[adx]<=B[bdx]) adx++;
            else bdx++;
        }
        for(int k=adx;k<A.length;k++){
            int b = k-adx;
            int tmp = A[k];
            A[k] = B[b];
            B[b] = tmp;
        }
        Arrays.sort(A);
        Arrays.sort(B);
    }
    public static void main(String[] args) {
        int[] A = {1,3,100};
        int[] B = {2,101};
        MergeTwo mt = new MergeTwo();
        mt.mergeSortFaster(A,B);
        System.out.println(Arrays.toString(A));
        System.out.println(Arrays.toString(B));
    }
}
