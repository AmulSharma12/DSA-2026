package S003_DP;
import java.util.Arrays;
public class PC013_LC1463_CherryPickup2 {
    public static void main(String[] args){
        //call from here...
    }

    //Recursive solution
    private static int cherryPickupRecursive(int row, int col1, int col2, int m, int n, int[][] grid){
        if(col1 < 0 || col2 < 0 || col1 >= n || col2 >= n) return Integer.MIN_VALUE;
        if(row == m-1) {
            if(col1==col2)  return grid[row][col1];
            return grid[row][col1] + grid[row][col2];
        }

        int maxi = Integer.MIN_VALUE;
        for(int dj1 = -1; dj1 <= 1 ; dj1++){
            for(int dj2 = -1; dj2 <= 1; dj2++){
                int value = 0;
                if(col1==col2)  value =  grid[row][col1];
                else value = grid[row][col1] + grid[row][col2];
                value += cherryPickupRecursive(row+1, col1+dj1, col2+dj2, m, n, grid);
                maxi = Math.max(maxi, value);
            }
        }

        return maxi;
    }

    public static int cherryPickupR(int[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        return cherryPickupRecursive(0, 0, colLen-1, rowLen, colLen, grid);
    }

    //Memoization solution
    private static int cherryPickupMemoization(int row, int col1, int col2, int m, int n, int[][] grid, int[][][] dp){
        if(col1 < 0 || col2 < 0 || col1 >= n || col2 >= n) return Integer.MIN_VALUE;
        if(row == m-1) {
            if(col1==col2)  return grid[row][col1];
            return grid[row][col1] + grid[row][col2];
        }

        if(dp[row][col1][col2] != -1)   return dp[row][col1][col2];

        int maxi = Integer.MIN_VALUE;
        for(int dj1 = -1; dj1 <= 1 ; dj1++){
            for(int dj2 = -1; dj2 <= 1; dj2++){
                int value = 0;
                if(col1==col2)  value =  grid[row][col1];
                else value = grid[row][col1] + grid[row][col2];
                value += cherryPickupMemoization(row+1, col1+dj1, col2+dj2, m, n, grid, dp);
                maxi = Math.max(maxi, value);
            }
        }

        return dp[row][col1][col2] =  maxi;
    }

    public static int cherryPickupM(int[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        int[][][] dp = new int[rowLen][colLen][colLen];

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return cherryPickupMemoization(0, 0, colLen-1, rowLen, colLen, grid, dp);
    }
}
