package S003_DP;
//https://www.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1

public class PC049_GFG_MCM_Tabulation {
    public static void main(String[] args){
        //call from here...
    }

    //Tabulation solution
    private static int mcmTabulation(int[] nums, int n){

        int[][] dp = new int[n][n];
        //we have base case as i equals j return 0 but bydefault its already fills to 0

        for(int i = n-1;i>0 ;i--){
            for(int j = i+1; j < n;j++){
                int mini = Integer.MAX_VALUE;

                for(int k = i; k<j; k++){
                    int steps = nums[i-1] * nums[k] * nums[j]
                            + dp[i][k]
                            + dp[k+1][j];

                    mini = Math.min(mini, steps);
                }

                dp[i][j] = mini;
            }
        }

        return dp[1][n-1];
    }
}
