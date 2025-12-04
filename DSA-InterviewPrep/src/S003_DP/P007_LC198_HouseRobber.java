package S003_DP;
import java.util.Arrays;

public class P007_LC198_HouseRobber {
    public static void main(String[] args){
        //call from here...
    }

    //Recursive solution
    public static int robR(int[] nums) {
        int n = nums.length;
        return maxRobbingR(n-1, nums);
    }

    private static int maxRobbingR(int position, int[] moneyStreet){
        if(position == 0)   return moneyStreet[position];
        if(position < 0)    return 0;

        int moneyPicked = moneyStreet[position] + maxRobbingR(position -2, moneyStreet);
        int moneyNotPicked = 0 + maxRobbingR(position-1, moneyStreet);
        return Math.max(moneyPicked, moneyNotPicked);
    }

    //Memoization solution
    public static int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return maxRobbingM(n-1, nums, dp);
    }

    private static int maxRobbingM(int position, int[] moneyStreet,int[] dp){
        if(position == 0)   return moneyStreet[position];
        if(position < 0)    return 0;
        if(dp[position] != -1)  return dp[position];

        int moneyPicked = moneyStreet[position] + maxRobbingM(position -2, moneyStreet, dp);
        int moneyNotPicked = 0 + maxRobbingM(position-1, moneyStreet, dp);
        return dp[position] = Math.max(moneyPicked, moneyNotPicked);
    }

    //Tabulation solution
    public static int robT(int[] nums) {
        int n = nums.length;
        return maxRobbingT(nums,nums.length);
    }

    private static int maxRobbingT(int[] moneyStreet,int n){
        if(n == 1) return moneyStreet[n-1];
        int[] dp = new int[n];
        dp[0] = moneyStreet[0];
        dp[1] = Math.max(moneyStreet[0], moneyStreet[1]);

        for(int position =2; position <n; position++){
            int moneyPicked = moneyStreet[position] + dp[position-2];
            int moneyNotPicked = 0 + dp[position-1];
            dp[position] = Math.max(moneyPicked, moneyNotPicked);
        }

        return dp[n-1];
    }

}
