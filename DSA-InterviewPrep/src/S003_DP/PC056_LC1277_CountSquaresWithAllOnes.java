package S003_DP;
//https://leetcode.com/problems/count-square-submatrices-with-all-ones/
public class PC056_LC1277_CountSquaresWithAllOnes {
    public static void main(String[] args){
        //call from here...
    }

    public static int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        int totalSquares = 0;
        for(int row = 1; row <n; row++) {
            dp[row][0] = matrix[row][0];
            totalSquares += dp[row][0];
        }
        for(int col = 0; col < m; col++){
            dp[0][col] = matrix[0][col];
            totalSquares += dp[0][col];
        }

        for(int row = 1; row < n; row++){
            for(int col = 1; col < m; col++){
                if(matrix[row][col] == 0)   dp[row][col] = 0;
                else{
                    dp[row][col] = 1 + Math.min(dp[row-1][col-1], Math.min(dp[row-1][col], dp[row][col-1]));
                }

                totalSquares += dp[row][col];
            }

        }

        return totalSquares;
    }
}
