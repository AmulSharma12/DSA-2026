package S003_DP;
import java.util.List;
import java.util.Arrays;

public class PC012_LC120_Triangle {
    public static void main(String[] args){
        //call from here...
    }

    //Recursive solution
    public static int minimumTotalR(List<List<Integer>> triangle) {
        int n = triangle.size();
        return minPathSumRec(0,0, triangle, n);
    }

    private static int minPathSumRec(int row, int col, List<List<Integer>> triangle, int n){
        //base case
        if(row == n-1)  return triangle.get(row).get(col);

        int downPathSum = triangle.get(row).get(col) + minPathSumRec(row+1, col, triangle, n);
        int diagonalPathSum = triangle.get(row).get(col) + minPathSumRec(row+1, col+1, triangle, n);
        return Math.min(downPathSum, diagonalPathSum);
    }

    //Memoization solution
    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for(int[] dpRow:dp){
            Arrays.fill(dpRow, Integer.MAX_VALUE);
        }
        return minPathSumMem(0,0, triangle, n,dp);
    }

    private static int minPathSumMem(int row, int col, List<List<Integer>> triangle, int n, int[][] dp){
        //base case
        if(row == n-1)  return triangle.get(row).get(col);
        if(dp[row][col] != Integer.MAX_VALUE)  return dp[row][col];

        int downPathSum = triangle.get(row).get(col) + minPathSumMem(row+1, col, triangle, n, dp);
        int diagonalPathSum = triangle.get(row).get(col) + minPathSumMem(row+1, col+1, triangle, n, dp);
        return dp[row][col] = Math.min(downPathSum, diagonalPathSum);
    }


    //Tabulation solution
    private static int minPathSumTabulation(List<List<Integer>> triangle){
        int n = triangle.size();
        //1. dp states
        int[][] dp = new int[n][n];

        //base case creation (n-1) row
        for(int col = 0; col <n; col++){
            dp[n-1][col] = triangle.get(n-1).get(col);
        }


        //looping the remaing states row wise from n-2
        for(int row = n-2; row >= 0 ;row--){
            for(int col = row; col >= 0 ; col--){
                int downPathSum = triangle.get(row).get(col) + dp[row+1][col];
                int diagonalPathSum = triangle.get(row).get(col) + dp[row+1][col+1];
                dp[row][col] = Math.min(downPathSum, diagonalPathSum);
            }
        }

        return dp[0][0];
    }
}
