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

    //Tabulation solution
    public int cherryPickupT(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n][m][m];

        //base case states last row - having all the col1/col2 moving from 0 to m-1
        for(int j1 = 0; j1 < m; j1++){
            for(int j2 = 0; j2 < m; j2++){
                if(j1 == j2) dp[n-1][j1][j2] = grid[n-1][j1];
                else dp[n-1][j1][j2] = grid[n-1][j1] + grid[n-1][j2];
            }
        }

        //expressing all the state from n-2 to 0 each state have col moving from 0 to m-1
        for(int i = n-2; i>=0; i--){
            for(int j1 = 0; j1<m; j1++){
                for(int j2 = 0; j2<m; j2++){

                    //for particular state -computing maximum
                    int maxi = Integer.MIN_VALUE;
                    for(int dj1 = -1; dj1 <= 1; dj1++){
                        for(int dj2 = -1; dj2 <= 1; dj2++){
                            int value = 0;
                            if(j1==j2)  value = grid[i][j1];
                            else value = grid[i][j1] + grid[i][j2];
                            if(j1+dj1 >= 0 && j1+dj1 < m && j2+dj2 >=0 && j2 + dj2 < m)
                                value += dp[i+1][j1+dj1][j2+dj2];
                            else value = Integer.MIN_VALUE;

                            maxi = Math.max(maxi, value);
                        }
                    }

                    dp[i][j1][j2] = maxi;
                }
            }
        }

        return dp[0][0][m-1];

    }
}
