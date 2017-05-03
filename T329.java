import java.util.*;

/**
 * Created by eric on 4/26/17.
 * TLE first time: 134/137
 * cache the maxLength for each cell, passed
 *
 * do it iteratively
 *
 * next time topological sort & bfs!
 * https://discuss.leetcode.com/topic/35021/graph-theory-java-solution-o-v-2-no-dfs
 */
public class T329 {
    public final int[] dir = {0,1,0,-1,0};
    static class Point{
        public int i, j, val;
        Point(int i, int j, int val){
            this.i = i;
            this.j = j;
            this.val = val;
        }
    }
    public int dfs(int[][] matrix, int i, int j, int[][] mem){
        if(mem[i][j]>0) return mem[i][j];
        int max = 1, row = matrix.length, col = matrix[0].length;
        for(int k=0;k<dir.length-1;k++){
            int r = i + dir[k], c = j + dir[k+1];
            if(r<0 || r>=row || c<0 || c>=col || matrix[r][c]<=matrix[i][j]) continue;
            int len = 1 + dfs(matrix,r,c,mem);
            max = Math.max(max,len);
        }
        mem[i][j] = max;
        return max;
    }
    public int longestIncreasingPath(int[][] matrix){
        if(matrix==null || matrix.length<1) return 0;
        int row = matrix.length, col = matrix[0].length;
        int[][] mem = new int[row][col];
        int max = 1;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                int len = dfs(matrix,i,j,mem);
                max = Math.max(max, len);
            }
        }
        for(int i=0;i<row;i++)
            System.out.println(Arrays.toString(mem[i]));
        return max;
    }
    public int longestIncreasingPathIt(int[][] matrix){
        if(matrix==null || matrix.length<1) return 0;
        int row = matrix.length, col = matrix[0].length, max = 1;
        int[][] mem = new int[row][col];
        PriorityQueue<Point> maxPQ = new PriorityQueue<>(new Comparator<Point>() {
            public int compare(Point o1, Point o2) {
                return o2.val-o1.val;
            }
        });
        for(int i=0;i<row;i++)
            for(int j=0;j<col;j++)
                maxPQ.offer(new Point(i,j,matrix[i][j]));
        while(!maxPQ.isEmpty()){
            Point cur = maxPQ.poll();
            mem[cur.i][cur.j] = 1;
            for(int k=0;k<dir.length-1;k++){
                int r = cur.i + dir[k], c = cur.j + dir[k+1];
                if(r<0 || c<0 || r>=row || c>=col || cur.val>=matrix[r][c]) continue;
                mem[cur.i][cur.j] = Math.max(mem[cur.i][cur.j], mem[r][c] + 1);
            }
            max = Math.max(mem[cur.i][cur.j], max);
        }
        return max;
    }
    public static void main(String[] args) {
        T329 t = new T329();
        int[][] matrix = {{7,7,5},
                          {2,4,6},
                          {8,2,0}};
        System.out.println(t.longestIncreasingPathIt(matrix));
    }
}
