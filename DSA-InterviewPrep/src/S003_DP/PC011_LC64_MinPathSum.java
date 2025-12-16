package S003_DP;
import java.util.Arrays;

public class PC011_LC64_MinPathSum {
    public static void main(String[] args){
        //call from here...
    }

    //Recursive solution
    public static int minPathSumR(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        return minPathSumRecursive(m-1, n-1, grid);
    }

    private static int minPathSumRecursive(int row, int col, int[][] grid){
        //handling boundary case
        if(row < 0 || col < 0)  return Integer.MAX_VALUE;
        //reaching destination
        if(row == 0 &&  col == 0) return grid[0][0];



        //handling current case
        int upDirectionPathSum = minPathSumRecursive(row-1, col, grid);
        int leftDirectionPathSum = minPathSumRecursive(row, col-1, grid);

        return grid[row][col] + Math.min(upDirectionPathSum, leftDirectionPathSum);
    }

    //Memoization solution
    public static int minPathSumM(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int[] dpRow:dp){
            Arrays.fill(dpRow,-1);
        }
        return minPathSumMemoize(m-1, n-1, grid,dp);
    }

    private static int minPathSumMemoize(int row, int col, int[][] grid, int[][] dp){
        //handling boundary case
        if(row < 0 || col < 0)  return Integer.MAX_VALUE;
        //reaching destination
        if(row == 0 &&  col == 0) return grid[0][0];

        //if already cached
        if(dp[row][col] != -1)  return dp[row][col];


        //handling current case
        int upDirectionPathSum = minPathSumMemoize(row-1, col, grid, dp);
        int leftDirectionPathSum = minPathSumMemoize(row, col-1, grid, dp);

        return  dp[row][col] = grid[row][col] + Math.min(upDirectionPathSum, leftDirectionPathSum);
    }

}
