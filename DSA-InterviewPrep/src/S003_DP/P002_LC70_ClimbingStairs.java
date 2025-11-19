package S003_DP;

public class P002_LC70_ClimbingStairs {
    public static void main(String[] args){
        //call from here..
    }

    //recursive way - TLE
    public static int climbStairsRecursive(int n) {
        if(n == 0)  return 1;
        if(n < 0)   return 0;

        int oneStep = climbStairsRecursive(n - 1);
        int twoStep = climbStairsRecursive(n - 2);

        return oneStep + twoStep;
    }
}
