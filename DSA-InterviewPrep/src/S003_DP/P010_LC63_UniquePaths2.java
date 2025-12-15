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
}
