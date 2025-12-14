package S003_DP;
import java.util.Arrays;
public class P009_LC62_UniquePaths {
    public static void main(String[] args){
        //call from here...
    }

    //Recursive solution
    public static int uniquePathsR(int m, int n) {
        return numberOfUniquePathsR(m-1, n-1);
    }

    private static int numberOfUniquePathsR(int row, int col){
        //base cases
        if(row == 0 && col == 0)    return 1;
        if(row < 0 || col < 0)  return 0;


        int upDirectionPaths = numberOfUniquePathsR(row-1, col);
        int leftDirectionPaths = numberOfUniquePathsR(row, col-1);

        return upDirectionPaths + leftDirectionPaths;
    }


    //Memoization solution
    public int uniquePathsM(int m, int n) {
        int[][] cache = new int[m][n];
        for(int[] currRow: cache){
            Arrays.fill(currRow,-1);
        }
        return numberOfUniquePathsM(m-1, n-1, cache);
    }

    private int numberOfUniquePathsM(int row, int col, int[][] cache){
        //base cases
        if(row == 0 && col == 0)    return 1;
        if(row < 0 || col < 0)  return 0;
        if(cache[row][col] != -1)   return cache[row][col];

        int upDirectionPaths = numberOfUniquePathsM(row-1, col, cache);
        int leftDirectionPaths = numberOfUniquePathsM(row, col-1, cache);

        return cache[row][col] = upDirectionPaths + leftDirectionPaths;
    }

    //Tabulation solution
    private int uniquePathsT(int m, int n){
        int[][] dp = new int[m][n];


        for(int row = 0 ; row < m ; row++){
            for(int col = 0; col < n; col++){
                if(row == 0 && col == 0)    dp[0][0] = 1;
                else{
                    int up = 0;
                    int left = 0;
                    if(row > 0) up = dp[row-1][col];
                    if(col > 0) left = dp[row][col-1];
                    dp[row][col] = up + left;
                }
            }
        }

        return dp[m-1][n-1];
    }

    //Space Optimization solution
    private int uniquePathsSO(int m, int n){
        int[] prev = new int[n];


        for(int row = 0 ; row < m ; row++){
            int[] temp = new int[n];
            for(int col = 0; col < n; col++){
                if(row == 0 && col == 0)    temp[0] = 1;
                else{
                    int up = 0;
                    int left = 0;
                    if(row > 0) up = prev[col];
                    if(col > 0) left = temp[col-1];
                    temp[col] = up + left;
                }
            }
            prev = temp;
        }

        return prev[n-1];
    }
}
