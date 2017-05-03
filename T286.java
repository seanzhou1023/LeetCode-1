import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by eric on 3/18/17.
 */
public class T286 {
    static class Points{
        int row, col, step;
        Points(int row, int col, int step){
            this.row = row;
            this.col = col;
            this.step = step;
        }
    }
    public static void wallsAndGates(int[][] rooms){
        if(rooms==null || rooms.length<1 || rooms[0].length<1) return;
        int row = rooms.length, col = rooms[0].length;
        Queue<Points> queue = new LinkedList<>();
        int[] directions = {0,1,0,-1,0};
        for(int i=0;i<row;i++)
            for(int j=0;j<col;j++){
                if(rooms[i][j]==0){
                    Points point = new Points(i,j,0);
                    queue.offer(point);
                }
            }
        while(!queue.isEmpty()){
            Points cur = queue.poll();
            for(int i=0;i<4;i++){
                int nextRow = cur.row+directions[i];
                int nextCol = cur.col+directions[i+1];
                int step = cur.step;
                if(nextRow<0 || nextRow>row-1 || nextCol<0 || nextCol>col-1)
                    continue;
                if(rooms[nextRow][nextCol]==Integer.MAX_VALUE){
                    rooms[nextRow][nextCol] = step+1;
                    Points next = new Points(nextRow,nextCol,step+1);
                    queue.offer(next);
                }
            }
        }
    }
    public static void wallsAndGates1(int[][] rooms){
        if(rooms==null || rooms.length<1 || rooms[0].length<1) return;
        int row = rooms.length, col = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[] directions = {0,1,0,-1,0};
        for(int i=0;i<row;i++)
            for(int j=0;j<col;j++){
                if(rooms[i][j]==0){
                    int[] cur = {i,j,0};
                    queue.offer(cur);
                }
            }
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int i=0;i<4;i++){
                int nextRow = cur[0]+directions[i];
                int nextCol = cur[1]+directions[i+1];
                int step = cur[2];
                if(nextRow<0 || nextRow>row-1 || nextCol<0 || nextCol>col-1)
                    continue;
                if(rooms[nextRow][nextCol]==Integer.MAX_VALUE){
                    rooms[nextRow][nextCol] = step+1;
                    int[] next = {nextRow,nextCol,step+1};
                    queue.offer(next);
                }
            }
        }
    }


    public static void main(String[] args) {
        int INF = Integer.MAX_VALUE;
        int[][] rooms = {{0,INF,-1,INF,INF,-1,-1,0,0,-1,INF,INF,0,-1,INF,INF,INF,INF,0,INF,0,-1,-1,-1,-1,INF,-1,-1,INF,INF,-1,-1,0,0,-1,0,0,0,INF,0,INF,-1,-1,0,-1,0,0,0,INF},
                         {INF,0,-1,INF,0,-1,-1,-1,-1,0,0,INF,INF,-1,-1,INF,-1,-1,INF,INF,-1,0,-1,INF,0,INF,-1,INF,0,INF,0,INF,-1,INF,0,INF,-1,INF,0,INF,INF,0,-1,INF,-1,-1,-1,0,INF}};
        for(int i=0;i<rooms.length;i++)
            System.out.println(Arrays.toString(rooms[i]));
        wallsAndGates(rooms);
        for(int i=0;i<rooms.length;i++)
            System.out.println(Arrays.toString(rooms[i]));
    }
}
