package S003_DP;

public class PC019_GFG_01Knapsack {
    public static void main(String[] args){
        //call from here...
    }

    //Recursive solution
    public static int knapsack(int W, int val[], int wt[]) {
        int n = val.length;
        return knapsackRecursive(n-1, val, wt, W);
    }

    private static int knapsackRecursive(int index, int[] val,int[] wt, int W){
        //base case
        if(index == 0){
            if(wt[0] <= W)   return val[0];
            return 0;
        }

        int notTake = 0 + knapsackRecursive(index-1, val, wt, W);
        int take = Integer.MIN_VALUE;
        if(wt[index]  <= W)
            take = val[index] + knapsackRecursive(index-1, val, wt, W-wt[index]);

        return Math.max(take, notTake);
    }
}
