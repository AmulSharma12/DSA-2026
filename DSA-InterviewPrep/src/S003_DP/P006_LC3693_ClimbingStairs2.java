package S003_DP;

public class P006_LC3693_ClimbingStairs2 {
    public static void main(String[] args){
        //call from here...
    }


    public static int climbStairsRecursive(int n, int[] costs) {
        if(n == 0)   return 0;

        int oneStepJumpCost = costs[n - 1] + 1 +  climbStairsRecursive(n-1, costs);
        int twoStepJumpCost=Integer.MAX_VALUE, threeStepJumpCost = Integer.MAX_VALUE;
        if(n-2 >= 0) twoStepJumpCost = costs[n - 1] + 4 + climbStairsRecursive(n-2, costs);
        if(n-3>=0) threeStepJumpCost = costs[n - 1] + 9 + climbStairsRecursive(n -3, costs);

        return Math.min(oneStepJumpCost, Math.min(twoStepJumpCost, threeStepJumpCost));
    }
}
