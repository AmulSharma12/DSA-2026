package S003_DP;
import java.util.Arrays;

public class P003_LC55_JumpGame {
    public static void main(String[] args){
        //call from here...
    }

    //Recursive - solution
    public static boolean canJumpR(int[] nums) {
        int n = nums.length;
        return jumpGameR(0, nums, n);
    }

    private static boolean jumpGameR(int index, int[] nums, int size){
        if(index == size-1) return true;
        if(index >= size)   return false;

        int maxJump = nums[index];
        for(int i = 1; i<=maxJump; i++){
            if(jumpGameR(i+index, nums, size))  return true;
        }

        return false;
    }

    //Memoization solution
    public static boolean canJumpM(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return jumpGameM(0, nums, n, dp);
    }

    private static boolean jumpGameM(int index, int[] nums, int size,int[] dp){
        if(index == size-1) return true;
        if(index >= size)   return false;

        if(dp[index] != -1) return dp[index] == 0 ? false : true;

        int maxJump = nums[index];
        for(int i = 1; i<=maxJump; i++){
            if(jumpGameM(i+index, nums, size, dp)) {
                dp[index] = 1;
                return true;
            }
        }

        dp[index] = 0;
        return false;
    }
}
