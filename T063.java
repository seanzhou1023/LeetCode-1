/**
 * Created by eric on 3/20/17.
 */
public class T063 {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid){
        if(obstacleGrid.length<0) return 0;
        int row = obstacleGrid.length, col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];
        for(int i=0;i<row;i++){
            if(obstacleGrid[i][0]==1) break;
            else dp[i][0] = 1;
        }
        for(int i=0;i<col;i++){
            if(obstacleGrid[0][i]==1) break;
            else dp[0][i] = 1;
        }
        for(int i=1;i<row;i++)
            for(int j=1;j<col;i++){
                if(obstacleGrid[i][j]!=1) dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        return dp[row-1][col-1];
    }
}
