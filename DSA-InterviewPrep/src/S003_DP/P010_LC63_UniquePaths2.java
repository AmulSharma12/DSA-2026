package S003_DP;
import java.util.Arrays;

public class P010_LC63_UniquePaths2 {
    public static void main(String[] args){
        //call from here...
    }
    
    //Recursive solution
    public static int uniquePathsWithObstaclesR(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        return findUniquePathsR(m-1, n-1, obstacleGrid);
    }

    private static int findUniquePathsR(int row, int col, int[][] grid){
        //base cases
        if(row < 0 || col < 0)  return 0;
        if(grid[row][col] == 1) return 0;
        if(row == 0 && col == 0)    return 1;


        //recursive calls
        int up = findUniquePathsR(row-1, col, grid);
        int left = findUniquePathsR(row, col-1, grid);

        //sum up all
        return up + left;
    }

    //Memoization solution
    public static int uniquePathsWithObstaclesM(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int[] dpRow: dp){
            Arrays.fill(dpRow,-1);
        }
        return findUniquePathsM(m-1, n-1, obstacleGrid, dp);
    }

    private static int findUniquePathsM(int row, int col, int[][] grid, int[][] dp){
        //base cases
        if(row < 0 || col < 0)  return 0;
        if(grid[row][col] == 1) return 0;
        if(row == 0 && col == 0)    return 1;
        if(dp[row][col] != -1)  return dp[row][col];

        //recursive calls
        int up = findUniquePathsM(row-1, col, grid,dp);
        int left = findUniquePathsM(row, col-1, grid,dp);

        //sum up all
        return dp[row][col] = up + left;
    }


    public static int uniquePathsWithObstaclesT(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1) return 0;
        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for(int row = 0; row < m; row++){
            for(int col = 0; col < n; col++){
                if(obstacleGrid[row][col] == 1)  {
                    dp[row][col] = 0;
                    continue;
                }else{
                    int upPath = row > 0 ? dp[row-1][col]: 0;
                    int leftPath = col > 0 ? dp[row][col-1]: 0;
                    dp[row][col] += upPath + leftPath;
                }

            }
        }

        return dp[m-1][n-1];
    }
}
